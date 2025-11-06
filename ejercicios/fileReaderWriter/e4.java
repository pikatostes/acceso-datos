package fileReaderWriter;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// 4.- Escribir frases desde consola en un archivo
// Pide al usuario que introduzca frases por teclado y escríbelas en salida.txt.

public class e4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce frases para escribir en el archivo (escribe 'FIN' para terminar):");
        File outputFile = new File("ficheros/salida.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while (true) {
                line = sc.nextLine();
                if (line.equalsIgnoreCase("FIN")) {
                    break;
                }
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Frases escritas en " + outputFile.getName());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
