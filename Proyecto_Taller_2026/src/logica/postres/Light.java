package logica.postres;

public class Light extends Postre {
	public String endulzante;
	public String descripcion;
	
	public Light (String cod, String nom, double pre, String endul, String descr) {
		super(cod, nom, pre);
		endulzante = endul;
		descripcion = descr;
	}
	
	public String getTipo() {
		return "Light";
	}
}
