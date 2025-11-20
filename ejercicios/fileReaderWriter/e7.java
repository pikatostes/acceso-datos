package fileReaderWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class e7 {
    public static void main(String[] args) {
        // 7.- Leer un archivo y mostrar solo las líneas que contengan una palabra
        // Pide una palabra al usuario y muestra por consola solo las líneas del archivo texto.txt que la contengan (sin distinción de mayúsculas).

        File file = new File("ficheros/mostrarPalabra.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce una palabra para buscar en el archivo: ");
            String keyword = sc.nextLine().toLowerCase();
            String line;
            System.out.println("Líneas que contienen la palabra '" + keyword + "':");
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(keyword)) {
                    System.out.println(line);
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
