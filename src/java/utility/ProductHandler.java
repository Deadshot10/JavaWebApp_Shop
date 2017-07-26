package utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ProductHandler {

	ArrayList<Product> products;
	
	public ProductHandler() {
		products = new ArrayList<>();
	}
	
	public ArrayList<Product> parseFile(InputStream xmlFile) {
        try {
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        	dbf.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			doc.getDocumentElement().normalize();
	    	insertParsedData(doc);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
        return products;
	}
	
	public ArrayList<Product> parseFile(File xmlFile) {
        try {
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        	dbf.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			doc.getDocumentElement().normalize();
	    	insertParsedData(doc);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
        return products;
	}

	private void insertParsedData(Document doc) {
		NodeList nList = doc.getElementsByTagName("product");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				long product_id = Long.parseLong(eElement.getElementsByTagName("product_id").item(0).getChildNodes().item(0).getNodeValue());
				long price = Long.parseLong(eElement.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue());
				long inet_price = Long.parseLong(eElement.getElementsByTagName("inet_price").item(0).getChildNodes().item(0).getNodeValue());
				String title = String.valueOf(eElement.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue());
				String description = String.valueOf(eElement.getElementsByTagName("description").item(0).getChildNodes().item(0).getNodeValue());
				String image = String.valueOf(eElement.getElementsByTagName("image").item(0).getChildNodes().item(0).getNodeValue());
				float rating = Float.parseFloat(eElement.getElementsByTagName("rating").item(0).getChildNodes().item(0).getNodeValue());
				
				products.add(new Product(product_id, title, description, rating, price, inet_price, image));
			}
		}
	}
	
	
}
