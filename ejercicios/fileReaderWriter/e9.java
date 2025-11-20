package fileReaderWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class e9 {
    public static void main(String[] args) {
        // 9.- Reemplazar palabras en un archivo
        // Crea un programa que lea texto.txt, reemplace todas las apariciones de una palabra (por ejemplo, “error” por “acierto”) y guarde el resultado en resultado.txt.

        File texto = new File("ficheros/texto.txt");
        File resultado = new File("ficheros/resultado.txt");
        String palabraBuscar = "error";
        System.out.println("Introduzca la palabra por la que desea reemplazar '" + palabraBuscar + "': ");
        Scanner scanner = new Scanner(System.in);
        String palabraReemplazar = scanner.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(texto))) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(resultado))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String replacedLine = line.replaceAll(palabraBuscar, palabraReemplazar);
                    pw.println(replacedLine);
                }
                System.out.println("Archivo resultado.txt generado correctamente, revise " + resultado.getAbsolutePath());
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer o escribir el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
