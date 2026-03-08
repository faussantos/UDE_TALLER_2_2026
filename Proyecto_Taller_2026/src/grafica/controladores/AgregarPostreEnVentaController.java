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
            ventana.mostrarError("La cantidad ingresada debe ser mayor a 0.");
        } catch (CantidadMayor40Exception e) {
            ventana.mostrarError("La venta no puede superar las 40 unidades en total.");
        } catch (NoExistePostreException e) {
            ventana.mostrarError("El código ingresado no corresponde a ningún postre.");
        } catch (NoExisteNumeroVentaException e) {
            ventana.mostrarError("El número ingresado no corresponde a ninguna venta.");
        } catch (VentaNoEnProcesoException e) {
            ventana.mostrarError("La venta ya está finalizada, no se pueden agregar más postres.");
        } catch (RemoteException e) {
            ventana.mostrarError("Error de conexión con el servidor.");
        } catch (Exception e) {
            ventana.mostrarError("Error inesperado: " + e.getMessage());
        }
    }
}