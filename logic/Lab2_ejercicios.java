package logic;

import java.util.Scanner;

public class Lab2_ejercicios {

    public Lab2_ejercicios(){}
    public void ejercicio1(int n){
        // Realizar la suma de todos los números pares entre 2 y 1000.
        n=0;
        for(int i=2;i<=1000;i+=2){
            n+=i;
        }
        System.out.print("La suma de los numeros pares entre 2 y 1000 es:"+n);
    }
    public void ejericio2(){
        //Realizar un algoritmo que permita convertir temperaturas dadas en grados Celsiusa temperaturas en grados Fahrenheit. F=9/5 (C + 32)
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese la temperatura en grados celsius:");
        double celsius=scanner.nextDouble();
        double Fahrenheit=(9.0/5.0)*celsius+32;
        System.out.print("La temperatura en grados Fahrenheit es:"+Fahrenheit);
        scanner.close();

    }
    public void ejercicio3(){
        //Programa que lee un numero entero X y otro número entero Ny, calcula la enésima potencia de X. X^n
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese el numero x:");
        int x=scanner.nextInt();
        System.out.print("Ingrese el numero n:");
        int n=scanner.nextInt();
        int resultado=1;
        for(int i=1;i<=n;i++){
            resultado*=x;
        }
        System.out.print("La potencia de "+x+"elevado a la "+n+"es:"+resultado);

    }
    public void ejercicio4(){
        //Elabore un DF que reciba del teclado un número e imprima el mes del año al cual corresponde ese número
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese un numero del 1 al 12:");
        int mes=scanner.nextInt();
        switch(mes){
            case 1:
                System.out.print("Enero");
                break;
            case 2:
                System.out.print("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.print("Abril");
                break;
            case 5:
                System.out.print("Mayo");
                break;
            case 6:
                System.out.print("Junio");
                break;
            case 7:
                System.out.print("Julio");
                break;
            case 8:
                System.out.print("Agosto");
                break;
            case 9:
                System.out.print("Septiembre");
                break;
            case 10:
                System.out.print("Octubre");
                break;
            case 11:
                System.out.print("Noviembre");
                break;
            case 12:
                System.out.print("Diciembre");
                break;
            case 13:
                System.out.print("numero ingresado es invalido");
                break;
            
        }
    }
    public void ejercicio5(){
        //. Calcular e imprimir el resultado de la evaluación de la siguiente funcion:
                            //F(x)= {x+5, ∀ x > 0
                                // {X², ∀ x < 0
                                        //{1, x=0
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese un numero:");
        int x=scanner.nextInt();
        if(x>0){
            System.out.print("El resultado de la funcion es:"+(x+5));
        }else if(x<0){
            System.out.print("El resultado de la funcion es:"+(x*x));
        }
        }
    public void ejercicio6(){
        //Diseñar un algoritmo que calcule el área de un triángulo en funcion de las longitudes de sus lados.
             //Área= raíz (p (p-a) (p-b) (p-c), p=(a + b + c)/2 donde p es el perímetro y a, b, c es el
            //valor de lo que mide cada lado.
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese la longitud del lado a:");
        double a=scanner.nextDouble();
        System.out.print("Ingrese la longitud del lado b:");
        double b=scanner.nextDouble();
        System.out.print("Ingrese la longitud del lado c:");
        double c=scanner.nextDouble();
        double s=(a+b+c)/2;
        double area=Math.sqrt(a*(s-a)*(s-b)*(s-c));
        System.out.print("El area del triangulo es:"+area);
    }
    public void ejercicio7(){
       /*Realizar un algoritmo que permita intercambiar entre si los valores de dos
        variables A y B.
        Ejemplo: Si A vale 5 y B vale 10, al resolver el problema A debe valer 10 y B valer 5.*/

        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese el valor de A:");
        int a=scanner.nextInt();
        System.out.println("Ingrese el valor de b:");
        int b=scanner.nextInt();
        int temp=a;
        a=b;
        b=temp;
        System.out.print("El nuevo valor de A es:"+a);
        System.out.print("El nuevo valor de B es:"+b);
        
        
    }

    }
    
