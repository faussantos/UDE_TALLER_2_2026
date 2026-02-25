package excepciones;

public class NoExistePostreException extends Exception {
	
	private String mensaje;
	private static final long serialVersionUID = 1L;

	public NoExistePostreException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
