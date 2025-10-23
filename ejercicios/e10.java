import java.io.File;

public class e10 {
    public static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No se pudo listar el contenido del directorio.");
        } else {
            for (File file : files) {
                deleteDirectory(file);
            }
        }

        if (directory.delete()) {
            System.out.println("El directorio se ha eliminado correctamente.");
        }
    }

    public static void main(String[] args) {
        String path = "../proyecto";

        File directory = new File(path);

        if (!directory.exists()) {
            deleteDirectory(directory);
        } else {

        }
    }
}
