package Server.Presentation.Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlMethods {
	
	private static TransformerFactory transformerFactory;
	private static Transformer transformer;
	private static DocumentBuilderFactory documentFactory;
	private static DocumentBuilder documentBuilder;
	
	private static List<Account> listCompte;
	
	public static void readAccount(){
		listCompte = new ArrayList<Account>();
		
		NodeList nodes = parseXMLFile("files/accounts.xml");
		if (nodes == null) return;
		
		for (int i = 0; i<nodes.getLength(); i++) {
			if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE)   {
				Element currentElement = (Element) nodes.item(i);
				if (currentElement.getNodeName().equals("account")) 	{
					try {
						
						String identifiant = currentElement.getElementsByTagName("identifiant").item(0).getTextContent();
						String password = currentElement.getElementsByTagName("password").item(0).getTextContent();
						String pseudo = currentElement.getElementsByTagName("pseudo").item(0).getTextContent();
						//verify that I read everything correctly:
						System.out.println(identifiant + " " + password + " " + pseudo);
						
						Account newClient = new Account(identifiant, password, pseudo);
						
						listCompte.add(newClient);
						
					} catch (Exception ex) {
						System.out.println("Something is wrong with the XML client element");
					}
				}
			}  
		}
	}
	
	public static void writeAccount() {
		Document document = createXMLDocument();
		if (document == null) return;

 		// create root element
		Element root = document.createElement("accounts");
		document.appendChild(root);

			for(int i = 0; i<listCompte.size();i++) {
				//save one "client" element; create a loop to save more elements!!
				Element account = document.createElement("account");
				String identifiant = listCompte.get(i).getIdentifiant();
				Element identifiantElement = document.createElement("identifiant");
				identifiantElement.appendChild(document.createTextNode(identifiant));
				account.appendChild(identifiantElement);
				//lastName element
				String password = listCompte.get(i).getPassword();
				Element passwordElement = document.createElement("password");
				passwordElement.appendChild(document.createTextNode(password));
				account.appendChild(passwordElement);
				//address element
				String pseudo = listCompte.get(i).getPseudo();
				Element pseudoElement = document.createElement("pseudo");
				pseudoElement.appendChild(document.createTextNode(pseudo));
				account.appendChild(pseudoElement);
				
				root.appendChild(account);
			}
		
		createXMLFile(document, "files/accounts.xml");
	}
	
	public static boolean testLoginAccount(String id, String pw) {
		for(int i=0;i<listCompte.size();i++) {
			if(listCompte.get(i).getIdentifiant().equals(id) && listCompte.get(i).getPassword().equals(pw)) {
				return true;
			}
		}
		return false;
	}
	
	public static String testNewAccount(String id, String pseudo) {
		for(int i = 0; i<listCompte.size();i++) {
			if(listCompte.get(i).getIdentifiant().equals(id)) {
				return "Identifiant déjà utilisé";
			}else if(listCompte.get(i).getPseudo().equals(pseudo)) {
				return "Pseudo déjà utilisé";
			}
		}
		
		return "OK";
	}
	
	public static void createXMLFile(Document document, String filePath)
	{
		try {
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(filePath));

		// If you use
		// StreamResult result = new StreamResult(System.out);
		// the output will be pushed to the standard output ...
		// You can use that for debugging 

        //transform the DOM Object to an XML File
		transformer.transform(domSource, streamResult);
		
		} catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
		System.out.println("Done creating XML File");
	}
	
	public static Document createXMLDocument()
	{
		return documentBuilder.newDocument();
	}
	
	public static void loadXMLData() {
		try {
			transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			documentFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentFactory.newDocumentBuilder();
		} catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
	}
	
	public static NodeList parseXMLFile (String filePath) {
		NodeList elementNodes = null;
		try {
			Document document= documentBuilder.parse(new File(filePath));
			Element root = document.getDocumentElement();
			
			elementNodes = root.getChildNodes();	
		}
		catch (SAXException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return elementNodes;
	}

	public static void addAccount(Account compte) {
		listCompte.add(compte);
	}
	
}
