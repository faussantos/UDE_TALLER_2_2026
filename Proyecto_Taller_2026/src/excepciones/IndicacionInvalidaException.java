package excepciones;

public class IndicacionInvalidaException extends Exception {
	private String mensaje;

	public IndicacionInvalidaException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
