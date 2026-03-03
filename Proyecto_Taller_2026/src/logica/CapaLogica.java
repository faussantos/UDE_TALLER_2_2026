package logica;

import java.time.LocalDate;
import java.util.Set;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

import logica.postres.*;
import logica.ventas.*;
import persistencia.Persistencia;
import value_objects.*;
import excepciones.*;

public class CapaLogica extends UnicastRemoteObject implements ICapaLogica{

	private static CapaLogica instancia;
	
	private Ventas secVentas;
	private Postres dicPostres;
	private Monitor monitor;
	private Persistencia persistencia;

	private CapaLogica() throws RemoteException {
		secVentas = new Ventas();
		dicPostres = new Postres();
		persistencia = new Persistencia();
		monitor = new Monitor();
	}

	public static CapaLogica getInstancia() throws RemoteException {
		
		if(instancia == null)
			instancia = new CapaLogica();
		
		return instancia;
	}
	
	public void AltaPostre(VO_Postre datosPostre) throws ExistePostreException, InterruptedException  {
		
		monitor.comienzoEscritura();
		
		if (dicPostres.Member(datosPostre.getCodigo())) {
			monitor.terminoEscritura();
			String msg = "El código ingresado ya está registrado para un postre";
			throw new ExistePostreException(msg);
		}
		Postre postre;

		if (datosPostre instanceof VO_Light) {
			VO_Light datosLight = (VO_Light) datosPostre;
			postre = new Light(datosLight.getCodigo(), datosLight.getNombre(), datosLight.getPrecio(),
					datosLight.getEndulzante(), datosLight.getDescripcion());
		} else {
			postre = new Postre(datosPostre.getCodigo(), datosPostre.getNombre(), datosPostre.getPrecio());
		}

		dicPostres.Insert(postre);
		monitor.terminoEscritura();
	}

	public VO_Postre[] ListadoPostres() throws InterruptedException {

		monitor.comienzoLectura();
		VO_Postre[] resultado = dicPostres.ListarPostres();
		monitor.terminoLectura();
		return resultado;
	}

	public VO_Postre detallePostre(VO_CodigoPostre codigoPostre) throws NoExistePostreException, InterruptedException  {

		monitor.comienzoLectura();
		
		if (!dicPostres.Member(codigoPostre.getCodigoPostre())) {
			monitor.terminoLectura();
			throw new NoExistePostreException("El código ingresado no está registrado para ningún postre");
		}
		
		Postre postreBuscado = dicPostres.Find(codigoPostre.getCodigoPostre());

		VO_Postre datosDevolver;
		
		if (postreBuscado instanceof Light) {
			datosDevolver = new VO_Light(postreBuscado.getCodigo(), postreBuscado.getNombre(),
					postreBuscado.getPrecio(), ((Light) postreBuscado).getEndulzante(),
					((Light) postreBuscado).getDescripcion());
		} else {

			datosDevolver = new VO_Postre(postreBuscado.getCodigo(), postreBuscado.getNombre(),
					postreBuscado.getPrecio());
		}

		monitor.terminoLectura();
		return datosDevolver;
	}

	public void inicioVenta(VO_VentaBasico datosVenta) throws FechaMayorUltimaVentaException, InterruptedException {
		// Revisar excepcion
		
		monitor.comienzoEscritura();
		
		Venta ultimaVenta = secVentas.getUltimaVenta();
		if (ultimaVenta != null && ultimaVenta.getFecha().isBefore(datosVenta.getFecha())) {
			monitor.terminoEscritura();
			throw new FechaMayorUltimaVentaException("La fecha de la nueva venta no puede ser menor que la de la última venta registrada");
		}

		Venta nuevaVenta = new Venta(datosVenta.getFecha(), datosVenta.getDireccion(), true, 0);

		if (secVentas.EsVacia())
			nuevaVenta.setNumero(1);
		else {
			nuevaVenta.setNumero(ultimaVenta.getNumero() + 1);
		}
		secVentas.InsBack(nuevaVenta);
		monitor.terminoEscritura();
	}

