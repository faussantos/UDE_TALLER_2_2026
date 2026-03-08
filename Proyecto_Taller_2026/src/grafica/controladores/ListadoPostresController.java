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

		} catch (InterruptedException e) {
			ventana.mostrarError(e.getMessage());
		} catch (RemoteException e) {
			ventana.mostrarError(e.getMessage());
		}
	}
}
