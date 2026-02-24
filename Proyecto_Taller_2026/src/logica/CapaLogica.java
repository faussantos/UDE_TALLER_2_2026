package logica;

import java.util.ArrayList;

import logica.postres.*;
import logica.ventas.*;
import value_objects.*;
import excepciones.*;
 
public class CapaLogica {

	private Ventas secVentas;
	private Postres dicPostres;

	public CapaLogica() {
		secVentas = new Ventas();
		dicPostres = new Postres();
	}

	public void AltaPostre(VO_Postre datosPostre) 
			throws ExistePostreException {
		
		Postre postre;
		
		if(dicPostres.Member(datosPostre.getCodigo())) {
			String msg = "El código ingresado ya está registrado para un postre";
			throw new ExistePostreException(msg);
		}
		
		if (datosPostre.getTipo().equals("Light")) /*Comparar strings o instanceof*/  {
			VO_Light datosLight = (VO_Light) datosPostre;
			postre = new Light(
					datosLight.getCodigo(), 
					datosLight.getNombre(), 
					datosLight.getPrecio(),
					datosLight.getEndulzante(), 
					datosLight.getDescripcion());
		} else {
			postre = new Postre(
					datosPostre.getCodigo(), 
					datosPostre.getNombre(), 
					datosPostre.getPrecio());
		}

		dicPostres.Insert(postre);
	}

	public VO_Postre[] ListadoPostres() {
		return dicPostres.ListarPostres();
	}

	public VO_Postre detallePostre(VO_CodigoPostre codigoPostre) 
			throws NoExistePostreException {
		
		if(!dicPostres.Member(codigoPostre.getCodigoPostre())) {
			throw new NoExistePostreException("El código ingresado no está registrado para ningún postre");
		}
		Postre postreBuscado = dicPostres.Find(codigoPostre.getCodigoPostre());
		VO_Postre datosDevolver = new VO_Postre(postreBuscado.getCodigo(), postreBuscado.getNombre(),
				postreBuscado.getPrecio());

		return datosDevolver;
	}

	public void inicioVenta(VO_VentaBasico datosVenta) 
			throws FechaMayorUltimaVenta {
		//Revisar excepcion 
		Venta ultimaVenta = secVentas.getUltimaVenta();
		if(ultimaVenta != null && ultimaVenta.getFecha().isBefore(datosVenta.getFecha())) {
			throw new FechaMayorUltimaVenta("La fecha de la nueva venta no puede ser menor que la de la última venta registrada");
		}
		
		Venta nuevaVenta = new Venta(
				datosVenta.getFecha(),
				datosVenta.getDireccion(),
				true,
				0
				);
		
		if(secVentas.EsVacia())
			nuevaVenta.setNumero(1);
		else {
			nuevaVenta.setNumero(ultimaVenta.getNumero() + 1);
		}
		secVentas.InsBack(nuevaVenta);
	}

	public void agregarPostreEnVenta(VO_DetalleVenta datosDetalle) 
			throws CantidadNegativaException, CantidadMayor40Exception, NoExistePostreException, NoExisteNumeroVenta,
			VentaNoEnProceso{
		
		if(datosDetalle.getCantidad()<=0) {
			throw new CantidadNegativaException("La cantidad ingresada debe ser mayor a 0");
		}
		if(datosDetalle.getCantidad() > 40) {
			throw new CantidadMayor40Exception("La cantidad de postres ingresados no puede superar las 40 unidades");
		}
		if(!dicPostres.Member(datosDetalle.getCodigoPostre())) {
			throw new NoExistePostreException("El código ingresado no está registrado para ningún postre");
		}
		if(!secVentas.Member(datosDetalle.getNumeroVenta())) {
			throw new NoExisteNumeroVenta("El número ingresado no está registrado para ninguna venta");
		}
		
		Venta ventaBuscada = secVentas.Find(datosDetalle.getNumeroVenta());
		
		if(!ventaBuscada.getEnProceso()) {
			throw new VentaNoEnProceso("La venta ya está finalizada, no le puede agregar más postres");
		}
		
		if((ventaBuscada.getTotalUnidades() + datosDetalle.getCantidad()) > 40) {
			throw new CantidadMayor40Exception("La suma total de cantidades de una venta no puede superar las 40 unidades");
		}
		
		if(ventaBuscada.ExisteDetalle(datosDetalle.getCodigoPostre())) {
			DetalleVenta detalleBuscado = ventaBuscada.getDetalle(datosDetalle.getCodigoPostre());
			detalleBuscado.setCantidad(detalleBuscado.getCantidad() + datosDetalle.getCantidad());
			ventaBuscada.ModificarDetalleLista(detalleBuscado); //CONSULTAR SI CORRESPONDE USAR. set trabaja por referencia?
		}
		else {
			Postre ingresarPostre = dicPostres.Find(datosDetalle.getCodigoPostre());
			DetalleVenta nuevoDetalle = new DetalleVenta(datosDetalle.getCantidad(),
														ingresarPostre);
			ventaBuscada.InsertarDetalle(nuevoDetalle);
			
		}
		secVentas.Modify(ventaBuscada);
	}

	public void eliminarPostreEnVenta(VO_VentaBasico datosVenta) {
	}

	public void finalizarVenta(VO_FinalizarVenta datosFinalizarVenta) {
	}

	public VO_VentaCompleto[] listadoVentas() {
		
		return null;
	}

	public VO_PostreCantidad[] listadoPostresEnVenta(int num) {
		return null;
	}

	public VO_CantidadMonto totalMontoPostreYFecha(VO_PostreFecha datos) {
		return null;
	}

	public void respaldarDatos() {
	}

	public void recuperarDatos() {
	}
}
