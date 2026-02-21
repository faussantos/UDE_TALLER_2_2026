package logica.postres;

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
}
