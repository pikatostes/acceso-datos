import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xmlCrud {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            File xmlFile = new File("./files/alumnos.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = builder.parse(xmlFile);
            xmlDoc.getDocumentElement().normalize();

            System.out.println("¿Qué desea hacer?");
            System.out.println("[1] CREATE");
            System.out.println("[2] READ");
            System.out.println("[3] UPDATE");
            System.out.println("[4] DELETE");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    createXml(xmlDoc);
                    saveXml(xmlDoc, xmlFile);
                    break;
                case 2:
                    readXml(xmlDoc);
                    saveXml(xmlDoc, xmlFile);
                    break;
                case 3:
                    updateXml(xmlDoc);
                    saveXml(xmlDoc, xmlFile);
                    break;
                case 4:
                    deleteXml(xmlDoc);
                    saveXml(xmlDoc, xmlFile);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static void createXml(Document xmlDoc) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Introduzca el nombre del nuevo alumno: ");
            String nombre = scanner.nextLine();

            // Obtener el ID nuevo automáticamente
            NodeList alumnos = xmlDoc.getElementsByTagName("alumno");
            int newId = alumnos.getLength() + 1;

            Element alumno = xmlDoc.createElement("alumno");
            alumno.setAttribute("id", Integer.toString(newId));
            alumno.setAttribute("curso", "2DAM");

            Element nombreElem = xmlDoc.createElement("nombre");
            nombreElem.appendChild(xmlDoc.createTextNode(nombre));
            alumno.appendChild(nombreElem);

            Element notaElem = xmlDoc.createElement("nota");
            notaElem.appendChild(xmlDoc.createTextNode("7.3"));
            alumno.appendChild(notaElem);

            // Insertar en la raíz
            xmlDoc.getDocumentElement().appendChild(alumno);

            System.out.println("Alumno añadido correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static void saveXml(Document xmlDoc, File xmlFile) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(xmlDoc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);

        System.out.println("XML guardado correctamente.");
    }

    public static void readXml(Document xmlDoc) {
        NodeList alumnos = xmlDoc.getElementsByTagName("alumno");

        for (int i = 0; i < alumnos.getLength(); i++) {
            Node alumnoNode = alumnos.item(i);

            if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                Element alumnoElement = (Element) alumnoNode;
                System.out.println("ID: " + alumnoElement.getAttribute("id"));
                System.out.println("Nombre: " + alumnoElement.getElementsByTagName("nombre")
                        .item(0)
                        .getTextContent());
                System.out.println("Nota: " + alumnoElement.getElementsByTagName("nota")
                        .item(0)
                        .getTextContent());
            }
        }
    }

    public static void updateXml(Document xmlDoc) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Introduzca el ID del alumno a actualizar: ");
            String id = scanner.nextLine();

            NodeList alumnos = xmlDoc.getElementsByTagName("alumno");
            boolean found = false;

            for (int i = 0; i < alumnos.getLength(); i++) {
                Node alumnoNode = alumnos.item(i);

                if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element alumnoElement = (Element) alumnoNode;

                    if (alumnoElement.getAttribute("id").equals(id)) {
                        found = true;

                        System.out.println("Introduzca el nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();

                        System.out.println("Introduzca la nueva nota: ");
                        String nuevaNota = scanner.nextLine();

                        alumnoElement.getElementsByTagName("nombre")
                                .item(0)
                                .setTextContent(nuevoNombre);
                        alumnoElement.getElementsByTagName("nota")
                                .item(0)
                                .setTextContent(nuevaNota);

                        System.out.println("Alumno actualizado correctamente.");
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Alumno con ID " + id + " no encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static void deleteXml(Document xmlDoc) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Introduzca el ID del alumno a eliminar: ");
            String id = scanner.nextLine();

            NodeList alumnos = xmlDoc.getElementsByTagName("alumno");
            boolean found = false;

            for (int i = 0; i < alumnos.getLength(); i++) {
                Node alumnoNode = alumnos.item(i);

                if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element alumnoElement = (Element) alumnoNode;

                    if (alumnoElement.getAttribute("id").equals(id)) {
                        found = true;
                        if (alumnoNode.getParentNode().removeChild(alumnoNode) != null) {
                            System.out.println("Alumno eliminado correctamente.");
                        }
                        
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Alumno con ID " + id + " no encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
