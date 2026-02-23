package logica.ventas;

import java.util.LinkedList;

import logica.postres.Postre;
import value_objects.*;

public class Ventas {
	private LinkedList<Venta> ventas;

	public Ventas() {
		ventas = new LinkedList<Venta>();
	}

	public boolean EsVacia() {
		return ventas.isEmpty();
	}

	public int Largo() {
		return ventas.size();
	}

	public boolean Member(int numero) {
		boolean existe = false;
		for (Venta venta : ventas) {
			if (venta.getNumero() == numero) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	public Venta Find(int numero) {
		Venta ventaDevolver = null;
		for (Venta venta : ventas) {
			if (venta.getNumero() == numero) {
				ventaDevolver = venta;
			}
		}
		return ventaDevolver;
	}

	public void InsBack(Venta venta) {
		ventas.add(venta);
	}

	public void Modify(Venta ventaNueva) {
		for (Venta ventaCambiar : ventas) {
			if (ventaCambiar.getNumero() == ventaNueva.getNumero()) {
				int index = ventas.indexOf(ventaCambiar);
				ventas.set(index, ventaNueva);
			}
		}
	}

	public VO_VentaCompleto[] ListarVentas() {
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
		return ventas.getLast();
	}

	public VO_VentaCompleto[] ListarVentasEnProceso() {
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

	public VO_VentaCompleto[] ListarVentasEnFinalizadas() {
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
}
