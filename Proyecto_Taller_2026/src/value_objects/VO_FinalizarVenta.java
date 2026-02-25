package value_objects;

public class VO_FinalizarVenta extends ValueObject {
		
	private int numero;
	private boolean confirma;

	public VO_FinalizarVenta(int num, boolean conf) {
		numero = num;
		confirma = conf;
	}

	public int getNumero() {
		return numero;
	}

	public boolean getConfirma() {
		return confirma;
	}
}
