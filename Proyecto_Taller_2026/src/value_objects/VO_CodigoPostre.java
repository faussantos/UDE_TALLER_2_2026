package value_objects;

public class VO_CodigoPostre extends ValueObject{
	
	private String codigoPostre;

	public VO_CodigoPostre(String cod) {
		codigoPostre = cod;
	}

	public String getCodigoPostre() {
		return codigoPostre;
	}
}
