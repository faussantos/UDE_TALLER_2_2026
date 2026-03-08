package grafica.controladores;

import java.rmi.RemoteException;
import excepciones.ExistePostreException;
import grafica.registrar.NuevoPostre;
import value_objects.VO_Light;
import value_objects.VO_Postre;

public class NuevoPostreController extends Controller {

	private NuevoPostre ventana;

	public NuevoPostreController(NuevoPostre ven) {
		super();
		this.ventana = ven;

	}

	public void NuevoPostre(String codigo, String nombre, double precioDouble, boolean light, String endulzante,
			String descripcion) {
		try {
			VO_Postre datosPostre;

			if (light) {
				datosPostre = new VO_Light(codigo, nombre, precioDouble, endulzante, descripcion);
			} else {
				datosPostre = new VO_Postre(codigo, nombre, precioDouble);
			}

			capaLogica.AltaPostre(datosPostre);
			ventana.mostrarExito("Postre ingresado correctamente");

		} catch (ExistePostreException e) {
		    ventana.mostrarError(e.darMensaje());
		} catch (Exception e) {
            ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
        }
	}
}
