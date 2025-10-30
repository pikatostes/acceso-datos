import java.io.File;

public class e8 {
    public static void main(String[] args) {
        File file = new File("notas.txt");
        File renamedFile = new File("notas_OLD.txt");

        if (file.exists()) {
            if (renamedFile.exists()) {
                System.out.println("Ya hay un archivo con ese nombre.");
            } else if (file.renameTo(renamedFile)) {
                System.out.println("El archivo se ha renombrado correctamente.");
            } else {
                System.out.println("Ya hay un archivo con ese nombre.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
