package examen;
/*
 * Pide por consola una ruta y muestra si el fichero/directorio existe, si es directorio o carpeta y su ruta absoluta
 */

import java.io.File;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la ruta del archivo/directorio:");
        String path = sc.nextLine().trim();
        
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("El fichero o directorio no existe");
            sc.close();
            return;
        }

        String type = file.isFile() ? "archivo" : "directorio";
        System.out.println("El " + type + " existe y su ruta es: ");
        System.out.println(file.getAbsolutePath());

        sc.close();
    }
}
