/* 
 * crear aplicacion compruebe si existe determinado archivo
 * uso clase java.io.File
 * metodo exists()
 */

import java.io.File;
import java.util.Scanner;

public class FileExists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo: ");
        String filePath = scanner.nextLine();

        // Crear objeto File con la ruta proporcionada
        File file = new File(filePath);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("El directorio existe: " + file.getAbsolutePath());
            } else if (file.isFile()) {
                System.out.println("El archivo existe: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("El archivo no existe.");
        }

        scanner.close();
    }
}