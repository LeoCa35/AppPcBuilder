package DADES;

import MODEL.LiniaPedido;
import MODEL.Pedido;
import java.util.Date;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
public class llegirXML {
	public ArrayList<Pedido> comandes = new ArrayList<Pedido>();

	String idCliente;
	String codigoOrdenador;
	int precio;
	int idPedido;
	int unidades;
	char estado;
	Date fechaAbertura;
	String fechaFinalizacion;
	float preuUnidad;
	char estadoPedido;
	
	public llegirXML() {

		try {
			File inputFile = new File("comanda.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("comanda");

			System.out.println("----------------------------");
			
			for (int tempo = 0; tempo < nList.getLength(); tempo++) {

				Node nNode = nList.item(tempo);
				Element eElement2 = (Element) nNode;
				ArrayList<LiniaPedido> liniaComanda = new ArrayList<LiniaPedido>();
				NodeList nList2 = nList.item(tempo).getChildNodes();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					for (int temp = 0; temp < nList2.getLength(); temp++) {
						Node nNode2 = nList2.item(temp);
						//System.out.println("\nElement  :" + nNode.getNodeName());

						if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode2;
							fechaAbertura = new Date();
							fechaFinalizacion = null;
							precio = 0;
							//System.out.println(
								//	"Codi article: " + eElement.getElementsByTagName("codi").item(0).getTextContent());
							codigoOrdenador = eElement.getElementsByTagName("codi").item(0).getTextContent();

							estado = eElement.getElementsByTagName("status").item(0).getTextContent().charAt(0);

							//System.out.println(
									//"Unitats : " + eElement.getElementsByTagName("unitats").item(0).getTextContent());
							unidades = Integer
									.parseInt(eElement.getElementsByTagName("unitats").item(0).getTextContent());

							/*preuUnidad = Float
									.parseFloat(eElement.getElementsByTagName("preuUnitat").item(0).getTextContent());
							 */
							liniaComanda
									.add(new LiniaPedido((temp + 1)/2 , tempo + 1, codigoOrdenador, unidades,/* preuUnidad,*/ estado));
							
						}
					}
					idPedido = tempo + 1;
					
				//	System.out.println(eElement2.getAttribute("idclient"));
					//System.out.println(eElement2.getAttrib5awute("statusComanda"));
					idCliente = eElement2.getAttribute("idclient");
					idPedido = Integer.parseInt(eElement2.getAttribute("idComanda"));					
					if (eElement2.getAttribute("statusComanda").equals("0")) {

						comandes.add(new Pedido(idPedido,eElement2.getAttribute("idclient"),
								eElement2.getAttribute("statusComanda").charAt(0),fechaAbertura,fechaFinalizacion,precio));
						
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	

	
	public void setIdComanda(int idComanda) {
		this.idPedido = idComanda;
	}

	public int getIdComanda() {
		return idPedido;
	}

	public char getStatus() {
		return estado;
	}

	public String getIdClient() {
		return idCliente;
	}

	public char getStatusc() {
		return estadoPedido;
	}

	public ArrayList<Pedido> getComandes() {
		return comandes;
	}



	@Override
	public String toString() {
		return "llegirXML [idPedido=" + idPedido + ", idCliente=" + idCliente + ", codigoOrdenador=" + codigoOrdenador
				+  ", unidades=" + unidades + ", estado=" + estado + ", preuUnidad="
				+ preuUnidad + ", estadoPedido=" + estadoPedido + "]";
	}

	

}
