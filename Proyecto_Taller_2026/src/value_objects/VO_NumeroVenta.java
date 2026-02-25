package value_objects;

public class VO_NumeroVenta extends ValueObject{
	private int numero;

	public VO_NumeroVenta(int num) {
		numero = num;
	}

	public int getNumero() {
		return numero;
	}
}
