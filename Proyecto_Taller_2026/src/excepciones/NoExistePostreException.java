package excepciones;

public class NoExistePostreException extends Exception {
	
	private String mensaje;

	public NoExistePostreException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
