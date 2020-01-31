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

public class SQLLiniaPedido {
	public ArrayList<LiniaPedido> arrayLiniaPedido = new ArrayList<LiniaPedido>();
	String nombreTabla, estado;
	int idPedido,idLiniaPedido,idOrdenador,unidadesServidas,unidadesPedidas, precio;
	
	
	
	
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
	
	
	
	public void insertaPedidos(LiniaPedido liniaPedido) throws SQLException {

		// Insertamos de los campos de la tabla los valores, sacandolos del objeto
		// Cliente.java
		
		String sqlInsert = "INSERT INTO LiniaPedido(idLinia, idPedido, idOrdenador, unidadesPedidas, unidadesServidas, estado) "

				+ "VALUES(" + "\"" + liniaPedido.getIdLinia() + "\"" + "," + "\"" + liniaPedido.getIdPedido() + "\"" + ","
				+ "\"" + liniaPedido.getIdOrdenador() + "\"" + "," + "\"" + liniaPedido.getUnidadesPedidas() + "\"" + "," + "\""
				+ liniaPedido.getUnidadesServidas() + "\"" + "," + "\"" + liniaPedido.getEstado()+ "\"" + ");";

		try {

			conectar();

			sentencia = c.createStatement();

			sentencia.executeUpdate(sqlInsert);

			sentencia.close();

			c.close();

			System.out.println("Datos insertados LiniaP");

		} catch (Exception e) {

			System.out.println("Error al insertar datos en la tabla LiniaPedido");

		}

	}
	public ArrayList<LiniaPedido> guardarObjeto(String nombreTabla) throws SQLException {

		conectar();

		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				arrayLiniaPedido
						.add(new LiniaPedido(rs.getInt("idLinia"), rs.getInt("idPedido"), rs.getInt("idOrdenador"),rs.getInt("unidadesPedidas")
								,rs.getInt("unidadesServidas"),  rs.getString("estado")));
							
			}

			rs.close();
			sentencia.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo al recuperar datos");
		}
		return arrayLiniaPedido;
	}
}