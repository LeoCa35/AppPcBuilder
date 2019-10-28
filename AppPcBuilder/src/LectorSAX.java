
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class LectorSAX {
	public static void main(String[] args) {
		try {
			XMLReader processadorXML = XMLReaderFactory.createXMLReader();
			processadorXML.setContentHandler(new ElMeuControlador());
			processadorXML.parse(new InputSource("pedido.xml"));
		} catch (SAXException | IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
