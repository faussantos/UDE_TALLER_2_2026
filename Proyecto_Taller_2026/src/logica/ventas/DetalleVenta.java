package logica.ventas;

import java.io.Serializable;

import logica.postres.*;

public class DetalleVenta implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
