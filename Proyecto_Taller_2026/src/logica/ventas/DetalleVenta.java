package logica.ventas;

import logica.postres.*;

public class DetalleVenta {

	private int cantidad;
	private Postre postre;

	public DetalleVenta(int cant, Postre pos) {
		setCantidad(cant);
		postre = pos;
	}

	public Postre getPostre() {
		return postre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
