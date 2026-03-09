package grafica.listados;

import javax.swing.table.DefaultTableModel;

import grafica.Ventana;
import grafica.controladores.ListadoDetallesEnVentaController;
import value_objects.VO_PostreCantidad;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ListadoDetallesEnVenta extends Ventana {

	private JTable table;
	private JTextField textFieldNumeroVenta;
	private ListadoDetallesEnVentaController _controller;
	private DefaultTableModel modelo;

	/**
	 * Create the application.
	 */
	public ListadoDetallesEnVenta() {
		super("Listado detalles en venta");
		_controller = new ListadoDetallesEnVentaController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame.setBounds(100, 100, 682, 408);

		JLabel lblNewLabel = new JLabel("Listado de Detalles");
		lblNewLabel.setBounds(10, 10, 648, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		_frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 85, 593, 200);
		_frame.getContentPane().add(scrollPane);

		String[] columnas = { "Código", "Nombre", "Precio", "Tipo", "Cantidad" };
		modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(modelo);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(531, 340, 95, 21);
		_frame.getContentPane().add(btnCerrar);

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_frame.dispose();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Ingrese número de venta: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(23, 56, 157, 17);
		_frame.getContentPane().add(lblNewLabel_1);

		ButtonGroup grupo = new ButtonGroup();

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(324, 54, 95, 21);
		_frame.getContentPane().add(btnBuscar);

		textFieldNumeroVenta = new JTextField();
		textFieldNumeroVenta.setBounds(176, 55, 110, 19);
		_frame.getContentPane().add(textFieldNumeroVenta);
		textFieldNumeroVenta.setColumns(10);

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeroVenta = textFieldNumeroVenta.getText().trim();

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

				_controller.ListadoDetallesEnVenta(numeroVentaInt);
			}
		});

		_frame.setVisible(true);
	}

	public void mostrarDetalles(VO_PostreCantidad[] listadoDetalles) {
		modelo.setRowCount(0);

		for (int i = 0; i < listadoDetalles.length; i++) {
			String codigo = listadoDetalles[i].getCodigo();
			String nombre = listadoDetalles[i].getNombre();
			double precio = listadoDetalles[i].getPrecio();
			String tipo = listadoDetalles[i].getTipo();
			int cantidad = listadoDetalles[i].getCantidad();

			modelo.addRow(new Object[] { codigo, nombre, precio, tipo, cantidad });
		}
	}
}
