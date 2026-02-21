package value_objects;

public class VO_Light extends VO_Postre{
	private String endulzante;
	private String descripcion;

	public VO_Light(String cod, String nom, double pre, String endul, String descr) {
		super(cod, nom, pre);
		endulzante = endul;
		descripcion = descr;
	}

	public String getEndulzante() {
		return endulzante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getTipo() {
		return "Light";
	}
}
