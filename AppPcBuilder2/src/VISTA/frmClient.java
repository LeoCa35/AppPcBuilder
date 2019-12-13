package VISTA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.management.Query;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.source.doctree.TextTree;

//import com.sun.org.apache.xerces.internal.impl.XMLScanner.NameType;

import DADES.SQLClients;
import MODEL.Cliente;

import javax.swing.ListSelectionModel;
import java.awt.Cursor;
import java.awt.Dialog;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmClient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField_idCliente;
	private JTextField textField_email;
	private JTextField textField_direccion;
	private JTextField textField_provincia;
	private JTextField textField_cliente;
	private JTextField textField_telefono;
	private JTextField textField_municipio;
	private JTextField textField_cp;
	SQLClients con = new SQLClients();
	
	private DefaultTableModel model = new DefaultTableModel();
	JScrollPane scrollPane = new JScrollPane();
	private JTextField textField_iban;
	String idCliente;
	String cliente;
	String email;
	String telefono;
	String direccion;
	String municipio;
	String provincia;
	String cp;
	String iban;
	String codigo;
	String estado = "";
	boolean borrarDato;
	JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmClient dialog = new frmClient();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.taulas();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.3
	 */
	public frmClient() {

		setBounds(100, 100, 757, 480);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		//JScrollPane scrollPane = new JScrollPane();
		

		JLabel lblCif = new JLabel("CIF");

		JLabel lblNewLabel = new JLabel("Email");

		JLabel lblNewLabel_1 = new JLabel("Direccion");

		JLabel lblNewLabel_2 = new JLabel("Provincia");

		textField_idCliente = new JTextField();
		textField_idCliente.setColumns(10);

		textField_email = new JTextField();
		textField_email.setColumns(10);

		textField_direccion = new JTextField();
		textField_direccion.setColumns(10);

		textField_provincia = new JTextField();
		textField_provincia.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Cliente");

		textField_cliente = new JTextField();
		textField_cliente.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Telefono");

		textField_telefono = new JTextField();
		textField_telefono.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Municipio");

		textField_municipio = new JTextField();
		textField_municipio.setColumns(10);

		JRadioButton rdbtnDeudor = new JRadioButton("Deudor");

		JLabel lblNewLabel_6 = new JLabel("CP");

		textField_cp = new JTextField();
		textField_cp.setColumns(10);

		JLabel lblIban = new JLabel("IBAN");

		textField_iban = new JTextField();
		textField_iban.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblCif)
										.addComponent(lblNewLabel).addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2).addComponent(lblIban, GroupLayout.PREFERRED_SIZE,
												63, GroupLayout.PREFERRED_SIZE))
								.addGap(57)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_iban, GroupLayout.PREFERRED_SIZE, 232,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField_provincia).addComponent(textField_direccion)
												.addComponent(textField_email).addComponent(textField_idCliente,
														GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_5).addComponent(lblNewLabel_6)
														.addComponent(lblNewLabel_4).addComponent(lblNewLabel_3))
												.addGap(30)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(textField_telefono, Alignment.TRAILING)
														.addComponent(textField_cliente, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
														.addComponent(textField_municipio, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
														.addComponent(textField_cp, GroupLayout.DEFAULT_SIZE, 257,
																Short.MAX_VALUE)))
										.addComponent(rdbtnDeudor))))
						.addContainerGap()));
		gl_contentPanel
				.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(22)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblCif)
										.addComponent(textField_idCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3).addComponent(textField_cliente,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4).addComponent(textField_telefono,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(textField_direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5).addComponent(textField_municipio,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(textField_provincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6).addComponent(textField_cp,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(rdbtnDeudor).addComponent(textField_iban,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(lblIban))
								.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		table = new JTable();
		
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);

		{
			
			
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton btnDelete = new JButton("DELETE");
			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					int fila = table.getSelectedRow();
					System.out.println(fila);
					codigo = (String) model.getValueAt(table.getSelectedRow(), 0);
					System.out.println(codigo);
										
					if (fila >= 0) {
					
					} else {
						JOptionPane.showMessageDialog(null, "Selecioname una fila");
					}
					estado = "delete";
					
				}
			});

			btnDelete.setActionCommand("OK");

			JButton btnNew = new JButton("NEW");
			
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idCliente = textField_idCliente.getText();
					cliente = textField_cliente.getText();
					email = textField_email.getText();
					telefono = textField_telefono.getText();
					direccion = textField_direccion.getText();
					municipio = textField_municipio.getText();
					provincia = textField_provincia.getText();
					cp = textField_cp.getText();
					iban = textField_iban.getText();
					estado = "new";
					
				}
			});
			btnNew.setActionCommand("OK");

			JButton btnEdit = new JButton("EDIT");
			//btnEdit.setEnabled(false);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField_idCliente.setText(idCliente);
					textField_cliente.setText(cliente);
					textField_email.setText(email);
					textField_telefono.setText(telefono);
					textField_direccion.setText(direccion);
					textField_municipio.setText(municipio);
					textField_provincia.setText(provincia);
					textField_cp.setText(cp);
					textField_iban.setText(iban);
					estado = "edit";
					
				}
			});
			btnEdit.setActionCommand("OK");

			JButton btnSave = new JButton("SAVE");
			btnSave.addActionListener(new ActionListener() {
				// ACTION BOTON
				// SAVE----------------------------------------------------------------------
				public void actionPerformed(ActionEvent arg0) {
						try {
							String idClienteUpdate = textField_idCliente.getText().toString();
							String clienteUpdate = textField_cliente.getText().toString();
							String emailUpdate = textField_email.getText().toString();
							String telefonoUpdate = textField_telefono.getText().toString();
							String direccionUpdate = textField_direccion.getText().toString();
							String municipioUpdate = textField_municipio.getText().toString();
							String provinciaUpdate = textField_provincia.getText().toString();
							String cpUpdate = textField_cp.getText().toString();
							String ibanUpdate = textField_iban.getText().toString();
							
							if (estado == "delete") {
								con.deleteClients(codigo);								
							}else if (estado == "new") {
								con.insertaClients(new Cliente(idCliente, cliente, email, telefono, direccion, municipio, provincia, cp, iban));								
							}else if (estado == "edit") {
								con.updateClients(new Cliente(idClienteUpdate, clienteUpdate, emailUpdate, telefonoUpdate, direccionUpdate, municipioUpdate, provinciaUpdate, cpUpdate, ibanUpdate));								
							}
								taulas();
								
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				}

			});
			// DATA BASE

			btnSave.setActionCommand("OK");
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(1)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE).addGap(18)
							.addComponent(btnDelete).addPreferredGap(ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addContainerGap()));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(5)
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNew)
									.addComponent(btnEdit).addComponent(btnDelete).addComponent(btnSave))));
			buttonPane.setLayout(gl_buttonPane);
		}

	}

	private void taulas() {
		// TODO Auto-generated method stub
		con = new SQLClients();
		model = new DefaultTableModel();

		model.addColumn("CIF");
		model.addColumn("Cliente");
		model.addColumn("Email");
		model.addColumn("Telefono");
		model.addColumn("Direccion");
		model.addColumn("Municipio");
		model.addColumn("Provincia");
		model.addColumn("CP");
		model.addColumn("IBAN");
		model.addColumn("Deudor");

		
		table.setModel(model);

		try {

			for (Cliente cliente : con.guardarObjeto("Clientes2")) {
				model.addRow(new Object[] { cliente.getIdCliente(), cliente.getCliente(), cliente.getEmail(),
						cliente.getTelefono(), cliente.getDireccion(), cliente.getMunicipio(), cliente.getProvincia(),
						cliente.getCp(), cliente.getIban(), cliente.getDeudor() });

			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			
				//btnEdit.setEnabled(true);
				System.out.println("bro aqui llega");
				idCliente = (String) model.getValueAt(table.getSelectedRow(), 0);
				System.out.println(idCliente);
				cliente = (String) model.getValueAt(table.getSelectedRow(), 1);
				email = (String) model.getValueAt(table.getSelectedRow(), 2);
				telefono = (String) model.getValueAt(table.getSelectedRow(), 3);
				direccion = (String) model.getValueAt(table.getSelectedRow(), 4);
				municipio = (String) model.getValueAt(table.getSelectedRow(), 5);
				provincia = (String) model.getValueAt(table.getSelectedRow(), 6);
				cp = (String) model.getValueAt(table.getSelectedRow(), 7);
				iban = (String) model.getValueAt(table.getSelectedRow(), 8);
				
				
				
			}
	});
		
		
	}
}