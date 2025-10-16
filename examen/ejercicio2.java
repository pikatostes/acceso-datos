/*
 * Crea dentro del directorio actual la carpeta dam/accdat/ejercicios y muestra si se creó correctamente
 */

package examen;

import java.io.File;

public class ejercicio2 {
    public static void main(String[] args) {
        File directory = new File("dam/accdata/ejercicios");

        if (!directory.exists()) {
            directory.mkdirs();
            System.out.println("El directorio se ha creado correctamente");
        } else {
            System.out.println("El directorio ya existe");
        }
    }
}
