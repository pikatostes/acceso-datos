import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class e4 {
    public static void main(String[] args) {

        try {
            File xmlFile = new File("./files/empresa.xml");

            // Crear documento nuevo en blanco
            Document document = XmlAux.loadDocument(null); // Documento nuevo();

            // Crear el elemento raíz <empresa>
            Element empresa = document.createElement("empresa");
            document.appendChild(empresa);

            // Crear <departamento nombre="Informática">
            Element departamento = document.createElement("departamento");
            departamento.setAttribute("nombre", "Informática");
            empresa.appendChild(departamento);

            // Crear <empleado>
            Element empleado = document.createElement("empleado");
            departamento.appendChild(empleado);

            // Crear <nombre>Ana</nombre>
            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode("Ana"));
            empleado.appendChild(nombre);

            // Crear <puesto>Desarrolladora</puesto>
            Element puesto = document.createElement("puesto");
            puesto.appendChild(document.createTextNode("Desarrolladora"));
            empleado.appendChild(puesto);

            // Guardar documento
            XmlAux.saveDocument(document, xmlFile);

            System.out.println("XML creado correctamente en " + xmlFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
