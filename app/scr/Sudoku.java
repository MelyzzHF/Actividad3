package app.scr;
/** * Autor: Melissa Yaretzi Hernández Flores
 * * Fecha: 04/09/2025 
 * * Descripción: La clase Sudoku sirve para mostrar el juego de sudoke
 * Al principio es interactuado, solo la primera fila para que el usuario sepa como funciona el programa, pero despues se resulve solo
 * y muestra el resultado
 * 
 * **/
import java.util.Scanner;

public class Sudoku {
    private static final int TAMAÑO = 9; // tamaño definicio 
    private static final int VACIO = 0; // sirve como un null
    private static int paso = 1; // empieza con 1 paso
    private static boolean modoManual = true; // se usa para saber cuando empieza el automatico, cuando termina el manual y empieza

    /**
     * Metodo que sirve para resolver el sudoku paso a paso, ya que al principio es manual para que interactue el usuario y comprenda
     * como funciona
     * @param tablero es un arreglo que sirve como tablero del sudoku
     * @param scanner permite la entrada de datos, en este caso el enter
     * @return retorna true si ya esta completo y si no false 
     */
    public static boolean resolverSudokuPasoAPaso(int[][] tablero, Scanner scanner) {
        for (int fila = 0; fila < TAMAÑO; fila++) {
            for (int col = 0; col < TAMAÑO; col++) {
                if (tablero[fila][col] == VACIO) {

                    // Cambiar a modo automático después de la fila 1 
                    if (fila >= 1 && modoManual) {
                        System.out.println("\n CAMBIO A MODO AUTOMÁTICO");
                        System.out.println("A partir de ahora se resolverá automáticamente con backtracking...");
                        System.out.print("Presiona Enter para continuar en modo automático y ver el sudoku resuelto...");
                        scanner.nextLine();
                        modoManual = false;
                    }

                    for (int num = 1; num <= 9; num++) {
                        if (esValido(tablero, fila, col, num)) {
                            tablero[fila][col] = num;

                            // Solo mostrar paso a paso en las primeras 1
                            if (modoManual && fila < 1) {
                                System.out.println("\n--- PASO " + paso++ + " ---");
                                System.out.println(
                                        "Colocando " + num + " en posición [" + (fila + 1) + "," + (col + 1) + "]");
                                imprimirTablero(tablero);
                                System.out.print("Presiona Enter para continuar...");
                                scanner.nextLine();
                            }

                            // Llamada recursiva
                            if (resolverSudokuPasoAPaso(tablero, scanner)) {
                                return true;
                            }

                            // Backtracking (Sirve para que empieza quitar los numeros si no van ahi, simula cuando pones un numero y lo quitas)
                            tablero[fila][col] = VACIO;

                            // Solo mostrar backtrack en las primera fila
                            if (modoManual && fila < 1) {
                                System.out.println("\n--- BACKTRACK ---");
                                System.out.println("Deshaciendo el " + num + " en posición [" + (fila + 1) + ","
                                        + (col + 1) + "]");
                                imprimirTablero(tablero);
                                System.out.print("Presiona Enter para continuar...");
                                scanner.nextLine();
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }
    /**
     * Sirve para ver si se puede colocar el numero en esa fila y columna
     * @param tablero es un arreglo que es el tablero de 9 
     * @param fila es donde se quiere color el numero de manera horizontal
     * @param coles donde se quiere color el numero de manera vertical
     * @param num numero que se quiere colocar
     * @return si es true se coloca el numero y false si esta ya en una fila o columna o el cuadro (1 de los 9)
     */
    public static boolean esValido(int[][] tablero, int fila, int col, int num) {
        // Verificar fila
        for (int i = 0; i < 9; i++) {
            if (tablero[fila][i] == num)
                return false;
        }

        // Verificar columna
        for (int i = 0; i < 9; i++) {
            if (tablero[i][col] == num)
                return false;
        }

        // Verificar el cuadrado 3x3 ya que no se debe repetir en el mismo cuadrante
        int startRow = fila - fila % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (tablero[i][j] == num)
                    return false;
            }
        }

        return true;
    }
    /**
     * Sirve para imprimir el tablero de la manera del sudoku 
     * @param tablero el arreglo que simula ser el tablero 
     */
    public static void imprimirTablero(int[][] tablero) {
        System.out.println("┌───────┬───────┬───────┐");
        for (int i = 0; i < 9; i++) {
            System.out.print("│ ");
            for (int j = 0; j < 9; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print("· ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
                if ((j + 1) % 3 == 0) {
                    System.out.print("│ ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i < 8) {
                if (i == 1) { // Como aqui es manual, decidi resaltarlo
                    System.out.println("├═══════╪═══════╪═══════┤ ");
                } else {
                    System.out.println("├───────┼───────┼───────┤");
                }
            }
        }
        System.out.println("└───────┴───────┴───────┘");
    }
    /**
     * Sirve para pedir el enter y mostrar el sudoku original y el resuelto
     * @param sc sirve para entrada de datos, en este caso el enter 
     */
    public static void mostrarSudoku(Scanner sc) {
        paso = 1;
        modoManual = true;

        int[][] sudoku = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        System.out.println(" TABLERO INICIAL:");
        imprimirTablero(sudoku);

        System.out.println("\n INSTRUCCIONES:");
        System.out.println(" Solo la primera fila se llenará paso a paso (presiona Enter)");
        System.out.println(" Después se resolverá automáticamente con backtracking");
        System.out.println("\n Presiona Enter para comenzar...");
        sc.nextLine();

        if (resolverSudokuPasoAPaso(sudoku, sc)) {
            System.out.println("\n -----SUDOKU RESUELTO -----");
            System.out.println(" TABLERO FINAL:");
            imprimirTablero(sudoku);
        } else {
            System.out.println("\n No se pudo resolver el Sudoku.");
        }
    }

}