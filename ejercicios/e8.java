import java.io.File;

public class e8 {
    public static void main(String[] args) {
        File file = new File("notas.txt");

        if (file.exists()) {
            if (file.renameTo(new File("notas_OLD.txt"))) {
                System.out.println("El archivo se ha renombrado correctamente.");
            } else {
                System.out.println("Ya hay un archivo con ese nombre.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
