package app.scr;

/** * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 04/09/2025 
 * * Descripción: La clase Fibonacci sirve para realizar las operaciones pero de manera recursiva
 * 
 * **/
import java.util.Scanner;

public class Fibonacci {

    /**
     * Función de Fibonacci de manera recursiva.
     * 
     * @param n la posición de número fibonacci a buscar
     * @return si el numero dado es 0, retorna un 0, si es 1 retorna 1 y si el otro
     *         número retorna el resultado esperado
     */
    public static long fibonacci(long n) {
        if (n == 0)
            return 0; // Caso base
        if (n == 1)
            return 1; // Caso base

        return fibonacci(n - 1) + fibonacci(n - 2); // Caso recursivo
    }

    /**
     * Función que sirve para pedirle el número y mostrar el resultado, si ingresa una letra o un numero negativo, vuelve a preguntar
     
     * 
     * @param sc sirve para aceptar el número dado
     */
    public static void mostrarFibonacci(Scanner sc) {
        int n = -1;

        while (true) {
            System.out.print("Calcular Fibonacci de: ");

            if (!sc.hasNextInt()) { 
                System.out.println("Inválido. Debes ingresar un número entero no negativo.");
                sc.next(); 
                continue; 
            }

            n = sc.nextInt();

            if (n < 0) {
                System.out.println("Inválido. Debe ser un entero no negativo.");
                continue;
            }

            break; 
        }

        System.out.println("\nFibonacci de " + n + " : " + fibonacci(n));
    }

}
