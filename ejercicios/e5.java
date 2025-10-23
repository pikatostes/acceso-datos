import java.io.File;
import java.util.Scanner;
import java.util.Date; // Necesario para Date
import java.text.SimpleDateFormat; // Necesario para formatear

public class e5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo:");
        String path = scanner.nextLine().trim();

        File file = new File(path);

        if (file.exists() && file.isFile()) {
            // Crear un objeto Date a partir de los milisegundos
            Date lastModifiedDate = new Date(file.lastModified());

            // Formatear e imprimir el resultado
            System.out.println("El archivo pesa: " + file.length() + " bytes");
            System.out.println("Última modificación: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(lastModifiedDate));
        } else {
            System.out.println("El archivo no existe");
        }
        scanner.close();
    }
}