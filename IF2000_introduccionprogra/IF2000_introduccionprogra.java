package IF2000_introduccionprogra;

import domain.Person;

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

   } 
}
