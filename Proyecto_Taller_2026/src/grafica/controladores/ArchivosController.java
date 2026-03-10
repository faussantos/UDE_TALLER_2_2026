package grafica.controladores;

import excepciones.PersistenciaException;
import grafica.MenuPrincipal;

public class ArchivosController extends Controller {

    private MenuPrincipal ventana;

    public ArchivosController(MenuPrincipal ven) {
        super();
        this.ventana = ven;
    }

    public void respaldarDatos() {
        try {
            capaLogica.respaldarDatos();
            ventana.mostrarExito("Datos respaldados correctamente.");
        } catch (PersistenciaException e) {
            ventana.mostrarError("Error al respaldar los datos: " + e.darMensaje());
        } catch (Exception e) {
            ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }

    public void recuperarDatos() {
        try {
            capaLogica.recuperarDatos();
        } catch (PersistenciaException e) {
            ventana.mostrarError("Error al recuperar los datos: " + e.darMensaje());
        } catch (ClassNotFoundException e) {
            ventana.mostrarError("Error al leer el archivo de datos.");
        } catch (Exception e) {
            ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }
}