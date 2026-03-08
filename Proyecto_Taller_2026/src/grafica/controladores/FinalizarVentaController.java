package grafica.controladores;

import excepciones.NoExisteNumeroVentaException;
import grafica.registrar.FinalizarVenta;
import value_objects.VO_ConfirmacionVentaFinalizada;
import value_objects.VO_FinalizarVenta;
import java.rmi.RemoteException;

public class FinalizarVentaController extends Controller {

    private FinalizarVenta ventana;

    public FinalizarVentaController(FinalizarVenta ven) {
        super();
        this.ventana = ven;
    }

    public void finalizarVenta(int numeroVenta, boolean confirma) {
        try {
            VO_FinalizarVenta datosFinalizarVenta = new VO_FinalizarVenta(numeroVenta, confirma);
            VO_ConfirmacionVentaFinalizada confirmacion = capaLogica.finalizarVenta(datosFinalizarVenta);

            if (!confirmacion.getConfirma()) {
                ventana.mostrarExito("Venta número " + numeroVenta + " cancelada correctamente.");
            } else if (confirmacion.getMonto() == 0) {
                ventana.mostrarExito("Venta número " + numeroVenta + " no tenía postres, fue eliminada.");
            } else {
                ventana.mostrarExito("Venta finalizada. Monto total: $" + confirmacion.getMonto());
            }

        } catch (NoExisteNumeroVentaException e) {
            ventana.mostrarError("No existe venta registrada con el número ingresado.");
        } catch (RemoteException e) {
            ventana.mostrarError("Error de conexión con el servidor.");
        } catch (Exception e) {
            ventana.mostrarError("Error inesperado: " + e.getMessage());
        }
    }
}