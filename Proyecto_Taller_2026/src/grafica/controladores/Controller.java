package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;

import java.util.Properties;

import logica.ICapaLogica;

public abstract class Controller {

    protected ICapaLogica capaLogica;

    public Controller() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("config/config.properties"));
            String ip = p.getProperty("ipServidor");
            String puerto = p.getProperty("puertoServidor");
            String ruta = "//" + ip + ":" + puerto + "/CapaLogica";
            capaLogica = (ICapaLogica) Naming.lookup(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}