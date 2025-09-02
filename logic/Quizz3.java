package logic;

public class Quizz3 {
    public Quizz3() {
    }
    public void EjercioACuadrado_en_blanco(int n){
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == 1 || i == n || j == 1 || j == n) {
                System.out.print("* ");
            } else if (i == (n + 1) / 2 && j == (n + 1) / 2) {
             
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
    }
    System.out.println("==============================");
}
}
