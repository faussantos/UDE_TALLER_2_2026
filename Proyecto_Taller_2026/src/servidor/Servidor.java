package servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import java.util.Properties;
import java.io.*;

import logica.CapaLogica;


public class Servidor {

	public static void main(String[] args) {

		try {
			Properties p = new Properties();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			int port = Integer.parseInt(puerto);
			
			LocateRegistry.createRegistry(port);

			String ruta = "//" + ip + ":" + puerto + "/CapaLogica";
			CapaLogica fachada = CapaLogica.getInstancia();

			Naming.rebind(ruta, fachada);

			System.out.println("Servidor publicado");
			}
			catch (RemoteException e) // si ocurre cualquier problema de red
			{
				e.printStackTrace();
			}
			catch (MalformedURLException e) // si la ruta no esta bien formada
			{
				e.printStackTrace();
			}
			catch (FileNotFoundException e) // si no encuentra el archivo de configuracion
			{
				e.printStackTrace();
			}
			catch (IOException e) // si ocurre cualquier otro error de E/S
			{
				e.printStackTrace();
			}
	}
}