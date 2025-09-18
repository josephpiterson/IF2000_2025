package IF2000_Lab_3;

import IF2000_Lab_3.domain_lab3.*;

public class IF2000_introduccionprogra {

    public static void main(String[] args) {
        // crear personas
        Person p1 = new Person("Ana", "Perez", "1-1234-5678", "8888-0000", 30);
        Person p2 = new Person("Luis", "Gomez", "2-8765-4321", "8999-1111", 40);

        // crear bancos
        Bank bankA = new Bank("Banco A");
        Bank bankB = new Bank("Banco B");

        // crear cuentas
        SavingAccount sa = new SavingAccount("2025-09-01", 6, 0.01, "A-100", 1000.0, p1);
        CheckingAccount ca = new CheckingAccount("C-200", 500.0, p2, 0.06);

        // agregar cuentas a bancos
        bankA.addAccount(sa);
        bankB.addAccount(ca);

        // operaciones
        sa.deposit(200);
        ca.deposit(100);

        boolean ok = ca.withdraw(50);
        System.out.println("Retiro en cuenta corriente OK? " + ok);

        // calcular intereses
        sa.calcularIntereses();
        ca.calcularIntereses();

        System.out.println("Saldo ahorro: " + sa.getBalance());
        System.out.println("Saldo corriente: " + ca.getBalance());

        // transferencia SINPE entre bancos
        boolean t = SinpeMobile.transfer(sa, ca, 300);
        System.out.println("Transferencia de SA a CA exitosa? " + t);

        System.out.println("--- Bitacora Banco A ---");
        System.out.println(bankA.getBitacora());

        System.out.println("--- Bitacora Banco B ---");
        System.out.println(bankB.getBitacora());
    }
}