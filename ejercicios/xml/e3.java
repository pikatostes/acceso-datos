import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class e3 {
    public static void main(String[] args) {
        // 3. Contar nodos y calcular una media

        // Usando el mismo alumnos.xml del ejercicio 2:

        // Tarea:
        // - Contar cuántos alumnos hay en total.
        // - Calcular la nota media de todos los alumnos.
        // - Mostrar:
        //     - Número total de alumnos.
        //     - Nota media con dos decimales.

        try {
            // 1. Cargar el archivo XML
            File xmlFile = new File("./files/alumnos.xml");
            Document document = XmlAux.loadDocument(xmlFile);

            // 2. Obtener todos los elementos <alumnos>
            NodeList alumnos = document.getElementsByTagName("alumno");

            // 3. Recorrer alumnos
            int totalAlumnos = 0;
            double mediaNotas = 0.0;

            for (int i = 0; i < alumnos.getLength(); i++) {
                Node alumnoNode = alumnos.item(i);

                if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element alumnoElement = (Element) alumnoNode;
                    totalAlumnos++;
                    mediaNotas += Double.parseDouble(alumnoElement.getElementsByTagName("nota")
                            .item(0)
                            .getTextContent());
                }
            }

            System.out.println("Número total de alumnos: " + totalAlumnos);
            System.out.printf("Nota media: %.2f%n", mediaNotas / totalAlumnos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
