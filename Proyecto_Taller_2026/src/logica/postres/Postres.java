package logica.postres;

import value_objects.*;

import java.io.Serializable;
import java.util.*;

public class Postres implements Serializable {
	private static final long serialVersionUID = 1L;

	private SortedMap<String, Postre> postres;

	public Postres() {
		postres = new TreeMap<String, Postre>();
	}

	public boolean member(String codigo) {
		return postres.containsKey(codigo);
	}

	public void insert(Postre postre) {
		postres.put(postre.getCodigo(), postre);
	}

	public Postre find(String codigo) {
		return postres.get(codigo);
	}

	public boolean empty() {
		return postres.isEmpty();
	}

	public VO_Postre[] listarPostres() {
		VO_Postre[] arre = new VO_Postre[postres.size()];
		int i = 0;
		for (Postre postre : postres.values()) {
			if (postre.getTipo().equals("Light")) {
				Light light = (Light) postre;
				arre[i] = new VO_Light(light.getCodigo(), light.getNombre(), light.getPrecio(), light.getEndulzante(),
						light.getDescripcion());
			} else {
				arre[i] = new VO_Postre(postre.getCodigo(), postre.getNombre(), postre.getPrecio());
			}
			i++;
		}
		return arre;
	}
}
