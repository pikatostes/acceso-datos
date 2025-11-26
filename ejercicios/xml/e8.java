import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class e8 {
    public static void main(String[] args) {
        // 8. Actualizar notas por condición
        // Con alumnos.xml:
        // Tarea:
        // Cargar el archivo.
        // Recorrer los alumnos cuyo curso sea "1DAM".
        // Aumentar su nota en 0.5 puntos, pero sin superar nunca el 10.
        // Guardar el XML actualizado.

        try {
            File xmlFile = new File("./files/alumnos.xml");

            // Cargar documento existente
            Document document = XmlAux.loadDocument(xmlFile);

            // Obtener el elemento raíz <clase>
            Element clase = document.getDocumentElement();

            // Obtener lista de alumnos
            var alumnos = clase.getElementsByTagName("alumno");

            // Recorrer alumnos y actualizar notas según condición
            for (int i = 0; i < alumnos.getLength(); i++) {
                Element alumno = (Element) alumnos.item(i);
                String curso = alumno.getAttribute("curso");

                if ("1DAM".equals(curso)) {
                    Element notaElem = (Element) alumno.getElementsByTagName("nota").item(0);
                    double nota = Double.parseDouble(notaElem.getTextContent());
                    nota = Math.min(nota + 0.5, 10.0); // Aumentar 0.5 sin superar 10
                    notaElem.setTextContent(String.valueOf(nota));
                }
            }

            // Guardar documento actualizado
            File updatedXmlFile = new File("./files/alumnos_actualizado.xml");
            XmlAux.saveDocument(document, updatedXmlFile);

            System.out.println("XML actualizado correctamente en " + updatedXmlFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
