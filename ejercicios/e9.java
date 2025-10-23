import java.io.File;
import java.util.Scanner;

public class e9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo: ");
        String path = scanner.nextLine().trim();
        scanner.close();

        File file = new File(path);

        if (file.exists() && file.isFile()) {
            try {
                file.delete();
                System.out.println("El archivo ha sido eliminado correctamente.");
            } catch (Exception e) {
                System.out.println("Ocurrio un error al eliminar el archivo.");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
