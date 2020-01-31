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
	public ArrayList<LiniaPedido> liniaPedido = new ArrayList<LiniaPedido>();

	String idCliente;
	int codigoOrdenador;
	int precio;
	int idPedidos;
	int idPedido;
	int unidadesPedidas;
	int unidadesServidas;
	String estado;
	String fechaAbertura;
	String fechaFinalizacion;
	float preuUnidad;
	char estadoPedido;
	int idLinia;
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
				idPedidos = Integer.parseInt(eElement2.getAttribute("idcomanda"));	
				idCliente = eElement2.getAttribute("idclient");
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					

					for (int temp = 0; temp < nList2.getLength(); temp++) {
						Node nNode2 = nList2.item(temp);
						//System.out.println("\nElement  :" + nNode.getNodeName());

						if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode2;
							fechaAbertura = null;
							fechaFinalizacion = null;
							idLinia++;
							codigoOrdenador = Integer.parseInt(eElement.getElementsByTagName("codi").item(0).getTextContent());

							

							
							unidadesPedidas = Integer.parseInt(eElement.getElementsByTagName("unitatsDemanades").item(0).getTextContent());
							System.out.println(unidadesPedidas);
							unidadesServidas = Integer
									.parseInt(eElement.getElementsByTagName("unitatsServides").item(0).getTextContent());
							
							estado = eElement.getElementsByTagName("status").item(0).getTextContent();
							
							liniaPedido
									.add(new LiniaPedido(idLinia,idPedidos,codigoOrdenador, unidadesPedidas,unidadesServidas, estado));
							System.out.println(liniaPedido);
							
						}
					}

					
					//System.out.println(eElement2.getAttribute("idclient"));
					//System.out.println(eElement2.getAttrib5awute("statusComanda"));
					
									
					if (eElement2.getAttribute("statusComanda").equals("0")) {

						comandes.add(new Pedido(idPedidos,eElement2.getAttribute("idclient"),eElement2.getAttribute("statusComanda")));
						
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

	public String getStatus() {
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
	public ArrayList<LiniaPedido> getLiniaPedidos(){
		return liniaPedido;
	}



	@Override
	public String toString() {
		return "llegirXML [comandes=" + comandes + ", idCliente=" + idCliente + ", codigoOrdenador=" + codigoOrdenador
				+ ", precio=" + precio + ", idPedidos=" + idPedidos + ", idPedido=" + idPedido + ", unidadesPedidas="
				+ unidadesPedidas + ", unidadesServidas=" + unidadesServidas + ", estado=" + estado + ", fechaAbertura="
				+ fechaAbertura + ", fechaFinalizacion=" + fechaFinalizacion + ", preuUnidad=" + preuUnidad
				+ ", estadoPedido=" + estadoPedido + "]";
	}



	
	

}
