package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class e2 {
    public static void main(String[] args) {
        // Tarea:
        // - Leer todos los alumnos.
        // - Mostrar por consola: id, nombre, curso y nota.
        // - Solo mostrar los alumnos cuya nota sea mayor o igual que 5.

        try {
            // 1. Cargar el archivo XML
            File xmlFile = new File("./files/alumnos.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // 2. Obtener todos los elementos <alumnos>
            NodeList alumnos = document.getElementsByTagName("alumno");

            // 3. Recorrer y mostrar los títulos
            for (int i = 0; i < alumnos.getLength(); i++) {
                Node alumnoNode = alumnos.item(i);

                if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element alumnoElement = (Element) alumnoNode;
                    if (Double.parseDouble(alumnoElement.getElementsByTagName("nota")
                            .item(0)
                            .getTextContent()) <= 5) {
                        continue;
                    }
                    String id = alumnoElement.getAttribute("id");
                    String nombre = alumnoElement.getElementsByTagName("nombre")
                                    .item(0)
                                    .getTextContent();
                    String curso = alumnoElement.getAttribute("curso");
                    String nota = alumnoElement.getElementsByTagName("nota")
                                    .item(0)
                                    .getTextContent();
                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Curso: " + curso + ", Nota: " + nota);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
