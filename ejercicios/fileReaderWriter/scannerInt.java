package fileReaderWriter;

import java.util.Scanner;

public class scannerInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu edad junto con tu nombre: ");
        int age = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine(); // Captura el resto de la línea después del entero
        System.out.println("Tu nombre es " + name + " y tienes " + age + " años.");
        sc.close();
    }
}
