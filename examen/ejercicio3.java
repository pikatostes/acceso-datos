/*
 * Crea un fichero notas.txt en la carpeta ejercicios (ejercicio 2) e indica si ya existia
 */

package examen;

import java.io.File;

public class ejercicio3 {
    public static void main(String[] args) {
        try {
            File file = new File("dam/accdata/ejercicios/notas.txt");

            if (!file.createNewFile()) {
                System.out.println("El archivo ya existe");
            } else {
                System.out.println("El archivo fue creado con éxito");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }
}
