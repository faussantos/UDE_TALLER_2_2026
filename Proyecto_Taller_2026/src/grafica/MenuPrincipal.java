package grafica;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import grafica.registrar.*;
import grafica.consultar.*;
import grafica.controladores.ArchivosController;
import grafica.listados.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends Ventana{

	ArchivosController _controller = new ArchivosController(this);

	public MenuPrincipal() {
		super("Menú");
		initialize();
	}

	private void initialize() {
		_frame.setBounds(100, 100, 450, 300);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		_frame.setJMenuBar(menuBar);
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuArchivo);
		
		JMenuItem itemGuardar = new JMenuItem("Guardar");
		itemGuardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        _controller.respaldarDatos();
		    }
		});
		menuArchivo.add(itemGuardar);
		
		JMenuItem itemAbrir = new JMenuItem("Abrir");
		itemAbrir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        _controller.recuperarDatos();
		    }
		});
		menuArchivo.add(itemAbrir);
		
		JMenu menuRegistro = new JMenu("Registrar");
		menuRegistro.setFont(new Font("Arial", Font.PLAIN, 14));

		menuBar.add(menuRegistro);
		
		JMenuItem itemNuevoPostre = new JMenuItem("Nuevo postre");
		menuRegistro.add(itemNuevoPostre);
		itemNuevoPostre.addActionListener(
				new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						new NuevoPostre();
					}
				});
		
		JMenuItem itemNuevaVenta = new JMenuItem("Nueva venta");
		menuRegistro.add(itemNuevaVenta);
		itemNuevaVenta.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new NuevaVenta();
					}
				});
		
		JMenuItem itemAgregarPostreEnVenta = new JMenuItem("Agregar postre a venta");
		menuRegistro.add(itemAgregarPostreEnVenta);
		itemAgregarPostreEnVenta.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new AgregarPostreEnVenta();
					}
				});
		
		JMenuItem itemEliminarPostreEnVenta = new JMenuItem("Eliminar postre a venta");
		menuRegistro.add(itemEliminarPostreEnVenta);
		itemEliminarPostreEnVenta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new EliminarPostreEnVenta();
			}
		});
		
		JMenuItem itemFinalizarVenta = new JMenuItem("Finalizar venta");
		menuRegistro.add(itemFinalizarVenta);
		itemFinalizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new FinalizarVenta();
			}
		});
		
		JMenu menuConsultas = new JMenu("Consultas");
		menuConsultas.setFont(new Font("Arial", Font.PLAIN, 14));

		menuBar.add(menuConsultas);
		
		JMenuItem itemInformacionPostre = new JMenuItem("Información postre");
		menuConsultas.add(itemInformacionPostre);
		itemInformacionPostre.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new PostreDetallado();
					}
				});
		
		JMenuItem itemRecaudacionPostre = new JMenuItem("Recaudacion por postre");
		menuConsultas.add(itemRecaudacionPostre);
		itemRecaudacionPostre.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new RecaudacionPostreFecha();
					}
		});
		
		JMenu menuListados = new JMenu("Listados");
		menuListados.setFont(new Font("Arial", Font.PLAIN, 14));

		menuBar.add(menuListados);
		
		JMenuItem itemPostres = new JMenuItem("Postres");
		menuListados.add(itemPostres);
		itemPostres.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ListadoPostres();
					}
		});
		
		JMenuItem itemVentas = new JMenuItem("Ventas");
		menuListados.add(itemVentas);
		itemVentas.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ListadoVentas();
					}
		});
		
		JMenuItem itemDetalles = new JMenuItem("Detalles de venta");
		menuListados.add(itemDetalles);
		itemDetalles.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ListadoDetallesEnVenta();
					}
				});
		
		_frame.setVisible(true);

	}

}
