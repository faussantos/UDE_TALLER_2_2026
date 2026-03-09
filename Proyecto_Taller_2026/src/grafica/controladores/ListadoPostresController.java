package grafica.controladores;

import grafica.listados.ListadoPostres;

public class ListadoPostresController extends Controller {

	private ListadoPostres ventana;

	public ListadoPostresController(ListadoPostres ven) {
		super();
		this.ventana = ven;
	}

	public void listadoPostres() {

		try {
			ventana.mostrarPostres(capaLogica.listadoPostres());

		} catch (Exception e) {
            ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
        }
	}
}
