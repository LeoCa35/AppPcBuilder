package DADES;

import java.lang.reflect.Array;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import MODEL.Pedido;
import MODEL.Cliente;
import MODEL.LiniaPedido;

public class SQLPedido {
	public ArrayList<Pedido> arraypedido = new ArrayList<Pedido>();
	String nombreTabla, fechaApertura;
	int idPedido, precio;
	String idCliente, fechaFinalizacion;
	
	char estado;
	
	Connection c = null;

	Statement sentencia = null;
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
	public void insertaPedidos(Pedido pedido) throws SQLException {

		// Insertamos de los campos de la tabla los valores, sacandolos del objeto
		//Pedido.java
		String sqlInsert = "INSERT INTO Pedido(idPedido, idCliente, dataObertura, dataTancament, estat,preu) "

				+ "VALUES(" + "\"" + pedido.getIdPedido() + "\"" + "," + "\"" + pedido.getIdCliente() + "\"" + ","
				+ "\"" + pedido.getFechaApertura() + "\"" + "," + "\"" + pedido.getFechaFinalizacion() + "\"" + "," + "\""
				+ pedido.getEstado() + "\"" + "," + "\"" + pedido.getPrecio() + "\"" + ");";

		try {

			conectar();

			sentencia = c.createStatement();

			sentencia.executeUpdate(sqlInsert);

			sentencia.close();

			c.close();

			System.out.println("Datos insertadoss");

		} catch (Exception e) {

			System.out.println("Error al insertar datos en la tabla");

		}
		
	}
	public ArrayList<Pedido> guardarObjeto(String nombreTabla) throws SQLException {

		conectar();

		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				arraypedido
						.add(new Pedido(rs.getInt("idPedido"), rs.getString("idCliente"), rs.getString("dataObertura"),
								rs.getString("dataTancament"),rs.getString("estat"),  rs.getInt("preu")));
							
			}

			rs.close();
			sentencia.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo al recuperar datos");
		}
		return arraypedido;
	}
}