package grafica.listados;

import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;

import grafica.controladores.ListadoDetallesEnVentaController;
import grafica.controladores.NuevoPostreController;
import value_objects.VO_NumeroVenta;
import value_objects.VO_Postre;
import value_objects.VO_PostreCantidad;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ListadoDetallesEnVenta {

	private JFrame frmListadoDetallesEnVenta;
	private JTable table;
	private JTextField textField;
	private ListadoDetallesEnVentaController _controller;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoDetallesEnVenta window = new ListadoDetallesEnVenta();
					window.frmListadoDetallesEnVenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListadoDetallesEnVenta() {
		_controller = new ListadoDetallesEnVentaController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListadoDetallesEnVenta = new JFrame();
		frmListadoDetallesEnVenta.setTitle("Listado detalles en venta");
		frmListadoDetallesEnVenta.setBounds(100, 100, 682, 408);
		frmListadoDetallesEnVenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListadoDetallesEnVenta.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Listado de Detalles");
		lblNewLabel.setBounds(10, 10, 648, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		frmListadoDetallesEnVenta.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 85, 593, 200);
		frmListadoDetallesEnVenta.getContentPane().add(scrollPane);

		String[] columnas = { "Código", "Nombre", "Precio", "Tipo", "Cantidad" };
		modelo = new DefaultTableModel(columnas, 0);
		table = new JTable(modelo);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(531, 340, 95, 21);
		frmListadoDetallesEnVenta.getContentPane().add(btnCerrar);

		JLabel lblNewLabel_1 = new JLabel("Ingrese número de venta: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(23, 56, 157, 17);
		frmListadoDetallesEnVenta.getContentPane().add(lblNewLabel_1);

		ButtonGroup grupo = new ButtonGroup();

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(324, 54, 95, 21);
		frmListadoDetallesEnVenta.getContentPane().add(btnBuscar);

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeroVenta = "";

				if (numeroVenta.isEmpty()) {
					mostrarError("Todos los campos son obligatorios.");
					return;
				}

				int numeroVentaInt;
				try {
					numeroVentaInt = Integer.parseInt(numeroVenta);
				} catch (NumberFormatException ex) {
					mostrarError("El precio debe ser un número.");
					return;
				}

				VO_NumeroVenta datosVenta = new VO_NumeroVenta(numeroVentaInt);
				_controller.ListadoDetallesEnVenta(datosVenta);
			}
		});

		// Esto agregará los datos
		for (int i = 0; i < 100; i++) {
			modelo.addRow(new Object[] { "123", "Flan", 50.0, "Común" });
		}

		// Esto agregará los datos
		for (int i = 0; i < 100; i++) {
			modelo.addRow(new Object[] { "123", "Flan", 50.0, "Común" });
		}

		textField = new JTextField();
		textField.setBounds(176, 55, 110, 19);
		frmListadoDetallesEnVenta.getContentPane().add(textField);
		textField.setColumns(10);
	}

	public void mostrarDetalles(VO_PostreCantidad[] listadoDetalles) {
		for (int i = 0; i < listadoDetalles.length; i++) {
			String codigo = listadoDetalles[i].getCodigo();
			String nombre = listadoDetalles[i].getNombre();
			double precio = listadoDetalles[i].getPrecio();
			String tipo = listadoDetalles[i].getTipo();
			int cantidad = listadoDetalles[i].getCantidad();

			modelo.addRow(new Object[] { codigo, nombre, precio, tipo, cantidad });
		}
	}
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(frmListadoDetallesEnVenta, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
