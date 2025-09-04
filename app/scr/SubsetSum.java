package app.scr;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {

    public static boolean subSetSum( int [] conjunto, int objetivo ){
        return solve(conjunto, conjunto.length - 1, objetivo);

    }

    public static boolean solve(int [] conjunto , int indice, int objetivo ){
        if (objetivo == 0){
            return true;   
        }

        if (indice < 0 || objetivo < 0 ){
            return false;
        }
        return solve(conjunto, indice -1 , objetivo) || solve(conjunto, indice -1, objetivo - conjunto[ indice]);
    }

    public static void mostrarSubSet(Scanner sc){

        System.out.println("Cuántos números quieres en tu conjunto? ");
        int tamaño = sc.nextInt();

        int [] conjunto = new int[tamaño];

        System.out.println("Ingresa los números que deseas en tu conjunto: " );
        
        for (int i = 0; i < tamaño; i ++){
            System.out.print("Número " + (i+1) + ": ");
            conjunto[i] = sc.nextInt();

        }

        System.out.println("Ingresa la suma que quieres encontrar: ");
        int objetivo = sc.nextInt();
         
        System.out.println("Conjunto: " + Arrays.toString(conjunto));
        System.out.println("Suma que deseas encontrar: " + objetivo);

        System.out.println("¿Se entro la suma en el conjunto? " + subSetSum(conjunto, objetivo));
        

    }
    
}