	public void agregarPostreEnVenta(VO_DetalleVenta datosDetalle) throws CantidadNegativaException,
			CantidadMayor40Exception, NoExistePostreException, NoExisteNumeroVentaException, VentaNoEnProcesoException, InterruptedException {

		monitor.comienzoEscritura();
		
		if (datosDetalle.getCantidad() <= 0) {
			monitor.terminoEscritura();
			throw new CantidadNegativaException("La cantidad ingresada debe ser mayor a 0");
		}
		if (datosDetalle.getCantidad() > 40) {
			monitor.terminoEscritura();
			throw new CantidadMayor40Exception("La cantidad de postres ingresados no puede superar las 40 unidades");
		}
		if (!dicPostres.Member(datosDetalle.getCodigoPostre())) {
			monitor.terminoEscritura();
			throw new NoExistePostreException("El código ingresado no está registrado para ningún postre");
		}
		if (!secVentas.Member(datosDetalle.getNumeroVenta())) {
			monitor.terminoEscritura();
			throw new NoExisteNumeroVentaException("El número ingresado no está registrado para ninguna venta");
		}

		Venta ventaBuscada = secVentas.Find(datosDetalle.getNumeroVenta());

		if (!ventaBuscada.getEnProceso()) {
			monitor.terminoEscritura();
			throw new VentaNoEnProcesoException("La venta ya está finalizada, no le puede agregar más postres");
		}

		if ((ventaBuscada.getTotalUnidades() + datosDetalle.getCantidad()) > 40) {
			monitor.terminoEscritura();
			throw new CantidadMayor40Exception("La suma total de cantidades de una venta no puede superar las 40 unidades");
		}

		if (ventaBuscada.ExisteDetalle(datosDetalle.getCodigoPostre())) {
			DetalleVenta detalleBuscado = ventaBuscada.getDetalle(datosDetalle.getCodigoPostre());
			detalleBuscado.setCantidad(detalleBuscado.getCantidad() + datosDetalle.getCantidad());
		} else {
			Postre ingresarPostre = dicPostres.Find(datosDetalle.getCodigoPostre());
			DetalleVenta nuevoDetalle = new DetalleVenta(datosDetalle.getCantidad(), ingresarPostre);
			ventaBuscada.InsertarDetalle(nuevoDetalle);

		}
		secVentas.Modify(ventaBuscada);
		monitor.terminoEscritura();
	}

	public void eliminarPostreEnVenta(VO_DetalleVenta datosDetalle) throws CantidadNegativaException,
			NoExisteNumeroVentaException, NoExistePostreException, VentaNoEnProcesoException, InterruptedException  {

		monitor.comienzoEscritura();
		
		if (datosDetalle.getCantidad() <= 0) {
			monitor.terminoEscritura();
			throw new CantidadNegativaException("La cantidad ingresada debe ser mayor a 0");
		}

		if (!secVentas.Member(datosDetalle.getNumeroVenta())) {
			monitor.terminoEscritura();
			throw new NoExisteNumeroVentaException("El codigo ingresado no corresponde a ninguna venta");
		}

		Venta venta = secVentas.Find(datosDetalle.getNumeroVenta());

		if (!venta.getEnProceso()) {
			monitor.terminoEscritura();
			throw new VentaNoEnProcesoException("La venta ya esta finalizada, no se pueden eliminar postres");
		}

		if (!venta.ExisteDetalle(datosDetalle.getCodigoPostre())) {
			monitor.terminoEscritura();
			throw new NoExistePostreException("El postre no existe en esta venta");
		}

		DetalleVenta detalle = venta.getDetalle(datosDetalle.getCodigoPostre());
		int cantidadActual = detalle.getCantidad();
		int cantidadEliminar = datosDetalle.getCantidad();

		if (cantidadEliminar >= cantidadActual)
			venta.BorrarDetalle(detalle.getPostre().getCodigo());
		else
			detalle.setCantidad(cantidadActual - cantidadEliminar);
		
		monitor.terminoEscritura();

	}

