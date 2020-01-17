package DADES;

import java.lang.reflect.Array;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import MODEL.Pedido;
import MODEL.Cliente;
import MODEL.LiniaPedido;;

public class SQLClients {

	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;

	String nombre, apellidos, email, provincia, municipio, idCliente, iban, deudor, cp, telefono, direccion;

	public ArrayList<Cliente> insertclientes = new ArrayList<Cliente>();

	public Connection conectar() {

		try {

			Class.forName("org.sqlite.JDBC");

			// Ubicació base de dades
			c = DriverManager.getConnection("jdbc:sqlite:/home/leoca35/Baixades/MONTA.db");

			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {

			System.out.println("Error al conectar con base de datos");

		}
		return c;

	}

	/**
	 * //Insertamos clientes a nuestra base de datos, los valores los cogemos de el
	 * objeto cliente
	 * 
	 * @param clientes
	 * @throws SQLException
	 */

	public void insertaClients(Cliente clientes) throws SQLException {

		// Insertamos de los campos de la tabla los valores, sacandolos del objeto
		// Cliente.java
		String sqlInsert = "INSERT INTO Clientes2(idCliente, cliente, email, telefono, direccion, municipio, provincia , cp, iban) "

				+ "VALUES(" + "\"" + clientes.getIdCliente() + "\"" + "," + "\"" + clientes.getCliente() + "\"" + ","
				+ "\"" + clientes.getEmail() + "\"" + "," + "\"" + clientes.getTelefono() + "\"" + "," + "\""
				+ clientes.getDireccion() + "\"" + "," + "\"" + clientes.getMunicipio() + "\"" + "," + "\""
				+ clientes.getProvincia() + "\"" + "," + "\"" + clientes.getCp() + "\"" + "," + "\""
				+ clientes.getIban() + "\"" + ");";

		try {

			conectar();

			sentencia = c.createStatement();

			sentencia.executeUpdate(sqlInsert);

			sentencia.close();

			c.close();

			System.out.println("Datos insertados");

		} catch (Exception e) {

			System.out.println("Error al insertar datos en la tabla");

		}

	}

	/**
	 * Actualizamos un campo en la base de datos. Actualizamos de la tabla clientes
	 * el "campo"(registro actual) y le damos un nuevo "valor".
	 * 
	 * @param idCliente
	 * @param campo
	 * @param valor
	 * @throws SQLException
	 */
	public void updateClients(Cliente clientes) throws SQLException {

		String sqlUpdate = "UPDATE Clientes2 SET" + 
		" cliente=\"" + clientes.getCliente() + 
		"\",email =\""+ clientes.getEmail() + 
		"\",telefono = \"" + clientes.getTelefono() + 
		"\",direccion =\"" + clientes.getDireccion() + 
		"\",municipio =\"" + clientes.getMunicipio() + 
		"\",provincia =\""+ clientes.getProvincia() + 
		"\",cp =\"" + clientes.getCp() + 
		"\",iban =\"" + clientes.getIban() + "\""
				+ " WHERE idCliente =" + "\"" + clientes.getIdCliente() + "\"";

		try {

			conectar();

			sentencia = c.createStatement();

			sentencia.executeUpdate(sqlUpdate);

			sentencia.close();

			c.close();

			System.out.println("Datos actualizados");

		} catch (Exception e) {

			System.out.println("Esto no actualiza");

		}

	}

	/**
	 * Borramos todo un registro de la tabla.
	 * 
	 * @param idCliente
	 * @throws SQLException
	 */
	public void deleteClients(Cliente clientes) throws SQLException {

		String deleteRow = "Delete FROM Clientes2 WHERE idCliente = '" + clientes.getIdCliente() + "'";

		try {

			conectar();

			sentencia = c.createStatement();

			System.out.println(sentencia.executeUpdate(deleteRow));

			sentencia.close();

			c.close();

			System.out.println("Datos borrados");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No borra");

		}

	}

	public ArrayList<Cliente> guardarObjeto(String nombreTabla) throws SQLException {

		conectar();

		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				insertclientes
						.add(new Cliente(rs.getString("idCliente"), rs.getString("cliente"), rs.getString("email"),
								rs.getString("telefono"), rs.getString("direccion"), rs.getString("municipio"),
								rs.getString("provincia"), rs.getString("CP"), rs.getString("IBAN")));
			}

			rs.close();
			sentencia.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo al recuperar datos");
		}
		return insertclientes;
	}

	/*
	 * public Object guardarObjeto(String nombreTabla2) { // TODO Auto-generated
	 * method stub return null; }
	 */

}
