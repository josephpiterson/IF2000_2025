package logic;

public class Lab3_ejercicios {


    public Lab3_ejercicios(){}

    public void  ejercicio_1(){
            /*Dada una fecha en formato día/mes/año determinar el número de días y el nombre del mes de
        dicha fecha, y sacar por pantalla la fecha convertida al formato de día “de” mes “del” año.  */
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Ingrese una fecha en formato diá/mes/año:");
            String fecha =scanner.nextLine();
            String[] partes= fecha.split(fecha="/");
            int dia=Integer.parseInt(partes[0]);
            int mes=Integer.parseInt(partes[1]);
            int año=Integer.parseInt(partes[2]);
            String nombremes="";
            int diasdelmes=0;
            switch(mes){
                case 1:
                    nombremes="Enero";
                    diasdelmes=31;
                    break;
                case 2:
                    nombremes="Febrero";
                    if((año%4==0 && año%100!=0) || (año%400==0)){
                        diasdelmes=29;
                    }else{
                        diasdelmes=28;
                    }
                    break;
                case 3:
                    nombremes="Marzo";
                    diasdelmes=31;
                    break;
                case 4:
                    nombremes="Abril";
                    diasdelmes=30;
                    break;
                case 5:
                    nombremes="Mayo";
                    diasdelmes=31;
                    break;
                case 6:
                    nombremes="Junio";
                    diasdelmes=30;
                    break;
                case 7:
                    nombremes="Julio";
                    diasdelmes=31;
                    break;
                case 8:
                    nombremes="Agosto";
                    diasdelmes=31;
                    break;
                case 9:
                    nombremes="Septiembre";
                    diasdelmes=30;
                    break;
                case 10:
                    nombremes="Octubre";
                    diasdelmes=31;
                    break;
                case 11:
                    nombremes="Noviembre";
                    diasdelmes=30;
                    break;
                case 12:
                    nombremes="Diciembre";
                    diasdelmes=31;
                    break;
                default:
                    System.out.println("Mes inválido");
                    return;
            }
            System.out.println("La fecha es: "+dia+" de "+nombremes+" del "+año);
            System.out.println("El mes tiene "+diasdelmes+" días.");
    }
        public void ejercicio_2(){
            /*Programa que calcula el producto de dos números enteros positivos mediante sumas
                sucesivas. */
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Ingrese el primer numero:");
            int num1=scanner.nextInt();
            System.err.print("Ingrese el segundo numero:");
            int num2=scanner.nextInt();
            int producto=0;
            for(int i=0; i<num2; i++){
                producto+=num1;

            }
            System.out.println("El producto es: "+producto);

        }
        public void ejercicio_3(){
            /*Obtener un algoritmo que permita calcular las tablas de multiplicación del 1 al 12. */
            for(int i=1; i<=12; i++){
                System.out.println("Tabla del "+i);
                for(int j=1; j<=12; j++){
                    System.out.println(i+" x "+j+" = "+(i*j));
                }
                System.out.println("---------------------");
            }
        }
        public void ejercicio_4(){
            /*. Programa que obtiene el cociente y el resto de dos números enteros positivos mediante restas
            sucesivas. (Nota: La división entre 0 no está definida). */
            java.util.Scanner scanner= new java.util.Scanner(System.in);
            System.out.print("Ingrese el dividendo:");
            int dividendo=scanner.nextInt();
            System.err.print("Ingrese el divisor:");
            int divisor=scanner.nextInt();
            if(divisor==0){
                System.err.print("Imposible dividir entre 0");
                return;

            }
            int cociente=0;
            int resto=dividendo;
            while(resto>=divisor){
                resto-=divisor;
                cociente++;
            }
            System.out.println("El cociente es: "+cociente);
            System.out.println("El resto es: "+resto);
        }
        public void ejercicio_5(){
            /* Se tienen las calificaciones de los alumnos del curso IF – 1300. Diseñar un DF que calcule la
            nota final de todos los estudiantes. Esto de acuerdo a como se les va a calificar en este curso. */

            java.util.Scanner scanner=new java.util.Scanner(System.in);
            System.out.print("Ingrese la cantidad de estudiantes:");
            int cantidad=scanner.nextInt();
            for(int i=1; i<=cantidad; i++){
                System.out.print("Ingrese la nota del estudainte"+i+":");
                double nota=scanner.nextDouble();
                if(nota>=0 && nota<6){
                    System.err.println("El estudiante"+i+"ha reprobado con una nota de:"+nota);
                }else{
                    System.out.println("El estudiante"+i+"ha aprobado con una nota de:"+nota);
                }

            }
        }
        public void ejercicio_6(){
            /*Calcular la media de un conjunto de notas de alumnos. Pondremos un valor centinela de -99
            que detecta el fin de los estudiantes.  */
            /*Calculate the average of a set of student grades. Use a sentinel value of -99 to detect the end of input.*/
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double sum = 0;
        int count = 0;
        while (true) {
        System.out.print("Enter the student's grade (-99 to finish): ");
        double grade = scanner.nextDouble();
        if (grade == -99) {
            break;
        } else if (grade < 0 || grade > 100) {
            System.err.println("Invalid grade, please enter a value between 0 and 100.");
        } else {
            sum += grade;
            count++;
        }
        }
        if (count > 0) {
        double average = sum / count;
        System.out.println("The average grade is: " + average);
        } else {
        System.out.println("No valid grades entered.");
        }
        }
        public void ejercicio_7(){
            /*Leer por teclado un número que representa una cantidad de números que a su vez se leerán
            también por teclado. Calcular la suma de todos esos números.  */
            java.util.Scanner scanner=new java.util.Scanner(System.in);
            System.err.print("Ingrese la cantidad de numeros a sumar:");
            int cantidad=scanner.nextInt();
            int suma=0;
            for(int i=1; i<=cantidad; i++){
                System.err.print("Ingrese el numero"+i+":");
                int numero=scanner.nextInt();
                suma+=numero;
            }
            System.out.println("La suma de los numeros es: "+suma);
        }
        public void ejercicio_8(){
            /*Dados tres números, deducir cuál es el central.  */
            java.util.Scanner scanner=new java.util.Scanner(System.in);
            System.out.print("Ingrese el primer numero:");
            int num1=scanner.nextInt();
            System.out.print("Ingrese el segundo numero:");
            int num2=scanner.nextInt();
            System.out.print("Ingrese el tercer numero:");
            int num3=scanner.nextInt();
            int central=0;
            if((num1>=num2 && num1<=num3) || (num1<=num2 && num1>=num3)){
                central=num1;
        }
            else if((num2>=num1 && num2<=num3) || (num2<=num1 && num2>=num3)){
                central=num2;
            }else{
                central=num3;
            }
            System.out.println("El numero central es: "+central);

    }
    public void ejercicio(){
        /*Hacer un DF que permita introducir una palabra por teclado e imprima la primera vocal que
        tiene dicha palabra. */
        java.util.Scanner scanner=new java.util.Scanner(System.in);
        System.out.print("Ingrese una palabra:");
        String palabra=scanner.nextLine().toLowerCase();
        char primeraVocal='\0';
        for(int i=0; i<palabra.length(); i++){
            char letra=palabra.charAt(i);
            if(letra=='a' || letra=='e' || letra=='i' || letra=='o' || letra=='u'){
                primeraVocal=letra;
                break;
            }

        }
        if(primeraVocal!='\0'){
            System.out.println("La primera vocal es: "+primeraVocal);
        }else{
            System.out.println("No se encontraron vocales en la palabra.");
        }

    }
    public void ejercicio_10(){
        /*Hacer un DF que permita introducir por teclado e imprima la cantidad de consonantes que
tiene dicha palabra0 */
        java.util.Scanner scanner=new java.util.Scanner(System.in);
        System.out.print("Ingrese una palabra:");
        String palabra=scanner.nextLine().toLowerCase();
        int contadorConsonantes=0;
        for(int i=0; i<palabra.length(); i++){
            char letra=palabra.charAt(i);
            if((letra>='a' && letra<='z') && !(letra=='a' || letra=='e' || letra=='i' || letra=='o' || letra=='u')){
                contadorConsonantes++;
            }
        }
        System.out.println("La cantidad de consonantes en la palabra es: "+contadorConsonantes);
    }
    public void ejercicio_11(){
        /*. Diagrama de flujo que simplifique una fracción, dividiendo numerador y denominador por su
        máximo común divisor.  */
        java.util.Scanner scanner=new java.util.Scanner(System.in);
        System.out.print("Ingrese el numerador:");
        int numerador=scanner.nextInt();
        System.out.print("Ingrese el denominador:");
        int denominador=scanner.nextInt();
        int a=numerador;
        int b=denominador;
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        int mcd=a;
        int numeradorSimplificado=numerador/mcd;
        int denominadorSimplificado=denominador/mcd;
        System.out.println("La fracción simplificada es: "+numeradorSimplificado+"/"+denominadorSimplificado);

    }
    public void ejercicio_12(){
        /* Escriba un DF que le permita averiguar si un año leído del teclado es o no bisiesto.
    Son bisiestos todos los años divisibles por 4, excluyendo los que sean divisibles por 100,
    pero no los que sean divisibles por 400.
    Dicho de otro modo, los años divisibles por 4 son bisiestos, pero cada 400 años se deben
    eliminar 3 bisiestos. Para ello, no son bisiestos los que se dividen por 100, menos los que
    se dividen por 400, que sí son bisiestos.  */
        java.util.Scanner scanner=new java.util.Scanner(System.in);
        System.out.print("Ingrese un año:");
        int año=scanner.nextInt();
        if((año%4==0 && año%100!=0) || (año%400==0)){
            System.out.println("El año "+año+" es bisiesto.");
        }else{
            System.out.println("El año "+año+" no es bisiesto.");
        }
    }
    public void ejercicio_13(){
        /*Una estación climática proporciona un par de temperaturas diarias (máxima y mínima) (no es
    posible que alguna o ambas temperaturas sea 9 grados, ni tampoco que la temperatura mínima
    sea mayor que la máxima).
    Se pide determinar el número de días cuyas temperaturas se han proporcionado, cuál es la
    temperatura máxima y mínima que se ha proporcionado, el número de errores –
    temperaturas de 9 grados – y el porcentaje de días en los cuales se han proporcionado
    errores. El programa termina cuando se le digitan temperatura máxima y mínima igual a
    -100.*/
        java.util.Scanner scanner=new java.util.Scanner(System.in);
        int contadorDias=0;
        int temperaturaMaxima=Integer.MIN_VALUE;
        int temperaturaMinima=Integer.MAX_VALUE;
        int contadorErrores=0;
        while(true){
            System.out.print("Ingrese la temperatura máxima del día (o -100 para terminar):");
            int tempMax=scanner.nextInt();
            System.out.print("Ingrese la temperatura mínima del día (o -100 para terminar):");
            int tempMin=scanner.nextInt();
            if(tempMax==-100 && tempMin==-100){
                break;
            }
            if(tempMax==9 || tempMin==9 || tempMin>tempMax){
                contadorErrores++;
                System.err.println("Error en las temperaturas ingresadas.");
                continue;
            }
            contadorDias++;
            if(tempMax>temperaturaMaxima){
                temperaturaMaxima=tempMax;
            }
            if(tempMin<temperaturaMinima){
                temperaturaMinima=tempMin;
            }
        }
        double porcentajeErrores=0;
        if(contadorDias+contadorErrores>0){
            porcentajeErrores=(double)contadorErrores/(contadorDias+contadorErrores)*100;
        }
        System.out.println("Número de días con temperaturas proporcionadas: "+contadorDias);
        if(contadorDias>0){
            System.out.println("Temperatura máxima registrada: "+temperaturaMaxima);
            System.out.println("Temperatura mínima registrada: "+temperaturaMinima);
        }else{
            System.out.println("No se registraron temperaturas válidas.");
        }
        System.out.println("Número de errores (temperaturas de 9 grados o inválidas): "+contadorErrores);
        System.out.println("Porcentaje de días con errores: "+porcentajeErrores+"%");
    }
    public void ejercicio_14(){
        /* Programa que obtiene e imprime la lista de los divisores de un numero N entero positivo.  */
        java.util.Scanner scanner=new java.util.Scanner(System.in);
        System.out.print("Ingrese un número entero positivo:");
        int N=scanner.nextInt();
        if(N<=0){
            System.err.println("El número debe ser positivo.");
            return;
        }
        System.out.println("Los divisores de "+N+" son:");
        for(int i=1; i<=N; i++){
            if(N/i==0){
                System.out.println(i);
            }

    }
}

