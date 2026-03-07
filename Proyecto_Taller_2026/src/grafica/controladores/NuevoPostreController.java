package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import excepciones.ExistePostreException;
import grafica.registrar.NuevoPostre;
import logica.ICapaLogica;
import value_objects.VO_Light;
import value_objects.VO_Postre;

public class NuevoPostreController {

	private ICapaLogica capaLogica;
	private NuevoPostre ventana;

	public NuevoPostreController() {

	}

	public void NuevoPostre(String codigo, String nombre, String precio, boolean light, String endulzante,
			String descripcion) {
		try {
			VO_Postre datosPostre;

			double precioDouble = Double.parseDouble(precio);

			if (light) {
				datosPostre = new VO_Light(codigo, nombre, precioDouble, endulzante, descripcion);
			} else {
				datosPostre = new VO_Postre(codigo, nombre, precioDouble);
			}

			capaLogica.AltaPostre(datosPostre);

		} catch (Exception e) {

		}
	}
}
