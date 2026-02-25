package value_objects;

public class VO_Postre extends ValueObject{
	private String codigo;
	private String nombre;
	private double precio;

	public VO_Postre(String cod, String nom, double pre) {
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
