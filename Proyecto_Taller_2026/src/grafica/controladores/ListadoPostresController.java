package grafica.controladores;

import java.rmi.RemoteException;

import grafica.listados.ListadoPostres;
import grafica.registrar.NuevoPostre;
import value_objects.VO_Postre;

public class ListadoPostresController extends Controller {

	private ListadoPostres ventana;

	public ListadoPostresController(ListadoPostres ven) {
		super();
		this.ventana = ven;
	}

	public void ListadoPostres() {

		try {
			ventana.mostrarPostres(capaLogica.ListadoPostres());

		} catch (Exception e) {
            ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
        }
	}
}
