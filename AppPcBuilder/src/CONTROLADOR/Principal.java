package CONTROLADOR;
import CLASSES.LiniaPedido;
import CLASSES.Pedido;
import DADES.LectorXML;
public class Principal{
	public static void main(String[] args) {
		LectorXML lectura = new LectorXML();
		
		Pedido pedido1 = new Pedido(lectura.getIdCliente(),lectura.getLiniaspedido(), lectura.getEstado());
		System.out.println();
		System.out.println("pedido" + pedido1.toString()+ pedido1.getLiniaspedido());
		//System.out.println("linias pedido" + lectura.getLiniaspedido());
		
		System.out.println();
		
		
	}
}