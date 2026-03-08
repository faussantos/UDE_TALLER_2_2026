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
            ventana.mostrarError("Error al respaldar los datos: " + e.getMessage());
        } catch (Exception e) {
            ventana.mostrarError("Error inesperado: " + e.getMessage());
        }
    }

    public void recuperarDatos() {
        try {
            capaLogica.recuperarDatos();
            ventana.mostrarExito("Datos recuperados correctamente.");
        } catch (PersistenciaException e) {
            ventana.mostrarError("Error al recuperar los datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            ventana.mostrarError("Error al leer el archivo de datos.");
        } catch (Exception e) {
            ventana.mostrarError("Error inesperado: " + e.getMessage());
        }
    }
}