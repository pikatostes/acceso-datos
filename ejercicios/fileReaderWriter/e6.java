package fileReaderWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class e6 {
    public static void main(String[] args) {
        // 6.- Escribir un archivo con formato usando PrintWriter
        // Crea un archivo datos.txt y escribe varias líneas con el siguiente formato:
        // Nombre: Ana - Edad: 22
        // Nombre: Luis - Edad: 25
        // Nombre: Marta - Edad: 20

        Scanner sc = new Scanner(System.in);
        File dataFile = new File("ficheros/datos.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(dataFile))) {
            String[] names = {"Ana", "Luis", "Marta"};
            int[] ages = {22, 25, 20};

            for (int i = 0; i < names.length; i++) {
                pw.printf("Nombre: %s - Edad: %d%n", names[i], ages[i]);
            }
            System.out.println("Archivo datos.txt creado con formato correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
