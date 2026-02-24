package excepciones;

public class FechaMayorUltimaVenta extends Exception {
	private String mensaje;
	
	public FechaMayorUltimaVenta(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
