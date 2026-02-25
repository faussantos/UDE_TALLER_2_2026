package value_objects;

public class VO_PostreCantidad extends VO_Postre{
	private int cantidad;

	public VO_PostreCantidad(String cod, String nom, double pre, int cant) {
		super(cod, nom, pre);
		cantidad = cant;
	}

	public int getCantidad() {
		return cantidad;
	}
}
