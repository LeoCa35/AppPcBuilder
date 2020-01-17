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
import MODEL.LiniaPedido;

public class SQLPedido {
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
	public void insertaClients(Pedido pedido) throws SQLException {

		// Insertamos de los campos de la tabla los valores, sacandolos del objeto
		// Cliente.java
		String sqlInsert = "INSERT INTO Pedido(idPedido, idCliente, dataObertura, dataTancament, estat,preu) "

				+ "VALUES(" + "\"" + pedido.getIdPedido() + "\"" + "," + "\"" + pedido.getIdCliente() + "\"" + ","
				+ "\"" + pedido.getEstado() + "\"" + "," + "\"" + pedido.getFechaAbertura() + "\"" + "," + "\""
				+ pedido.getFechaFinalizacion() + "\"" + "," + "\"" + pedido.getPrecio() + "\"" + ");";

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
}