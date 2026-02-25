package excepciones;

public class FechaMenorHoyException extends Exception {
	
	private String mensaje;

	public FechaMenorHoyException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
