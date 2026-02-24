package excepciones;

public class CantidadNegativaException extends Exception {
	private String mensaje;
	
	public CantidadNegativaException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
