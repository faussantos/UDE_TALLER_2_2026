package excepciones;

public class CantidadMayor40Exception extends Exception{
	
	private String mensaje;
	private static final long serialVersionUID = 1L;
	
	public CantidadMayor40Exception(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
