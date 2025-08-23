package logic;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_semana2_PracticaEnClase {
    public void Quizz_piramide_astericos(int n){
        for (int i = 0; i <= n; i++) {
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
         System.out.println("==============================");

    }
    public void EjercioACuadrado_en_blanco(int n){
         for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (i == 1 || i == n)
            {
                System.out.print("* ");
            }
            else
            {
                if (j == 1 || j == n)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print("  "); 
                }
            }
        }
        System.out.println();
        }
        System.out.println("==============================");
     }
     public void ejercicioB(int n){
    for (int i = 1; i <= n; i++) {
            for(int j=1; j<=(n-i); j++){
                System.out.print("*");
            }
            for(int k=1; k<=1; k++){
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    System.out.println("==============================");
}
public void ejercicioc(int n){
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <= (n - i); j++) {
            System.out.print(" ");
        }
        for (int k = 1; k <= i; k++) {
            System.out.print("*");
        }
        System.out.println();
    }
    System.out.println("==============================");
}
public void conteo_Ascendente(int n){
    int[] numero=new int[n];
    Scanner sc =new Scanner(System.in);
    System.out.println("Ingrese 10 numeros enteros:");
    for(int i=0; i<10; i++){
        System.out.print("numero"+(i+1)+":");
        numero[i]=sc.nextInt();
    }
    Arrays.sort(numero);
    System.out.println("Los numeros ordenados de manera ascentente son:");
    for(int num:numero){
        System.out.print(num + " ");
    }
    System.out.println();
}  
public void conteo_descendente(int n){
    int[] numero=new int[n];
    Scanner sc=new Scanner(System.in);
    System.out.println("ingrese 100 numeros enteros:");
    for(int i=0; i<100; i++){
        System.out.print("numero"+(i+1)+":");
        numero[i]=sc.nextInt();
    }
    Arrays.sort(numero);
    System.out.println("Los numeros ordenados de manera descendente son:");
    for(int i=n-1; i>=0; i--){
        System.out.print(numero[i] + " ");
    }
    System.out.println();

}
public void mostrarTableroDamas() {
    char[][] tablero = new char[8][8];
    
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (i < 3 && (i + j) % 2 == 1) {
                tablero[i][j] = 'N'; // Fichas negras
            } else if (i > 4 && (i + j) % 2 == 1) {
                tablero[i][j] = 'R'; // Fichas rojas
            } else {
                tablero[i][j] = '-'; // Casilla vacía
            }
        }
    }
    System.out.println("Tablero inicial de damas:");
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            System.out.print(tablero[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println("==============================");
}
}