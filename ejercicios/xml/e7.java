import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class e7 {
    public static void main(String[] args) {
        // 7. Añadir un nuevo alumno al XML
        // Usando de nuevo alumnos.xml:
        // Tarea:
        // Cargar el XML existente.
        // Crear un nuevo <alumno> con:
        //     Atributo id="4" y curso="2DAM".
        //     <nombre>Nuevo Alumno</nombre>
        //     <nota>7.3</nota>
        // Insertar el nuevo alumno como hijo de <clase>.
        // Guardar los cambios sobre el mismo archivo o en uno nuevo (alumnos_actualizado.xml).

        try {
            File xmlFile = new File("./files/alumnos.xml");

            // Cargar documento existente
            Document document = XmlAux.loadDocument(xmlFile);

            // Obtener el elemento raíz <clase>
            Element clase = document.getDocumentElement();

            // Crear nuevo <alumno> con atributos
            Element alumno = document.createElement("alumno");
            alumno.setAttribute("id", "4");
            alumno.setAttribute("curso", "2DAM");
            clase.appendChild(alumno);

            // Crear <nombre>Nuevo Alumno</nombre>
            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode("Nuevo Alumno"));
            alumno.appendChild(nombre);

            // Crear <nota>7.3</nota>
            Element nota = document.createElement("nota");
            nota.appendChild(document.createTextNode("7.3"));
            alumno.appendChild(nota);

            // Guardar documento actualizado
            File updatedXmlFile = new File("./files/alumnos_actualizado.xml");
            XmlAux.saveDocument(document, updatedXmlFile);

            System.out.println("XML actualizado correctamente en " + updatedXmlFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
