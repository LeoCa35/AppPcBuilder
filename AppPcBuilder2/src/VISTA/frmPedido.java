package VISTA;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MODEL.Cliente;
import MODEL.LiniaPedido;
import MODEL.Pedido;
import DADES.SQLClients;
import DADES.SQLLiniaPedido;
import DADES.SQLPedido;
import DADES.llegirXML;
import javax.swing.JPanel;
import javax.swing.JButton;

public class frmPedido extends JDialog {
	llegirXML lector1 = new llegirXML();
	private String idPedido = "";
	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	SQLPedido conPedido = new SQLPedido();
	SQLLiniaPedido conLiniaPedido = new SQLLiniaPedido();
	private DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frmPedido window = new frmPedido();
					window.insertarDatosPedido();
					window.insertarDatosLinia();
					window.taulaPedido();
					window.taulaLiniaPedido();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1140, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 873, 155);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 168, 873, 172);
		frame.getContentPane().add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		JPanel panel = new JPanel();
		panel.setBounds(897, 12, 231, 328);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(60, 268, 114, 25);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(60, 219, 114, 25);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(60, 182, 114, 25);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(60, 78, 114, 25);
		panel.add(btnNewButton_3);
	}

	public void insertarDatosPedido() {
		for (int i = 0; i < lector1.getComandes().size(); i++) {
			try {
				conPedido.insertaPedidos(new Pedido(lector1.getComandes().get(i).getIdPedido(),
						lector1.getComandes().get(i).getIdCliente(), lector1.getComandes().get(i).getEstado()));

			} catch (Exception e) {
				System.out.println("No introduce los datos Pedido");
			}
		}

	}

	public void insertarDatosLinia() {
		for (int i = 0; i < lector1.getLiniaPedidos().size(); i++) {
			try {
				conLiniaPedido.insertaPedidos(new LiniaPedido(lector1.getLiniaPedidos().get(i).getIdLinia(),
						lector1.getLiniaPedidos().get(i).getIdPedido(),
						lector1.getLiniaPedidos().get(i).getIdOrdenador(),
						lector1.getLiniaPedidos().get(i).getUnidadesPedidas(),
						lector1.getLiniaPedidos().get(i).getUnidadesServidas(),
						lector1.getLiniaPedidos().get(i).getEstado()));
			} catch (Exception e) {
				System.out.println("No introduce los datos LiniaPedido");
			}
		}
	}

	public void taulaPedido() {
		conPedido = new SQLPedido();
		model = new DefaultTableModel();

		model.addColumn("idPedido");
		model.addColumn("idCliente");
		model.addColumn("Data obertura");
		model.addColumn("Data tancament");
		model.addColumn("estat");
		model.addColumn("preu");

		table.setModel(model);

		try {

			for (Pedido pedidos : conPedido.guardarObjeto("Pedido")) {
				 
					
					
				model.addRow(new Object[] { pedidos.getIdPedido(), pedidos.getIdCliente(), pedidos.getFechaApertura(),
						pedidos.getFechaFinalizacion(), pedidos.getEstado(), pedidos.getPrecio() });
				}
				
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					System.out.println("Click");
					final JTable jtable = (JTable) e.getSource();
					final int row = jtable.getSelectedRow();
					rowPorIdComanda();
					idPedido = (String) jtable.getValueAt(row, 0);
					
					
				}else {
					System.out.println("Marcame un registro");
				}
			}

			private void rowPorIdComanda() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void taulaLiniaPedido() {
		conLiniaPedido = new SQLLiniaPedido();
		model = new DefaultTableModel();

		model.addColumn("idLinia");
		model.addColumn("idPedido");
		model.addColumn("idOrdenador");
		model.addColumn("unidadesServidas");
		model.addColumn("unidadesPedidas");
		model.addColumn("estado");

		table_1.setModel(model);

		try {

			for (LiniaPedido liniapedido : conLiniaPedido.guardarObjeto("LiniaPedido")) {
				if (Integer.parseInt(liniapedido.getIdPedido()) == idPedido) {
				model.addRow(new Object[] { liniapedido.getIdLinia(), liniapedido.getIdPedido(),
						liniapedido.getIdOrdenador(), liniapedido.getUnidadesPedidas(),
						liniapedido.getUnidadesServidas(), liniapedido.getIdPedido() });
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
}

