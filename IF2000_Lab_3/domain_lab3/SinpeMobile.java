package IF2000_Lab_3.domain_lab3;

public class SinpeMobile {

    /**
     * Realiza transferencia entre cuentas.
     * Valida que ambas cuentas pertenezcan a algún banco (non-null bank), y que el origen tenga saldo suficiente.
     * Registra eventos en las bitácoras de ambos bancos cuando aplique.
     * @return true si la transferencia fue exitosa
     */
    public static boolean transfer(Account from, Account to, double amount) {
        if (from == null || to == null) throw new IllegalArgumentException("Cuentas no pueden ser nulas");
        if (amount <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
        if (from.getBank() == null || to.getBank() == null) {
            System.out.println("Ambas cuentas deben pertenecer a un banco");
            return false;
        }
        if (from.getBalance() < amount) {
            System.out.println("Saldo insuficiente en la cuenta origen");
            return false;
        }

        // realizar movimiento
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        // registrar en bitácoras
        from.getBank().getBitacora().addEvent("TRANSFER_OUT", from, amount);
        to.getBank().getBitacora().addEvent("TRANSFER_IN", to, amount);

        return true;
    }
}
