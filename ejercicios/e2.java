import java.io.File;

public class e2 {
    public static void main(String[] args) {
        File dir = new File("proyecto/src/assets");
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("El directorio fue creado con exito");
        } else {
            System.out.println("El direcotorio ya existe");
        }
    }
}
