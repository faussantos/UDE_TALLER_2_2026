package value_objects;

public class VO_ConfirmacionVentaFinalizada extends ValueObject {
	private double monto;
	private boolean confirma;

	public VO_ConfirmacionVentaFinalizada(double mon, boolean conf) {
		monto = mon;
		confirma = conf;
	}

	public double getMonto() {
		return monto;
	}

	public boolean getConfirma() {
		return confirma;
	}

}
