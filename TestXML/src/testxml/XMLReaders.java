
package testxml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReaders {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        
        try {
            DocumentBuilder builder= factory.newDocumentBuilder();
            Document document= builder.parse("students.xml");
            document.getDocumentElement().normalize();
            
            Element rootElement= document.getDocumentElement();
            System.out.println(rootElement);
            
            NodeList nodeList= document.getElementsByTagName("student");
            System.out.println(nodeList);
            
            for(int i = 0; i< nodeList.getLength(); i++){
                Node node= nodeList.item(i);
                if(node.getNodeType()==node.ELEMENT_NODE){
                Element element= (Element) node;
                
                String id= element.getElementsByTagName("id").item(0).getTextContent();
                String name= element.getElementsByTagName("name").item(0).getTextContent();
                String age= element.getElementsByTagName("age").item(0).getTextContent();
                
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                }
            }
            
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLReaders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
