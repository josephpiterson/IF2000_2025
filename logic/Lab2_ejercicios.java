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
        double p=(a+b+c)/2;
        double area=Math.sqrt(a*(p-a)*(p-b)*(p-c));
        System.out.print("El area del triangulo es:"+area);

    }
    public void ejercicio7(){
       /*Realizar un algoritmo que permita intercambiar entre si los valores de dos
        variables A y B.
        Ejemplo: Si A vale 5 y B vale 10, al resolver el problema A debe valer 10 y B valer 5.*/

        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese el valor de A:");
        int a=scanner.nextInt();
        System.out.print("Ingrese el valor de b:");
        int b=scanner.nextInt();
        int temp=a;
        a=b;
        b=temp;
        System.out.print("El nuevo valor de A es:"+a);
        System.out.print("El nuevo valor de B es:"+b);
    }
    public void ejercicio8(){
         //Elabore un diagrama de flujo que permita encontrar la ecuación de la recta y=mx+b donde M= (Y₀-Y₁)/(X₀-X₁) b=y-mx

         Scanner scanner=new Scanner(System.in);
         System.out.print("Ingrese el valor de x0:");
        double x0=scanner.nextDouble();
        System.out.print("Ingrese el valor de y0:");
        double y0=scanner.nextDouble();
        System.out.print("Ingrese el valor de x1:");
        double x1=scanner.nextDouble();
        System.out.print("Ingrese el valor de y1:");
        double y1=scanner.nextDouble();
        double m=(y0-y1)/(x0-x1);
        double b=y0-(m*x0);
        System.out.print("La ecuacion de la recta es:y="+m+"x+"+b);

    }
    public void ejercicio9(){
        //Realizar un algoritmo que lea un numero natural K e imprima la suma de todos los números naturales que sean menores a él. 
        Scanner scanner=new Scanner(System.in);
         System.out.print("Ingrese un numero:");
         int k=scanner.nextInt();
         int suma=0;
         for(int i=1;i<k;i++){
            suma+=i;

         }
         System.out.print("La suma de los numero son:"+k+"es:"+suma);
    }
    public void ejercicio10(){
        //Calcular la media (promedio) de una serie de números positivos. El promedio es la suma total de los números leídos entre la cantidad de números. 
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese la cantidade de numeros a promediar:");
        int n=scanner.nextInt();
        int suma=0;
        for(int i=1;i<=n; i++){
            System.out.print("Ingrese el numero"+i+":");
            int numero=scanner.nextInt();
            suma+=numero;
        }
        double promedio=(double)suma/n;
        System.out.print("El promedio de los numeros es:"+promedio);
    }
    public void ejercicio11(){
        /*Dados 10 números enteros, visualizar la suma de los números pares de la lista.
    ¿Cuántos números pares e impares existen?, ¿Cuál es la suma total de los números y
    cuanto es la suma de los impares y los pares por separado?*/

    Scanner scanner=new Scanner(System.in);
    int numeros_p=0;
    int numeros_i=0;
    int suma_p=0;
    int suma_i=0;
    for(int i=1;i<=10;i++){
        System.out.println("=====================================================");
        System.out.print("Ingrese el numero"+i+":");
        int numero=scanner.nextInt();
        if(numero%2==0){
            numeros_p++;
            suma_p+=numero;
        }
        else{
            numeros_i++;
            suma_i+=numero;
        }
        System.out.println("========================Pares=============================");
        System.out.println("cantidad de numeros pares:"+numeros_p); //cantidad de pares
        System.out.println("==========================Impares===========================");
        System.out.println("Cantidad de numeros impares:"+numeros_i); //cantidad de impares
        System.out.println("============================Suma de pares=========================");
        System.out.println("Suma de numeros pares:"+suma_p); //Suma de los pares
        System.out.println("============================Suma de impares=========================");
        System.out.println("Suma de numeros impares:"+suma_i);  //Suma de los impares
        System.out.println("================================Suma total de todos los numeros=====================");
        System.out.println("Suma total de los numeros:"+(suma_i+suma_p)); //suma total 
        System.out.println("=====================================================");


    }
    }
    public void ejercicio12(){
        /*Se desea calcular independientemente la suma de los números pares e impares
            comprendidos entre 1 y 200.   */
        int numeros_pares=0;
        int numeros_impares=0;
        for(int i=1; i<=200; i++){
            if(i%2==0){
                numeros_impares+=i;
            }else{
                numeros_impares+=i;
            }
        }
        System.out.println("La suma de los numeros pares entre 1 y 200 es:"+numeros_pares);
         System.out.println("=====================================================");
        System.out.println("La suma de los numeros impares entre 1 y 200 es:"+numeros_impares);
    }
    public void ejercicio13(){
        /*Calcular la suma de los cuadrados de los 100 primeros números naturales */
        int suma_cuadros=0;
        for(int i=1; i<=100; i++){
            suma_cuadros+=i*i;
        }
        System.out.print("La suma de los cuadrados de los 100 primeros numeros es:"+suma_cuadros);

    }
    public void ejercicio14(){
        /*Desarrollar el algoritmo necesario para calcular el factorial de un numero entero
            positivo N que responde a la formula;
            N! = 1 * 2 * 3 * 4 *…………………….. (n-1) * n
            Si n es 0 entonces 0!= 1
            Si n es 1 entonces 1!= 1 */

            Scanner scanner=new Scanner(System.in);
            System.out.print("Ingrese un numero:");
            int n=scanner.nextInt();
            int factorial=1;
            for(int i=1;i<=n;i++){
                factorial*=i;
            }
        System.out.print("El factorial de"+n+"es:"+factorial);

    }
    public void ejercicio15(){
        /*Calcular el valor máximo de una serie de 10 números.  */
        Scanner scanner=new Scanner(System.in);
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=10;i++){
            System.out.print("Ingrese el numero"+i+":");
            int numero=scanner.nextInt();
            if(numero>max){
                max=numero;
            }
        }
        System.out.print("El valor maximo de los numeros es:"+max);

    }

    }
    
