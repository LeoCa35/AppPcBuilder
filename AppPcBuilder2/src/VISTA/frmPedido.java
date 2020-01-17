package VISTA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MODEL.Pedido;
import DADES.SQLClients;
import DADES.SQLPedido;
import DADES.llegirXML;
public class frmPedido {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	SQLPedido con = new SQLPedido();
	private DefaultTableModel model = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPedido window = new frmPedido();
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
		frame.setBounds(100, 100, 897, 380);
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
	}
	/*public void insertarPedido() {
		
		con.insertaClients(new Pedido());
	}*/
	public void taulaPedido() {
		con = new SQLPedido();
		model = new DefaultTableModel();

		model.addColumn("idPedido");
		model.addColumn("idCliente");
		model.addColumn("Data obertura");
		model.addColumn("Data tancament");
		model.addColumn("estat");
		model.addColumn("preu");
		
		table.setModel(model);
	}
	
}
