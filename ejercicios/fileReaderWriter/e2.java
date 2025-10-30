package fileReaderWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class e2 {
    public static void main(String[] args) {
        File file = new File("texto.txt");
        Integer lineCount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            
            while (br.readLine() != null) {
                lineCount++;
            }

            System.out.println("El archivo tiene " + lineCount + " lineas.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
