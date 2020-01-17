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
	private JTextField textField_provincia ;
	private JTextField textField_cliente;
	private JTextField textField_telefono;
	private JTextField textField_municipio;
	private JTextField textField_cp;
	SQLClients con = new SQLClients();
	
	JButton btnNew;
	JButton btnDelete;
	JButton btnEdit;

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
		btnEdit = new JButton("EDITAR");
		btnNew = new JButton("NEW");
		btnDelete = new JButton("BORRAR");
		setBounds(100, 100, 757, 480);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// JScrollPane scrollPane = new JScrollPane();

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
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(22)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblCif)
								.addComponent(textField_idCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3).addComponent(textField_cliente, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4).addComponent(textField_telefono,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(textField_direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5).addComponent(textField_municipio,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(textField_provincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6).addComponent(textField_cp, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
			
			btnDelete.setEnabled(false);
			btnEdit.setEnabled(false);

			textField_idCliente.setEnabled(false);
			textField_cliente.setEnabled(false);
			textField_email.setEnabled(false);
			textField_telefono.setEnabled(false);
			textField_direccion.setEnabled(false);
			textField_municipio.setEnabled(false);
			textField_provincia.setEnabled(false);
			textField_cp.setEnabled(false);
			textField_iban.setEnabled(false);

			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			/**
			 * BOTON BORRAR
			 */
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					int fila = table.getSelectedRow();
					System.out.println(fila);
					idCliente = (String) model.getValueAt(table.getSelectedRow(), 0);
					System.out.println(codigo);

					if (fila >= 0) {
						
					} else {
						JOptionPane.showMessageDialog(null, "Selecioname una fila");
					}
					estado = "delete";
					try {
						int dialogbutton = 0;
						int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro que quieres borrar este registro? ","Warning",dialogbutton );
						if (dialogResult == JOptionPane.YES_OPTION) {
							con.deleteClients(new Cliente(idCliente));
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					taulas();
				}
			});

			btnDelete.setActionCommand("OK");

			System.out.println("NEW");
			/**
			 * BOTON NUEVO
			 */
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField_idCliente.setEnabled(true);
					textField_cliente.setEnabled(true);
					textField_email.setEnabled(true);
					textField_telefono.setEnabled(true);
					textField_direccion.setEnabled(true);
					textField_municipio.setEnabled(true);
					textField_provincia.setEnabled(true);
					textField_cp.setEnabled(true);
					textField_iban.setEnabled(true);
					
					textField_idCliente.requestFocus();
					
					textField_idCliente.setText("");
					textField_cliente.setText("");
					textField_email.setText("");
					textField_telefono.setText("");
					textField_direccion.setText("");
					textField_municipio.setText("");
					textField_provincia.setText("");
					textField_cp.setText("");
					textField_iban.setText("");
					
					estado = "new";
					btnNew.setEnabled(false);
				}
			});
			btnNew.setActionCommand("OK");

			/**
			 * BOTON EDITAR
			 */
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField_idCliente.setEnabled(false);
					textField_cliente.setEnabled(true);
					textField_email.setEnabled(true);
					textField_telefono.setEnabled(true);
					textField_direccion.setEnabled(true);
					textField_municipio.setEnabled(true);
					textField_provincia.setEnabled(true);
					textField_cp.setEnabled(true);
					textField_iban.setEnabled(true);
					estado = "edit";
				}
			});
			btnEdit.setActionCommand("OK");
			/**
			 * BOTON GUARDAR
			 */
			JButton btnSave = new JButton("GUARDAR");
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

												
						if (estado == "new") {
							con.insertaClients(new Cliente(idClienteUpdate, clienteUpdate, emailUpdate, telefonoUpdate,
									direccionUpdate, municipioUpdate, provinciaUpdate, cpUpdate, ibanUpdate));
						} else if (estado == "edit") {
							con.updateClients(new Cliente(idClienteUpdate, clienteUpdate, emailUpdate, telefonoUpdate,
									direccionUpdate, municipioUpdate, provinciaUpdate, cpUpdate, ibanUpdate));
						}
						taulas();
						btnNew.setEnabled(true);
						textField_idCliente.setText("");
						textField_cliente.setText("");
						textField_email.setText("");
						textField_telefono.setText("");
						textField_direccion.setText("");
						textField_municipio.setText("");
						textField_provincia.setText("");
						textField_cp.setText("");
						textField_iban.setText("");

						textField_idCliente.setEnabled(false);
						textField_cliente.setEnabled(false);
						textField_email.setEnabled(false);
						textField_telefono.setEnabled(false);
						textField_direccion.setEnabled(false);
						textField_municipio.setEnabled(false);
						textField_provincia.setEnabled(false);
						textField_cp.setEnabled(false);
						textField_iban.setEnabled(false);
						btnEdit.setEnabled(false);
						btnDelete.setEnabled(false);
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
							.addComponent(btnDelete).addPreferredGap(ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
							.addComponent(btnSave).addContainerGap()));
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

				if (e.getClickCount() == 1) {

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

					textField_idCliente.setText(idCliente);
					textField_cliente.setText(cliente);
					textField_email.setText(email);
					textField_telefono.setText(telefono);
					textField_direccion.setText(direccion);
					textField_municipio.setText(municipio);
					textField_provincia.setText(provincia);
					textField_cp.setText(cp);
					textField_iban.setText(iban);

					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
					btnNew.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecioname una fila");
				}
			}
		});
		
		

	}
}