import java.io.File;

public class e0 {
    public static void main(String[] args) {
        String filePath = "foto-tuenti.png";

        // Crear objeto File con la ruta proporcionada
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("El archivo existe.");
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
