package logica.postres;

import java.io.Serializable;

public class Postre implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private double precio;

	public Postre(String cod, String nom, double pre) {
		codigo = cod;
		nombre = nom;
		precio = pre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public String getTipo() {
		return "Comun";
	}
}
