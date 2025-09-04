package app;

import java.io.IOException;
import java.util.Scanner;
import app.scr.Fibonacci;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int opcion = -1;

        try {
            System.out.println("\n-------- Menú Principal --------");
            System.out.println("1. Calcular Fibonacci ");
            System.out.println("2. Calcular Suma de Subconjuntos ");
            System.out.println("3. Problema de Sudoku ");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: 
                    Fibonacci.mostrarFibonacci(sc);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Inválido, Ingresa un número entero.");
        }

        sc.close();
    }
}
     
    

