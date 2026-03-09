package logica.ventas;

import java.io.Serializable;
import java.util.LinkedList;

import value_objects.*;

public class Ventas implements Serializable {
	private static final long serialVersionUID = 1L;

	private LinkedList<Venta> ventas;

	public Ventas() {
		ventas = new LinkedList<Venta>();
	}

	public boolean esVacia() {
		return ventas.isEmpty();
	}

	public int largo() {
		return ventas.size();
	}

	public boolean member(int numero) {
		boolean existe = false;
		for (Venta venta : ventas) {
			if (venta.getNumero() == numero) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	public Venta find(int numero) {
		Venta ventaDevolver = null;
		for (Venta venta : ventas) {
			if (venta.getNumero() == numero) {
				ventaDevolver = venta;
			}
		}
		return ventaDevolver;
	}

	public void insBack(Venta venta) {
		ventas.add(venta);
	}

	public void modify(Venta ventaNueva) {
		for (Venta ventaCambiar : ventas) {
			if (ventaCambiar.getNumero() == ventaNueva.getNumero()) {
				int index = ventas.indexOf(ventaCambiar);
				ventas.set(index, ventaNueva);
			}
		}
	}

	public VO_VentaCompleto[] listarVentas() {
		VO_VentaCompleto[] arre = new VO_VentaCompleto[ventas.size()];
		int i = 0;
		for (Venta venta : ventas) {
			arre[i] = new VO_VentaCompleto(venta.getFecha(), venta.getDireccion(), venta.getNumero(),
					venta.getEnProceso(), venta.getMonto());
			i++;
		}
		return arre;
	}

	public Venta getUltimaVenta() {
		Venta ventaDevolver = null;
		if (!ventas.isEmpty()) {
			ventaDevolver = ventas.getLast();
		}
		return ventaDevolver;
	}

	public VO_VentaCompleto[] listarVentasEnProceso() {
		VO_VentaCompleto[] arre = new VO_VentaCompleto[ventas.size()];
		int i = 0;
		for (Venta venta : ventas) {
			if (venta.getEnProceso() == true) {
				arre[i] = new VO_VentaCompleto(venta.getFecha(), venta.getDireccion(), venta.getNumero(),
						venta.getEnProceso(), venta.getMonto());
				i++;
			}
		}
		return arre;
	}

	public VO_VentaCompleto[] listarVentasEnFinalizadas() {
		VO_VentaCompleto[] arre = new VO_VentaCompleto[ventas.size()];
		int i = 0;
		for (Venta venta : ventas) {
			if (venta.getEnProceso() == false) {
				arre[i] = new VO_VentaCompleto(venta.getFecha(), venta.getDireccion(), venta.getNumero(),
						venta.getEnProceso(), venta.getMonto());
				i++;
			}
		}
		return arre;
	}

	public void borrar(int numeroVenta) {
		Venta ventaBorrar = this.find(numeroVenta);
		ventas.remove(ventas.indexOf(ventaBorrar));
	}

	public VO_CantidadMonto totalMontoPostreYFecha(VO_PostreFecha datos) {
		int cantidad = 0;
		double monto = 0;

		if (!ventas.isEmpty()) {
			for (Venta venta : ventas) {
				if (venta.getFecha().isAfter(datos.getFecha())) {
					break;
				}

				if (venta.existeDetalle(datos.getCodigo())) {
					DetalleVenta detalleBuscado = venta.getDetalle(datos.getCodigo());
					cantidad += detalleBuscado.getCantidad();
					monto += detalleBuscado.getPostre().getPrecio() * detalleBuscado.getCantidad();
				}
			}
		}

		VO_CantidadMonto cantidadMontoVO = new VO_CantidadMonto(cantidad, monto);

		return cantidadMontoVO;
	}
}
