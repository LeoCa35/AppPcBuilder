package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("LOGUEO");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(335, 527, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegistro = new JButton("REGISTRARSE");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistro.setBounds(236, 527, 89, 23);
		contentPane.add(btnRegistro);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 50, 310, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setBounds(47, 304, 56, 14);
		panel.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(47, 171, 26, 14);
		panel.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(47, 196, 213, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(47, 329, 213, 37);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblOlympogym = new JLabel("OLYMPOGYM");
		lblOlympogym.setBackground(Color.ORANGE);
		lblOlympogym.setBounds(110, 58, 71, 14);
		panel.add(lblOlympogym);
	}
}
