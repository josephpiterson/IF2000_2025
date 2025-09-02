package logic;

public class Ejercio_Semana2_PracticaEnClase {
    
    public Ejercio_Semana2_PracticaEnClase(){

    }
    public void Quizz_piramide(int n){
        for (int i = 0; i <= n; i++) {
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
    
    public void ejercicioA(int n)
{
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
}
public void ejercicioB(int n){
    for (int i = 0; i <= n; i++) {
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
}
}
