package grafica.controladores;

import excepciones.CantidadMayor40Exception;
import excepciones.CantidadNegativaException;
import excepciones.NoExisteNumeroVentaException;
import excepciones.NoExistePostreException;
import excepciones.VentaNoEnProcesoException;
import grafica.registrar.AgregarPostreEnVenta;
import value_objects.VO_DetalleVenta;
import java.rmi.RemoteException;

public class AgregarPostreEnVentaController extends Controller {

    private AgregarPostreEnVenta ventana;

    public AgregarPostreEnVentaController(AgregarPostreEnVenta ven) {
        super();
        this.ventana = ven;
    }

    public void agregarPostre(String codigoPostre, int cantidad, int numeroVenta) {
        try {
            VO_DetalleVenta datosDetalle = new VO_DetalleVenta(cantidad, codigoPostre, numeroVenta);
            capaLogica.agregarPostreEnVenta(datosDetalle);
            ventana.mostrarExito("Postre agregado correctamente a la venta número " + numeroVenta);
        } catch (CantidadNegativaException e) {
            ventana.mostrarError(e.darMensaje());
        } catch (CantidadMayor40Exception e) {
            ventana.mostrarError(e.darMensaje());
        } catch (NoExistePostreException e) {
            ventana.mostrarError(e.darMensaje());
        } catch (NoExisteNumeroVentaException e) {
            ventana.mostrarError(e.darMensaje());
        } catch (VentaNoEnProcesoException e) {
            ventana.mostrarError(e.darMensaje());
        } catch (Exception e) {
            ventana.mostrarError("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }
}