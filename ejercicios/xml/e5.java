import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class e5 {
    public static void main(String[] args) {
        // 5. Crear una lista de productos a partir de datos “hardcodeados”
        // Tarea:
        // En el propio código Java, define un array o lista de productos con: nombre, precio y stock.
        // Por ejemplo, 3 o 4 productos.
        // Crear un XML con esta estructura:
        // <tienda>
        //     <producto id="1">
        //         <nombre>Teclado</nombre>
        //         <precio>19.99</precio>
        //         <stock>15</stock>
        //     </producto>
        //     <!-- etc. -->
        // </tienda>

        // Los id pueden ser numéricos y generarse en el bucle.
        // Guardarlo como tienda.xml.

        try {
            File xmlFile = new File("./files/tienda.xml");

            // Crear documento nuevo en blanco
            Document document = XmlAux.loadDocument(null); // Documento nuevo();

            // Crear el elemento raíz <tienda>
            Element tienda = document.createElement("tienda");
            document.appendChild(tienda);

            // Datos hardcodeados de productos
            String[][] productos = {
                {"Teclado", "19.99", "15"},
                {"Ratón", "9.99", "30"},
                {"Monitor", "129.99", "10"},
                {"Impresora", "79.99", "5"}
            };

            // Crear elementos <producto>
            for (int i = 0; i < productos.length; i++) {
                Element producto = document.createElement("producto");
                producto.setAttribute("id", String.valueOf(i + 1));

                Element nombre = document.createElement("nombre");
                nombre.appendChild(document.createTextNode(productos[i][0]));
                producto.appendChild(nombre);

                Element precio = document.createElement("precio");
                precio.appendChild(document.createTextNode(productos[i][1]));
                producto.appendChild(precio);

                Element stock = document.createElement("stock");
                stock.appendChild(document.createTextNode(productos[i][2]));
                producto.appendChild(stock);

                tienda.appendChild(producto);
            }

            // Guardar documento
            XmlAux.saveDocument(document, xmlFile);

            System.out.println("XML creado correctamente en " + xmlFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
