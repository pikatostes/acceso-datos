import java.io.File;
import java.util.Scanner;

public class e5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la ruta del archivo: ");
        String path = scanner.nextLine().trim();

        File file = new File(path);
        try {
            if (file.canExecute() && file.canRead() && file.canWrite()) {
                System.out.println("El archivo tiene permisos de ejecucion, lectura y escritura");
            } else {
                System.out.println("El archivo no tiene todos los permisos");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }

        scanner.close();
    }
}
