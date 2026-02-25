package excepciones;

public class FechaMayorHoyException extends Exception {
	private String mensaje;

	public FechaMayorHoyException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
