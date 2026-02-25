package value_objects;

public class VO_DetalleVenta extends ValueObject {
	
	private int cantidad;
	private String codigoPostre;
	private int numeroVenta;
	
	public VO_DetalleVenta(int cant, String cod, int num) {
		cantidad = cant;
		codigoPostre = cod; 
		numeroVenta  = num;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getCodigoPostre() {
		return codigoPostre;
	}

	public int getNumeroVenta() {
		return numeroVenta;
	}
	
	

}
