package logic;

public class Practica_de_exam {

    public Practica_de_exam() {
    }

    // 1. Números perfectos menores a 1000
    public void pract1() {
        int suma;
        for (int i = 1; i < 1000; i++) {
            suma = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    suma += j;
                }
            }
            if (suma == i) {
                System.out.println(i);
            }
        }
    }

    // 43. Indica cuántos dígitos tiene un número entero (considera negativos)
    public void pract43(int num) {
        int digitos = String.valueOf(Math.abs(num)).length();
        if (digitos == 1) {
            System.out.println("Tiene 1 dígito");
        } else if (digitos == 2) {
            System.out.println("Tiene 2 dígitos");
        } else if (digitos == 3) {
            System.out.println("Tiene 3 dígitos");
        } else {
            System.out.println("Tiene " + digitos + " dígitos");
        }
    }

    // 44. Convierte número decimal a romano (hasta 3000)
    public void pract44(int num) {
        if (num <= 0 || num > 3000) {
            System.out.println("Número fuera de rango");
            return;
        }
        String[] miles = {"", "M", "MM", "MMM"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String romano = miles[num / 1000] +
                        centenas[(num % 1000) / 100] +
                        decenas[(num % 100) / 10] +
                        unidades[num % 10];
        System.out.println(romano);
    }

    // 45. Calcula seno de x usando la serie de Taylor (17 términos)
    public void pract45(double x) {
        double resultado = 0;
        int signo = 1;
        for (int n = 1, k = 0; k < 17; n += 2, k++) {
            resultado += signo * Math.pow(x, n) / factorial(n);
            signo *= -1;
        }
        System.out.println("Sen(" + x + ") ≈ " + resultado);
    }

    private long factorial(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    // 46. Enésimo término de la serie de Fibonacci (A1=1, A2=2)
    public void pract46(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }

    // 47. Simulación básica de ascensor de 25 pisos
    public void pract47() {
        int piso = 1;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("Piso actual: " + piso);
            if (piso == 1) {
                System.out.println("Presione S para subir o X para salir");
            } else if (piso == 25) {
                System.out.println("Presione B para bajar o X para salir");
            } else {
                System.out.println("Presione S para subir, B para bajar o X para salir");
            }
            String op = sc.nextLine().toUpperCase();
            if (op.equals("X")) break;
            if (op.equals("S") && piso < 25) piso++;
            else if (op.equals("B") && piso > 1) piso--;
        }
    }

    // 48. Fecha del día siguiente
    public void pract48(int dia, int mes, int año) {
        java.time.LocalDate fecha = java.time.LocalDate.of(año, mes, dia);
        java.time.LocalDate siguiente = fecha.plusDays(1);
        System.out.println("Día siguiente: " + siguiente);
    }

    // 49. Calcula sueldo neto de empleados
    public void pract49(int numEmpleado, String nombre, double horas, double sueldoHora, boolean sindicato) {
        double bruto, neto, deducciones;
        if (horas <= 40) {
            bruto = horas * sueldoHora;
        } else {
            bruto = 40 * sueldoHora + (horas - 40) * sueldoHora * 1.5;
        }
        deducciones = bruto * 0.09 + (sindicato ? bruto * 0.03 : 0);
        neto = bruto - deducciones;
        System.out.println("Empleado: " + numEmpleado + ", Nombre: " + nombre);
        System.out.println("Salario bruto: " + bruto);
        System.out.println("Deducciones: " + deducciones);
        System.out.println("Salario neto: " + neto);
    }

    // 50. Jornal diario según turno y día
    public void pract50(int horasDiurnas, int horasNocturnas, boolean domingo) {
        int tarifaDiurna = domingo ? 700 : 500;
        int tarifaNocturna = domingo ? 830 : 800;
        int total = horasDiurnas * tarifaDiurna + horasNocturnas * tarifaNocturna;
        System.out.println("Jornal diario: " + total + " colones");
    }

    // 51. Calcula la hora dentro de un segundo
    public void pract51(int hh, int mm, int ss) {
        ss++;
        if (ss == 60) {
            ss = 0;
            mm++;
            if (mm == 60) {
                mm = 0;
                hh++;
                if (hh == 24) hh = 0;
            }
        }
        System.out.printf("Hora dentro de un segundo: %02d:%02d:%02d\n", hh, mm, ss);
    }

    // 52. Suma n Σ x=0 2X+1
    public void pract52(int n) {
        int suma = 0;
        for (int x = 0; x <= n; x++) {
            suma += 2 * x + 1;
        }
        System.out.println("Suma: " + suma);
    }

    // Programa que calcula: M Σ y=0 n Σ x=1 2 X + Y
    public void pract53(int m, int n) {
        int suma = 0;
        for (int y = 0; y <= m; y++) {
            for (int x = 1; x <= n; x++) {
                suma += 2 * x + y;
            }
        }
        System.out.println("Suma doble: " + suma);
    }
}
