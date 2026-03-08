package grafica.controladores;

import grafica.consultar.PostreDetallado;
import value_objects.VO_CodigoPostre;
import value_objects.VO_Postre;

public class PostreDetalladoController extends Controller {

	private PostreDetallado ventana;

	public PostreDetalladoController(PostreDetallado ven) {
		super();
		this.ventana = ven;
	}

	public VO_Postre PostreDetallado(VO_CodigoPostre datosPostre) {
		VO_Postre detallePostre = null;
		try {
			detallePostre = capaLogica.detallePostre(datosPostre);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return detallePostre;
	}
}
