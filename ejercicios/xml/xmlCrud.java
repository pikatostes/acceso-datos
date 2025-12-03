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

            if (!xmlFile.exists()) {
                System.out.println("El archivo no existe. Creando uno nuevo...");

                xmlFile.createNewFile();

                // añadir estructura básica si el archivo no existe
                DocumentBuilderFactory factoryInit = DocumentBuilderFactory.newInstance();
                DocumentBuilder builderInit = factoryInit.newDocumentBuilder();
                Document newDoc = builderInit.newDocument();

                Element root = newDoc.createElement("alumnos");
                newDoc.appendChild(root);
                saveXml(newDoc, xmlFile);
            }

            // instanciamos documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = builder.parse(xmlFile);
            xmlDoc.getDocumentElement().normalize();

            transformXml(xmlDoc, xmlFile);

            System.out.println("¿Qué desea hacer?");
            System.out.println("[1] Listar alumnos");
            System.out.println("[2] Buscar alumno por ID");
            System.out.println("[3] Añadir alumno");
            System.out.println("[4] Modificar nota de alumno");
            System.out.println("[5] Eliminar alumno");
            System.out.println("[6] Salir");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    readXml(xmlDoc);
                    break;
                case 2:
                    searchStudent(xmlDoc);
                    break;
                case 3:
                    addStudent(xmlDoc);
                    saveXml(xmlDoc, xmlFile);
                    break;
                case 4:
                    updateStudentMark(xmlDoc);
                    saveXml(xmlDoc, xmlFile);
                    break;
                case 5:
                    deleteStudent(xmlDoc);
                    saveXml(xmlDoc, xmlFile);
                    break;
                case 6:
                    System.out.println("Salida del programa.");
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

    public static void addStudent(Document xmlDoc) {
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
            System.out.println("Introduzca la nota del alumno `" + nombre + "`: ");
            Double nota = Double.parseDouble(scanner.nextLine());
            notaElem.appendChild(xmlDoc.createTextNode(nota.toString()));
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

    public static void transformXml(Document xmlDoc, File xmlFile) throws Exception {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(xmlDoc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
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

    public static void searchStudent(Document xmlDoc) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduzca el ID del alumno a buscar: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            NodeList alumnos = xmlDoc.getElementsByTagName("alumno");

            for (int i = 0; i < alumnos.getLength(); i++) {
                Node alumnoNode = alumnos.item(i);

                if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element alumnoElement = (Element) alumnoNode;
                    if (alumnoElement.getAttribute("id").equals(id.toString())) {
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static void updateStudentMark(Document xmlDoc) {
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

                        System.out.println("Introduzca la nueva nota: ");
                        String nuevaNota = scanner.nextLine();

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

    public static void deleteStudent(Document xmlDoc) {
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
