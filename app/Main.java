package app;
/** * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 04/09/2025 
 * * Descripción: La clase main sirve para mostrar el menu principal 
 * **/

import java.io.IOException;
import java.util.Scanner;
import app.scr.Fibonacci;
import app.scr.SubsetSum;
import app.scr.Sudoku;
/**
 * Main: Sirve para mostrarle al usuario el menu principal y manda a llamar los métedos dependiendo del numero dado
 * 1 Fibonacci
 * 2 Suma de subconjuntos
 * 3 Sudoku
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (true) { 
            try {
                System.out.println("\n-------- Menú Principal --------");
                System.out.println("1. Calcular Fibonacci ");
                System.out.println("2. Calcular Suma de Subconjuntos ");
                System.out.println("3. Problema de Sudoku ");
                System.out.println("0. Salir");
                System.out.print("Opción: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Inválido, Ingresa un número entero.");
                    sc.next();
                    continue;
                }

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        Fibonacci.mostrarFibonacci(sc);
                        break;

                    case 2:
                        SubsetSum.mostrarSubSet(sc);
                        break;

                    case 3:
                        Sudoku.mostrarSudoku(sc);
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        sc.close();
                        return; 

                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                sc.nextLine(); 
            }
        }
    }
}

