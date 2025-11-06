package fileReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class e3 {
    public static void main(String[] args) {
        File origin = new File("ficheros/origen.txt");
        File copy = new File("ficheros/copia.txt");
        // copiar el archivo origen.txt a copia.txt

        if (!origin.exists()) {
            System.out.println("El archivo origen no existe.");
            return;
        }

        if (!copy.exists()) {
            System.out.println("El archivo copia no existe. Creando uno nuevo...");
            
            try {
                copy.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo copia: " + e.getMessage());
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(origin));
             BufferedWriter bw = new BufferedWriter(new FileWriter(copy))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Archivo copiado correctamente.");
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
