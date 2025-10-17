/*
 * En un directorio lista solo los ficheros con extension .txt
 */

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class e8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la ruta del directorio: ");
        String path = sc.nextLine().trim();

        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("tonoto");
            sc.close();
            return;
        }

        FilenameFilter soloTxt = (dir1, nombre) -> nombre.toLowerCase().endsWith(".txt");
        File[] files = dir.listFiles(soloTxt);

        if (files == null) {
            System.out.println("No se encontró contenido");
            sc.close();
            return;
        }

        for (File file : files) {
            System.out.println(file.getName());
        }

        sc.close();
    }
}
