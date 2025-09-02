package IF2000_introduccionprogra;
import logic.Ejercio_Semana2_PracticaEnClase;

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

      Ejercio_Semana2_PracticaEnClase ejercicio=new Ejercio_Semana2_PracticaEnClase();
      ejercicio.Quizz_piramide(5);
      ejercicio.ejercicioA(5);
   


   } 
}
