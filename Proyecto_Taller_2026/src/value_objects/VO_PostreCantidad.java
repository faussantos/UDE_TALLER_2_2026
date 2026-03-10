package value_objects;

public class VO_PostreCantidad extends VO_Postre {
    private int cantidad;
    private String tipo;

    public VO_PostreCantidad(String cod, String nom, double pre, int cant, String tipo) {
        super(cod, nom, pre);
        this.cantidad = cant;
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
