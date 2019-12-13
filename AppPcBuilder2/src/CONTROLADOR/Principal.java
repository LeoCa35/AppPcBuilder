package CONTROLADOR;
import java.sql.SQLException;

import DADES.SQLClients;
import DADES.llegirXML;
import MODEL.Pedido;
import MODEL.Cliente;
import MODEL.LiniaPedido;
public class Principal {

	
	public static void main(String[] args) throws SQLException {
		llegirXML Lector1=new llegirXML();
		//System.out.println(Comanda1.toString());
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println(Lector1.getComandes());
		System.out.println("--------------------------------------------------------------------------------------------");
		SQLClients clientes = new SQLClients();
		//clientes.consultaClients("Clientes2");
		
		//Insertamos un Cliente en la base de datos
		clientes.insertaClients(new Cliente("aaaaa ", "leo", "calabro", "leocalabro30@gmail.com", "695188174", "Barcelona", "Barcelona", "08260", "ES132456789413132"));
		
		//Actualizamos de la tabla idCliente bbb a aaa
		//clientes.updateClients("bbb", "idCliente", "aaa");
		
		//Borramos registro si idCliente = aaa
		//clientes.deleteClients("aaa");
		
	}
}
