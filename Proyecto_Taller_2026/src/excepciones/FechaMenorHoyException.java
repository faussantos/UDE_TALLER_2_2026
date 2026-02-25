package excepciones;

public class FechaMenorHoyException extends Exception {
	private String mensaje;
	private static final long serialVersionUID = 1L;

	public FechaMenorHoyException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
