package persistencia;

import java.io.*;
import java.util.Properties;

import excepciones.PersistenciaException;
import value_objects.VO_Persistencia;

public class Persistencia {

	public void respaldar(String nomArch, VO_Persistencia datosRespaldar) throws PersistenciaException {
		try {
			FileOutputStream f = new FileOutputStream(getRutaRespaldoArchivos() + nomArch);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(datosRespaldar);
			o.close();
			f.close();

		} catch (IOException e) {
			e.printStackTrace();
			throw new PersistenciaException("Ha ocurrido un error inesperado al respaldar los datos");
		}
	}

	public VO_Persistencia recuperar(String nomArch) throws PersistenciaException, ClassNotFoundException {
		try {
			FileInputStream f = new FileInputStream(getRutaRespaldoArchivos() + nomArch);
			ObjectInputStream o = new ObjectInputStream(f);

			VO_Persistencia datosRecuperados = (VO_Persistencia) o.readObject();

			o.close();
			f.close();
			return datosRecuperados;

		} catch (IOException e) {
			e.printStackTrace();
			throw new PersistenciaException("error recuperar");
		}
	}

	public String getRutaRespaldoArchivos() {
		String rutaRespaldoDatos = null;

		try {
			Properties p = new Properties();
			p.load(new FileInputStream("config/config.properties"));
			rutaRespaldoDatos = p.getProperty("rutaRespaldoDatos");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rutaRespaldoDatos;
	}
}

/*
 * try { Properties p = new Properties(); String nomArch =
 * "config/ejemplo.properties"; // Abro el archivo properties y leo los datos de
 * configuración p.load (new FileInputStream (nomArch)); String ip =
 * p.getProperty("ipServidor"); String puerto = p.getProperty("puertoServidor");
 * ... } catch (IOException e) { e.printStackTrace(); }
 * 
 */