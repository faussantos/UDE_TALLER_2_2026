package excepciones;

public class ExistePostreException extends Exception {
	private String mensaje;
	
	public ExistePostreException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
