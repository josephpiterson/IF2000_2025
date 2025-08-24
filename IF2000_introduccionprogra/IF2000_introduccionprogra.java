package IF2000_introduccionprogra;

import domain.Person;
import logic.Ejercicio_semana2_PracticaEnClase;
import logic.lab1_ejercicios;

public class IF2000_introduccionprogra {
   public static void main(String[] args) {
    String name="Joseph";
    int age=40;
    /*tipos de datos numericos
     * int,long,short,float,double,numeric,money,decimal
     * 
     * 
     mandejo de fechas
     date

     cadenas de caracteres:
     string

     odjetos
     odject

     data structures
     array or vectors: int[]x;
                       int[][]y;
    
    true/false
    boolean
    */
    System.out.println("Hola mundo");
    System.out.println("Nombre:"+name);
    System.out.println("Edad:"+age);
     Person person = new Person("John", "Doe", "123456789", "555-1234", 30);
    System.out.println(person.toString());

      Ejercicio_semana2_PracticaEnClase ejercicio = new Ejercicio_semana2_PracticaEnClase();
      /*ejercicio.Quizz_piramide_astericos(5);
      ejercicio.EjercioACuadrado_en_blanco(5);
      ejercicio.ejercicioB(10);
      ejercicio.ejercicioc(10);
      ejercicio.conteo_Ascendente(10);
      ejercicio.conteo_descendente(10);
      ejercicio.mostrarTableroDamas();*/
      lab1_ejercicios lab1 = new lab1_ejercicios();
      //lab1.Ejercio_1();
      //lab1.Ejecicio_2();
      //lab1.Ejercicio_3();
      //lab1.Ejercicio_4();
      //lab1.Ejercicio_5();
      //lab1.Ejercicio_6();
      //lab1.Ejercicio_7();
      //lab1.Ejercicio_8();
      //lab1.Ejercicio_9();
      //lab1.Ejercicio_10();
      //lab1.Ejercicio_11();
      lab1.Ejercicio_12();

   } 
}
