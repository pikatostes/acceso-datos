package fileReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class e10 {
    public static void main(String[] args) {
        // 10.- Exportar un listado con formato tabular
        // Crea un programa que escriba un archivo empleados.txt con los siguientes datos tabulados:
        // Nombre - Puesto - Salario
        // Ana - Programadora - 2000
        // Luis - Administrador - 1800
        // Marta - Diseñadora - 1950
        
        Map<String, String[]> empleados = Map.of(
            "Ana", new String[]{"Programadora", "2000"},
            "Luis", new String[]{"Administrador", "1800"},
            "Marta", new String[]{"Diseñadora", "1950"}
        );

        String filePath = "ficheros/empleados.txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.printf("%-10s %-15s %-10s%n", "Nombre", "Puesto", "Salario");
            pw.println("----------------------------------------");
            for (Map.Entry<String, String[]> entry : empleados.entrySet()) {
                String nombre = entry.getKey();
                String puesto = entry.getValue()[0];
                String salario = entry.getValue()[1];
                pw.printf("%-10s %-15s %-10s%n", nombre, puesto, salario);
            }
            System.out.println("Archivo empleados.txt generado correctamente, revise " + filePath);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
