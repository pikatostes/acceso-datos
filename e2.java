import java.io.File;
import java.util.Scanner;

public class e2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo: ");
        String filePath = scanner.nextLine();

        // Crear objeto File con la ruta proporcionada
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("El archivo existe.");
        } else {
            System.out.println("El archivo no existe.");
        }

        scanner.close();
    }
}
