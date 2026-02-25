package excepciones;

public class VentaNoEnProceso extends Exception {
	
	private String mensaje;
	private static final long serialVersionUID = 1L;

	public VentaNoEnProceso(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
