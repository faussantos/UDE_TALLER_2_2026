package grafica.controladores;

import excepciones.NoExistePostreException;
import grafica.consultar.PostreDetallado;
import value_objects.VO_CodigoPostre;
import value_objects.VO_Postre;

public class PostreDetalladoController extends Controller {

	private PostreDetallado ventana;

	public PostreDetalladoController(PostreDetallado ven) {
		super();
		this.ventana = ven;
	}

	public VO_Postre postreDetallado(String codigo) {
		
		VO_CodigoPostre datosPostre = new VO_CodigoPostre(codigo);
		VO_Postre detallePostre = null;
		
		try {
			detallePostre = capaLogica.detallePostre(datosPostre);
		} catch (NoExistePostreException e) {
			ventana.mostrarError(e.darMensaje());
		} catch (Exception e) {
			ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
		}
		return detallePostre;
	}
}
