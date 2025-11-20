package xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class e1 {
    public static void main(String[] args) {
        try {
            // 1. Cargar el archivo XML
            File xmlFile = new File("./files/libros.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // 2. Obtener todos los elementos <libro>
            NodeList libros = document.getElementsByTagName("libro");

            // 3. Recorrer y mostrar los títulos
            for (int i = 0; i < libros.getLength(); i++) {
                Node libroNode = libros.item(i);

                if (libroNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element libroElement = (Element) libroNode;
                    String titulo = libroElement.getElementsByTagName("titulo")
                                    .item(0)
                                    .getTextContent();
                    System.out.println(titulo);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
