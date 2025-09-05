package app.scr;
/** * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 04/09/2025 
 * * Descripción: La clase SubsetSum sirve para encontrar una suma dentro de un conjunto 
 * 
 * **/
import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {

    /**
     * Método principal que busca la suma de los numeros dados
     * @param conjunto es un arreglo, el cual contiene todos los numeros 
     * @param objetivo es la suma que se debe encontrrar 
     * @param resultado almacena los elementos en el array 
     * @param indexRes indice actual en resultado para colocar el siguiente número seleccionado
     * @return true si existe un subconjunto que suma el objetivo, false en caso contrario
     */
    public static boolean subSetSum(int[] conjunto, int objetivo, int[] resultado, int indexRes) {
        return solve(conjunto, conjunto.length - 1, objetivo, resultado, indexRes);
    }
    /**
     * Método recursivo que resuelve el problema de suma de subconjuntos.
     * Utiliza la técnica de backtracking para explorar todas las posibilidades.
     * 
     * @param conjunto es un arreglo, el cual contiene todos los numeros 
     * @param indicees la suma que se debe encontrrar
     * @param objetivoalmacena los elementos en el array 
     * @param resultado indice actual en resultado para colocar el siguiente número seleccionado
     * @param indexRestrue si existe un subconjunto que suma el objetivo, false en caso contrario
     * @return
     */

    private static boolean solve(int[] conjunto, int indice, int objetivo, int[] resultado, int indexRes) {
        // Caso base pedido en canvas
        if (objetivo == 0) {
            return true;
        }
        //Caso base pedido en canvas
        if (indice < 0 || objetivo < 0) {
            return false;
        }

        resultado[indexRes] = conjunto[indice];
        if (solve(conjunto, indice - 1, objetivo - conjunto[indice], resultado, indexRes + 1)) {
            return true;
        }

        return solve(conjunto, indice - 1, objetivo, resultado, indexRes);
    }
    /**
     * Método para mostrar los resultados, pedir el numero de conjuntos, los numeros, la suma que quiere encontrar y si se encontro 
     * @param sc Sirve para la entrada de numeros del usuario
     */
    public static void mostrarSubSet(Scanner sc) {
        int tamaño = 0;
        int[] conjunto = null;

        while (true) {
            System.out.println("Cuántos números quieres en tu conjunto? ");
            if (sc.hasNextInt()) {
                tamaño = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println(" Debes ingresar un número entero. Intenta de nuevo.");
                sc.next(); 
                continue;
            }

            if (tamaño <= 0) {
                System.out.println(" El tamaño debe ser mayor que 0. Intenta de nuevo.");
                continue;
            }

            conjunto = new int[tamaño];
            System.out.println("Ingresa los números que deseas en tu conjunto (solo positivos):");

            for (int i = 0; i < tamaño; i++) {
                int num = -1;
                while (true) {
                    System.out.print("Número " + (i + 1) + ": ");
                    if (sc.hasNextInt()) {
                        num = sc.nextInt();
                        sc.nextLine();
                        if (num < 0) {
                            System.out.println(" No se permiten números negativos. Intenta de nuevo.");
                            continue;
                        }
                        break;
                    } else {
                        System.out.println("Debes ingresar un número entero. Intenta de nuevo.");
                        sc.nextLine();
                    }
                }
                conjunto[i] = num;
            }

            break;
        }

        System.out.println("Ingresa la suma que quieres encontrar: ");
        int objetivo = sc.nextInt();

        System.out.println("Conjunto: " + Arrays.toString(conjunto));
        System.out.println("Suma que deseas encontrar: " + objetivo);

        int[] resultado = new int[tamaño];
        if (subSetSum(conjunto, objetivo, resultado, 0)) {
            System.out.println("¿Se logró la suma? Sí");
            System.out.println();
        } else {
            System.out.println("¿Se logró la suma? No");
        }
    }
}