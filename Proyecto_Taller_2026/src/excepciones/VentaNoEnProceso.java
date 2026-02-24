package excepciones;

public class VentaNoEnProceso extends Exception {
	private String mensaje;
	
	public VentaNoEnProceso(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}
