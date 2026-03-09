package grafica.listados;


import javax.swing.table.DefaultTableModel;

import grafica.Ventana;
import grafica.controladores.ListadoVentasController;
import value_objects.VO_VentaCompleto;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class ListadoVentas extends Ventana{

	private JTable table;
	private DefaultTableModel modelo;
	private ListadoVentasController _controller;

	public ListadoVentas() {
		super("Listado de Ventas");
		_controller = new ListadoVentasController(this);
		initialize();
	}

	private void initialize() {
		_frame.setBounds(100, 100, 722, 408);

		JLabel lblTitulo = new JLabel("Listado de Ventas");
		lblTitulo.setBounds(10, 10, 708, 19);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		_frame.getContentPane().add(lblTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 688, 200);
		_frame.getContentPane().add(scrollPane);

		String[] columnas = { "Número", "Fecha", "Dirección", "Monto", "Estado" };
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

		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(603, 337, 95, 21);
		_frame.getContentPane().add(btnCerrar);
		btnCerrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	_frame.dispose();
		    }
		});

		JLabel lblMostrar = new JLabel("Mostrar:");
		lblMostrar.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMostrar.setBounds(23, 56, 54, 17);
		_frame.getContentPane().add(lblMostrar);

		JRadioButton rdbtnTodas = new JRadioButton("Todas");
		rdbtnTodas.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnTodas.setBounds(81, 54, 61, 21);
		_frame.getContentPane().add(rdbtnTodas);

		JRadioButton rdbtnEnProceso = new JRadioButton("En Proceso");
		rdbtnEnProceso.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnEnProceso.setBounds(157, 54, 103, 21);
		_frame.getContentPane().add(rdbtnEnProceso);

		JRadioButton rdbtnFinalizadas = new JRadioButton("Finalizadas");
		rdbtnFinalizadas.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnFinalizadas.setBounds(262, 54, 103, 21);
		_frame.getContentPane().add(rdbtnFinalizadas);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnFinalizadas);
		grupo.add(rdbtnEnProceso);
		grupo.add(rdbtnTodas);
		rdbtnTodas.setSelected(true);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char indicacion;
				if (rdbtnTodas.isSelected())
					indicacion = 'T';
				else if (rdbtnEnProceso.isSelected())
					indicacion = 'P';
				else
					indicacion = 'F';
				_controller.listarVentas(indicacion);
			}
		});
		btnBuscar.setBounds(371, 54, 95, 21);
		_frame.getContentPane().add(btnBuscar);
		
		_frame.setVisible(true);

	}

	public void mostrarVentas(VO_VentaCompleto[] ventas) {
		modelo.setRowCount(0);
		for (VO_VentaCompleto v : ventas) {
			String estado;
			if (v.getEnProceso()) {
				estado = "En proceso";
			} else {
				estado = "Finalizada";
			}
			modelo.addRow(new Object[] { v.getNumero(), v.getFecha(), v.getDireccion(), v.getMonto(), estado });
		}
	}
}