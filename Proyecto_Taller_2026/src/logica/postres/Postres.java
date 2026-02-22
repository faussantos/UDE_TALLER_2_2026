package logica.postres;

import value_objects.*;
import java.util.*;

public class Postres {
	private SortedMap<String, Postre> postres;
	
	public Postres() {
		postres = new TreeMap<String, Postre>();
	}

	public boolean Member(String codigo) {
		return postres.containsKey(codigo);
	}
	
	public void Insert(Postre postre) {
		postres.put(postre.getCodigo(), postre);
	}
	
	public Postre Find(String codigo) {
		return postres.get(codigo);
	}
	
	public boolean Empty() {
		return postres.isEmpty();
	}
	
	public VO_Postre[] ListarPostres() {
	    VO_Postre[] arre = new VO_Postre[postres.size()];
	    int i = 0;
	    for (Postre postre : postres.values()) {
	        if (postre.getTipo().equals("Light")) {
	            Light light = (Light) postre;
	            arre[i] = new VO_Light(light.getCodigo(), light.getNombre(), light.getPrecio(),
	                                   light.getEndulzante(), light.getDescripcion());
	        } else {
	            arre[i] = new VO_Postre(postre.getCodigo(), postre.getNombre(), postre.getPrecio());
	        }
	        i++;
	    }
	    return arre;
	}
}
