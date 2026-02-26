package value_objects;

public class VO_ConfirmacionVentaFinalizada {
	private double monto;
	private boolean confirmada;

	public VO_ConfirmacionVentaFinalizada(double mon, boolean conf) {
		monto = mon;
		confirmada = conf;
	}

	public double getMonto() {
		return monto;
	}

	public boolean isConfirmada() {
		return confirmada;
	}

}
