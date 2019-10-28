package DADES;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import CLASSES.LiniaPedido;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LectorXML {
	String idCliente;
	String unidades;
	String codiArticle;
	String unidadesPedidas;
	String unidadesServidas;
	String preu;
	String preuUnitari;
	char estado;
	char estadoComanda;
	ArrayList <LiniaPedido> liniaspedido = new ArrayList<LiniaPedido>();
	
  public LectorXML() {
	  
    try {

	File fXmlFile = new File("/home/leoca35/eclipse-workspace/AppPcBuilder/pedido.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	System.out.println("idCliente :" + doc.getDocumentElement().getAttribute("idclient"));
	idCliente = doc.getDocumentElement().getAttribute("idclient");
	estadoComanda = doc.getDocumentElement().getAttribute("status").charAt(0);
			
	NodeList nList = doc.getElementsByTagName("article");
	//NodeList numeroArticulos = doc.getElementsByTagName("Ordenadores");
			
	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
		//Node nNode1 = numeroArticulos.item(temp);
		
				
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			
			codiArticle = eElement.getElementsByTagName("codi").item(0).getTextContent();
			System.out.println("CodiArticle : " + codiArticle);
			unidades = eElement.getElementsByTagName("unitats").item(0).getTextContent();
			System.out.println("Unidades : " + unidades);
			unidadesServidas = eElement.getElementsByTagName("unitatsServides").item(0).getTextContent();
			System.out.println("Unidades Servidas : " + unidadesServidas);
			preu = eElement.getElementsByTagName("preuUnitari").item(0).getTextContent();
			System.out.println("Precio unitario : " + preu);
			estado = eElement.getElementsByTagName("status").item(0).getTextContent().charAt(0);
			System.out.println("Estado : " + estado);
			
			
			liniaspedido.add(new LiniaPedido(temp+1,
					Integer.parseInt(codiArticle),
					Integer.parseInt(unidades),
					Integer.parseInt(unidadesServidas),
					Float.parseFloat(preu),
					estado));
			//liniaspedido.add(new LiniaPedido(1,1,2));
			//System.out.println(codigoArticle + " codigo cliente");
			
			//String UnidadesPedidas = eElement.getElementsByTagName("unitats").item(0).getTextContent();
			
			//System.out.println(UnidadesPedidas + " hemos pedido X unidades");
			
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
  
public String getIdCliente() {
	return idCliente;
}
public char getEstado() {
	return estadoComanda;
}
  public ArrayList<LiniaPedido> getLiniaspedido() {
	return liniaspedido;
}
 /* @Override
  public String toString() {
  	return "LectorXML [idCliente=" + idCliente + ", unidades=" + unidades + ", codiArticle=" + codiArticle
  			+ ", unidadesPedidas=" + unidadesPedidas + ", unidadesServidas=" + unidadesServidas + ", preuUnitari="
  			+ preuUnitari + ", estado=" + estado + ", liniaspedido=" + liniaspedido + "]";
  }*/
 

}