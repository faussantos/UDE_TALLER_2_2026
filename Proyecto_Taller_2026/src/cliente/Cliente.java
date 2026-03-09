package cliente;

import grafica.MenuPrincipal;
import java.awt.EventQueue;

public class Cliente {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}