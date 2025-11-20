package fileReaderWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class e8 {
    public static void main(String[] args) {
        // 8.- Crear un informe con estadísticas de un texto
        // Lee texto.txt y genera un archivo informe.txt con:
        // - número de líneas,
        // - número total de caracteres,
        // - número total de palabras.

        File texto = new File("ficheros/texto.txt");
        File informe = new File("ficheros/informe.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(texto))) {
            int lineCount = 0;
            int charCount = 0;
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            try (PrintWriter pw = new PrintWriter(new FileWriter(informe))) {
                pw.println("Número de líneas: " + lineCount);
                pw.println("Número de caracteres: " + charCount);
                pw.println("Número de palabras: " + wordCount);

                System.out.println("Informe generado correctamente, revise " + informe.getAbsolutePath());
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
