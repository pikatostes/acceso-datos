import java.io.File;
import java.util.Scanner;

public class e7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la ruta del directorio: ");
        String path = scanner.nextLine().trim();

        // new directory
        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                System.out.println("-------------------------");
                System.out.println("Contenido del directorio:");
                System.out.println("-------------------------");
                System.out.println("Nombre\t\t\tTipo\t\tTamaño");
                for (File file : files) {
                    String type = file.isDirectory() ? "Directorio" : "Archivo";
                    Long size = file.isDirectory() ? 0 : file.length();
                    System.out.printf("%-20s %-15s %-10d bytes%n", file.getName(), type, size);
                }
            } else {
                System.out.println("No se pudo listar el contenido del directorio.");
            }
        } else {
            System.out.println("El directorio no existe o la ruta no es un directorio.");
        }

        scanner.close();
    }
}