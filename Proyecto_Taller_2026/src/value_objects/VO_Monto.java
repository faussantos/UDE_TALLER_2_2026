package value_objects;

public class VO_Monto extends ValueObject {
	
	private double monto;
	
	public VO_Monto(double mon) {
		monto = mon;
	}

	public double getMonto() {
		return monto;
	}

}
