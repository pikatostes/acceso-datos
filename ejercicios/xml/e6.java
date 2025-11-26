import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class e6 {
    public static void main(String[] args) {
        // 6. Generar un XML con fecha y hora actuales
        // Tarea:
        // Crear un XML llamado log.xml con esta estructura:
        //     <log>
        //         <evento tipo="INICIO">
        //             <fecha>2025-11-16</fecha>
        //             <hora>10:35:12</hora>
        //             <mensaje>Aplicación iniciada correctamente.</mensaje>
        //         </evento>
        //     </log>
        // La fecha y hora deben obtenerse de la API de tiempo de Java (LocalDate, LocalTime o LocalDateTime).
        // El tipo puede ser fijo: "INICIO".

        try {
            File xmlFile = new File("./files/log.xml");

            // Crear documento nuevo en blanco
            Document document = XmlAux.loadDocument(null); // Documento nuevo();

            // Crear el elemento raíz <log>
            Element log = document.createElement("log");
            document.appendChild(log);

            // Crear <evento tipo="INICIO">
            Element evento = document.createElement("evento");
            evento.setAttribute("tipo", "INICIO");
            log.appendChild(evento);

            // Obtener fecha y hora actuales
            LocalDate fechaActual = LocalDate.now();
            LocalTime horaActual = LocalTime.now().withNano(0); // Sin nanosegundos

            // Crear <fecha>
            Element fecha = document.createElement("fecha");
            fecha.appendChild(document.createTextNode(fechaActual.toString()));
            evento.appendChild(fecha);

            // Crear <hora>
            Element hora = document.createElement("hora");
            hora.appendChild(document.createTextNode(horaActual.toString()));
            evento.appendChild(hora);

            // Crear <mensaje>
            Element mensaje = document.createElement("mensaje");
            mensaje.appendChild(document.createTextNode("Aplicación iniciada correctamente."));
            evento.appendChild(mensaje);

            // Guardar documento
            XmlAux.saveDocument(document, xmlFile);

            System.out.println("XML creado correctamente en " + xmlFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
