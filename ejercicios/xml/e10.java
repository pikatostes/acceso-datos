import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class e10 {
    public static void main(String[] args) {
        // 10. Fusionar información: marcar alumnos aprobados y suspensos
        // Usando alumnos.xml:
        // Tarea:
        // Cargar el XML.
        // Para cada <alumno>:
        // Añadir un atributo nuevo llamado estado:
        // "APROBADO" si la nota es ≥ 5.
        // "SUSPENSO" si la nota es < 5.
        // Guardar el documento en alumnos_estado.xml.
        // El resultado sería algo como:
        // <alumno id="2" curso="1DAM" estado="SUSPENSO">
        // <nombre>Luis</nombre>
        // <nota>4.7</nota>
        // </alumno>

        try {
            File xmlFile = new File("./files/alumnos.xml");

            // Cargar documento existente
            Document document = XmlAux.loadDocument(xmlFile);

            // Obtener el elemento raíz <clase>
            Element clase = document.getDocumentElement();

            // Obtener lista de alumnos
            var alumnos = clase.getElementsByTagName("alumno");

            // Recorrer alumnos y añadir atributo estado según nota
            for (int i = 0; i < alumnos.getLength(); i++) {
                Element alumno = (Element) alumnos.item(i);
                Element notaElem = (Element) alumno.getElementsByTagName("nota").item(0);
                double nota = Double.parseDouble(notaElem.getTextContent());

                if (nota >= 5.0) {
                    alumno.setAttribute("estado", "APROBADO");
                } else {
                    alumno.setAttribute("estado", "SUSPENSO");
                }
            }

            // Guardar documento actualizado
            File updatedXmlFile = new File("./files/alumnos_estado.xml");
            XmlAux.saveDocument(document, updatedXmlFile);

            System.out.println("XML actualizado correctamente en " + updatedXmlFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}