package value_objects;

public class VO_CantidadMonto {
	
	private int cantidad;
	private double monto;
	
	public VO_CantidadMonto(int cant, double mont) {
		cantidad = cant;
		monto = mont;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getMonto() {
		return monto;
	}
	

}
