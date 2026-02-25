package excepciones;

public class IndicacionInvalidaException extends Exception {
	private String mensaje;
	private static final long serialVersionUID = 1L;

	public IndicacionInvalidaException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
