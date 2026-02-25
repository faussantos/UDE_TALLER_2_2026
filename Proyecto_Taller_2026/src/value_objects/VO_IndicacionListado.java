package value_objects;

public class VO_IndicacionListado extends ValueObject {
	
	private char indicacion;

	public VO_IndicacionListado(char ind) {
		indicacion = ind;
	}

	public char getIndicacion() {
		return indicacion;
	}
}
