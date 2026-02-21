package logica.postres;

public class Light extends Postre {
	private String endulzante;
	private String descripcion;

	public Light(String cod, String nom, double pre, String endul, String descr) {
		super(cod, nom, pre);
		endulzante = endul;
		descripcion = descr;
	}

	public String getEndulzante() {
		return endulzante;
	}

	public void setEndulzante(String endulzante) {
		this.endulzante = endulzante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return "Light";
	}
}
