package fileReaderWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// 5.- Añadir texto al final de un archivo existente
// Pide al usuario un texto y añádelo al final del archivo log.txt sin borrar lo anterior. (modo append)

public class e5 {
    public static void main(String[] args) {
        // instanciar Scanner para leer desde consola
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el texto para añadir al archivo log.txt:");
        String userInput = sc.nextLine();
        File logFile = new File("ficheros/log.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true))) {
            bw.write(userInput);
            bw.newLine();
            System.out.println("Texto añadido al archivo log.txt");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
