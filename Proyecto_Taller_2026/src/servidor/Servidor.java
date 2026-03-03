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
			p.load (new FileInputStream ("config/config.properties"));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			LocateRegistry.createRegistry(Integer.parseInt(puerto));

			Naming.rebind("//" + ip + ":" + puerto + "/CapaLogica", CapaLogica.getInstancia());

			System.out.println("Servidor publicado");

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}