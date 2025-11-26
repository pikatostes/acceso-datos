import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class e9 {
    public static void main(String[] args) {
        // 9. Eliminar nodos según un criterio
        // Usando libros.xml (del ejercicio 1) o uno similar con más libros.
        // Tarea:
        // Cargar el XML.
        // Eliminar todos los <libro> cuyo <autor> sea, por ejemplo, "Cervantes".
        // Guardar el resultado en libros_sin_cervantes.xml.

        try {
            File xmlFile = new File("./files/libros.xml");

            // Cargar documento existente
            Document document = XmlAux.loadDocument(xmlFile);

            // Obtener el elemento raíz <biblioteca>
            Element biblioteca = document.getDocumentElement();

            // Obtener lista de libros
            var libros = biblioteca.getElementsByTagName("libro");

            // Recorrer libros y eliminar los que cumplan el criterio
            for (int i = libros.getLength() - 1; i >= 0; i--) {
                Element libro = (Element) libros.item(i);
                Element autorElem = (Element) libro.getElementsByTagName("autor").item(0);
                String autor = autorElem.getTextContent();

                if ("Cervantes".equals(autor)) {
                    biblioteca.removeChild(libro);
                }
            }

            // Guardar documento actualizado
            File updatedXmlFile = new File("./files/libros_sin_cervantes.xml");
            XmlAux.saveDocument(document, updatedXmlFile);

            System.out.println("XML actualizado correctamente en " + updatedXmlFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
