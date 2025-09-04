package app.scr;

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

    public static void mostrarFibonacci(Scanner sc) {
        System.out.println("Calcular Fibonacci de: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Inválido. Debe ser un entero no negativo.");
            return;
        }
        System.out.println("\nFibonacci de " + n + " : " + fibonacci(n));

    }

}
