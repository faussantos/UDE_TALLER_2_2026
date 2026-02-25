package excepciones;

public class CantidadNegativaException extends Exception {
	
	private String mensaje;
	private static final long serialVersionUID = 1L;

	public CantidadNegativaException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
