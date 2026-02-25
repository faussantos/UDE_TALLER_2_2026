package excepciones;

public class ExistePostreException extends Exception {
	
	private String mensaje;
	private static final long serialVersionUID = 1L;

	public ExistePostreException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
