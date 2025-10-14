import java.io.File;

public class e4 {
    public static void main(String[] args) {
        // create notas.txt file with createNewFile()
        try {
            File file = new File("proyecto/src/assets/notas.txt");
            if (file.createNewFile()) {
                System.out.println("El archivo fue creado con exito");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }
}
