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

public class CapaLogica extends UnicastRemoteObject implements ICapaLogica {

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

		if (instancia == null)
			instancia = new CapaLogica();

		return instancia;
	}

	public void altaPostre(VO_Postre datosPostre) throws ExistePostreException, InterruptedException, RemoteException {

		monitor.comienzoEscritura();

		if (dicPostres.member(datosPostre.getCodigo())) {
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

		dicPostres.insert(postre);
		monitor.terminoEscritura();
	}

	public VO_Postre[] listadoPostres() throws InterruptedException {

		monitor.comienzoLectura();
		VO_Postre[] resultado = dicPostres.listarPostres();
		monitor.terminoLectura();
		return resultado;
	}

	public VO_Postre detallePostre(VO_CodigoPostre codigoPostre) throws NoExistePostreException, InterruptedException {

		monitor.comienzoLectura();

		if (!dicPostres.member(codigoPostre.getCodigoPostre())) {
			monitor.terminoLectura();
			throw new NoExistePostreException("El código ingresado no está registrado para ningún postre");
		}

		Postre postreBuscado = dicPostres.find(codigoPostre.getCodigoPostre());

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

	public int inicioVenta(VO_VentaBasico datosVenta) throws FechaMayorUltimaVentaException, InterruptedException {

		monitor.comienzoEscritura();

		Venta ultimaVenta = secVentas.getUltimaVenta();
		if (ultimaVenta != null && ultimaVenta.getFecha().isBefore(datosVenta.getFecha())) {
			monitor.terminoEscritura();
			throw new FechaMayorUltimaVentaException(
					"La fecha de la nueva venta no puede ser menor que la de la última venta registrada");
		}

		Venta nuevaVenta = new Venta(datosVenta.getFecha(), datosVenta.getDireccion(), true, 0);

		int numeroVenta;
		if (secVentas.esVacia()) {
			numeroVenta = 1;
			nuevaVenta.setNumero(numeroVenta);
		} else {
			numeroVenta = ultimaVenta.getNumero() + 1;
			nuevaVenta.setNumero(numeroVenta);
		}

		secVentas.insBack(nuevaVenta);
		monitor.terminoEscritura();
		return numeroVenta;
	}

	public void agregarPostreEnVenta(VO_DetalleVenta datosDetalle)
			throws CantidadNegativaException, CantidadMayor40Exception, NoExistePostreException,
			NoExisteNumeroVentaException, VentaNoEnProcesoException, InterruptedException {

		monitor.comienzoEscritura();

		if (datosDetalle.getCantidad() <= 0) {
			monitor.terminoEscritura();
			throw new CantidadNegativaException("La cantidad ingresada debe ser mayor a 0");
		}
		if (datosDetalle.getCantidad() > 40) {
			monitor.terminoEscritura();
			throw new CantidadMayor40Exception("La cantidad de postres ingresados no puede superar las 40 unidades");
		}
		if (!dicPostres.member(datosDetalle.getCodigoPostre())) {
			monitor.terminoEscritura();
			throw new NoExistePostreException("El código ingresado no está registrado para ningún postre");
		}
		if (!secVentas.member(datosDetalle.getNumeroVenta())) {
			monitor.terminoEscritura();
			throw new NoExisteNumeroVentaException("El número ingresado no está registrado para ninguna venta");
		}

		Venta ventaBuscada = secVentas.find(datosDetalle.getNumeroVenta());

		if (!ventaBuscada.getEnProceso()) {
			monitor.terminoEscritura();
			throw new VentaNoEnProcesoException("La venta ya está finalizada, no le puede agregar más postres");
		}

		if ((ventaBuscada.getTotalUnidades() + datosDetalle.getCantidad()) > 40) {
			monitor.terminoEscritura();
			throw new CantidadMayor40Exception(
					"La suma total de cantidades de una venta no puede superar las 40 unidades");
		}

		if (ventaBuscada.existeDetalle(datosDetalle.getCodigoPostre())) {
			DetalleVenta detalleBuscado = ventaBuscada.getDetalle(datosDetalle.getCodigoPostre());
			detalleBuscado.setCantidad(detalleBuscado.getCantidad() + datosDetalle.getCantidad());
			ventaBuscada.setMonto(ventaBuscada.totalMontoDetalles());

		} else {
			Postre ingresarPostre = dicPostres.find(datosDetalle.getCodigoPostre());
			DetalleVenta nuevoDetalle = new DetalleVenta(datosDetalle.getCantidad(), ingresarPostre);
			ventaBuscada.insertarDetalle(nuevoDetalle);
			ventaBuscada.setMonto(ventaBuscada.totalMontoDetalles());

		}

		monitor.terminoEscritura();
	}

	public void eliminarPostreEnVenta(VO_DetalleVenta datosDetalle) throws CantidadNegativaException,
			NoExisteNumeroVentaException, NoExistePostreException, VentaNoEnProcesoException, InterruptedException {

		monitor.comienzoEscritura();

		if (datosDetalle.getCantidad() <= 0) {
			monitor.terminoEscritura();
			throw new CantidadNegativaException("La cantidad ingresada debe ser mayor a 0");
		}

		if (!secVentas.member(datosDetalle.getNumeroVenta())) {
			monitor.terminoEscritura();
			throw new NoExisteNumeroVentaException("El codigo ingresado no corresponde a ninguna venta");
		}

		Venta venta = secVentas.find(datosDetalle.getNumeroVenta());

		if (!venta.getEnProceso()) {
			monitor.terminoEscritura();
			throw new VentaNoEnProcesoException("La venta ya esta finalizada, no se pueden eliminar postres");
		}

		if (!venta.existeDetalle(datosDetalle.getCodigoPostre())) {
			monitor.terminoEscritura();
			throw new NoExistePostreException("El postre no existe en esta venta");
		}

		DetalleVenta detalle = venta.getDetalle(datosDetalle.getCodigoPostre());
		int cantidadActual = detalle.getCantidad();
		int cantidadEliminar = datosDetalle.getCantidad();

		if (cantidadEliminar >= cantidadActual) {
			venta.borrarDetalle(detalle.getPostre().getCodigo());
			venta.setMonto(venta.totalMontoDetalles());
		} else {
			detalle.setCantidad(cantidadActual - cantidadEliminar);
			venta.setMonto(venta.totalMontoDetalles());

		}

		monitor.terminoEscritura();
	}

	public VO_ConfirmacionVentaFinalizada finalizarVenta(VO_FinalizarVenta datosFinalizarVenta)
			throws NoExisteNumeroVentaException, InterruptedException {

		monitor.comienzoEscritura();

		double monto = 0.0;
		if (!secVentas.member(datosFinalizarVenta.getNumero())) {
			monitor.terminoEscritura();
			throw new NoExisteNumeroVentaException("No existe venta registrada con el número ingresado");
		}

		Venta ventaBuscada = secVentas.find(datosFinalizarVenta.getNumero());
		if (ventaBuscada.detallesEmpty() || !datosFinalizarVenta.getConfirma()) {
			secVentas.borrar(datosFinalizarVenta.getNumero());
		} else if (datosFinalizarVenta.getConfirma()) {
			ventaBuscada.setEnProceso(false);
			monto = ventaBuscada.getMonto();
		}

		monitor.terminoEscritura();
		return new VO_ConfirmacionVentaFinalizada(monto, datosFinalizarVenta.getConfirma());
	}

	public VO_VentaCompleto[] listadoVentas(VO_IndicacionListado datosIndicacion)
			throws IndicacionInvalidaException, InterruptedException {

		monitor.comienzoLectura();

		Set<Character> indicacionesValidas = Set.of('T', 'P', 'F');
		if (!indicacionesValidas.contains(datosIndicacion.getIndicacion())) {
			monitor.terminoLectura();
			throw new IndicacionInvalidaException("El caracter ingresado no corresponde con ninguna indicacion");
		}

		VO_VentaCompleto[] resultado;

		if (datosIndicacion.getIndicacion() == 'T')
			resultado = secVentas.listarVentas();
		else if (datosIndicacion.getIndicacion() == 'P')
			resultado = secVentas.listarVentasEnProceso();
		else
			resultado = secVentas.listarVentasEnFinalizadas();

		monitor.terminoLectura();
		return resultado;
	}

	public VO_PostreCantidad[] listadoPostresEnVenta(VO_NumeroVenta datosNumeroVenta)
			throws NoExisteNumeroVentaException, InterruptedException {

		monitor.comienzoLectura();

		if (!secVentas.member(datosNumeroVenta.getNumero())) {
			monitor.terminoLectura();
			throw new NoExisteNumeroVentaException("No existe venta registrada con el número ingresado");
		}

		Venta ventaBuscada = secVentas.find(datosNumeroVenta.getNumero());
		VO_PostreCantidad[] resultado = ventaBuscada.listarPostres();

		monitor.terminoLectura();
		return resultado;
	}

	public VO_CantidadMonto totalMontoPostreYFecha(VO_PostreFecha datos)
			throws FechaMayorHoyException, NoExistePostreException, InterruptedException {

		monitor.comienzoLectura();

		if (!dicPostres.member(datos.getCodigo())) {
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