	public VO_ConfirmacionVentaFinalizada finalizarVenta(VO_FinalizarVenta datosFinalizarVenta)
			throws NoExisteNumeroVentaException, InterruptedException {
		
		monitor.comienzoEscritura();

		double monto = 0.0;
		if (!secVentas.Member(datosFinalizarVenta.getNumero())) {
			monitor.terminoEscritura();
			throw new NoExisteNumeroVentaException("No existe venta registrada con el número ingresado");
		}

		Venta ventaBuscada = secVentas.Find(datosFinalizarVenta.getNumero());
		if (ventaBuscada.DetallesEmpty() || !datosFinalizarVenta.getConfirma()) {
			secVentas.borrar(datosFinalizarVenta.getNumero());
		} else if (datosFinalizarVenta.getConfirma()) {
			ventaBuscada.setEnProceso(false);
			monto = ventaBuscada.getMonto();
		}
		
		monitor.terminoEscritura();
		return new VO_ConfirmacionVentaFinalizada(monto, datosFinalizarVenta.getConfirma());
	}

	public VO_VentaCompleto[] listadoVentas(VO_IndicacionListado datosIndicacion) throws IndicacionInvalidaException, InterruptedException {

		monitor.comienzoLectura();
		
		Set<Character> indicacionesValidas = Set.of('T', 'P', 'F');
		if (!indicacionesValidas.contains(datosIndicacion.getIndicacion())) {
			monitor.terminoLectura();
			throw new IndicacionInvalidaException("El caracter ingresado no corresponde con ninguna indicacion");
		}
		
		VO_VentaCompleto[] resultado;

		if (datosIndicacion.getIndicacion() == 'T')
			resultado = secVentas.ListarVentas();
		else if (datosIndicacion.getIndicacion() == 'P')
			resultado = secVentas.ListarVentasEnProceso();
		else
			resultado = secVentas.ListarVentasEnFinalizadas();
		
		monitor.terminoLectura();
		return resultado;
	}

	public VO_PostreCantidad[] listadoPostresEnVenta(VO_NumeroVenta datosNumeroVenta)
			throws NoExisteNumeroVentaException, InterruptedException  {
		
		monitor.comienzoLectura();
		
		if (!secVentas.Member(datosNumeroVenta.getNumero())) {
			monitor.terminoLectura();
			throw new NoExisteNumeroVentaException("No existe venta registrada con el número ingresado");
		}

		Venta ventaBuscada = secVentas.Find(datosNumeroVenta.getNumero());
		VO_PostreCantidad[] resultado = ventaBuscada.ListarPostres();
		
		monitor.terminoLectura();
		return resultado;
	}

	public VO_CantidadMonto totalMontoPostreYFecha(VO_PostreFecha datos)
			throws FechaMayorHoyException, NoExistePostreException, InterruptedException  {
		
		monitor.comienzoLectura();

		if (!dicPostres.Member(datos.getCodigo())) {
			monitor.terminoLectura();
			throw new NoExistePostreException("El código ingresado no está registrado para ningún postre");
		}

		if (datos.getFecha().isAfter(LocalDate.now())) {
			monitor.terminoLectura();
			throw new FechaMayorHoyException("La fecha ingresada no puede ser mayor a hoy");
		}

		VO_CantidadMonto resultado = secVentas.totalMontoPostreYFecha(datos);
		monitor.terminoLectura();
		return resultado;	
		
	}

	public void respaldarDatos() throws PersistenciaException, InterruptedException {
		
		monitor.comienzoLectura();
		VO_Persistencia datosRespaldar = new VO_Persistencia(dicPostres, secVentas);
		persistencia.respaldar("datos.dat", datosRespaldar);
		monitor.terminoLectura();
	}

	public void recuperarDatos() throws ClassNotFoundException, PersistenciaException, InterruptedException {
		
		monitor.comienzoEscritura();
		VO_Persistencia datosRecuperados = persistencia.recuperar("datos.dat");

		dicPostres = datosRecuperados.getPostres();
		secVentas = datosRecuperados.getVentas();
		monitor.terminoEscritura();
	}
}
