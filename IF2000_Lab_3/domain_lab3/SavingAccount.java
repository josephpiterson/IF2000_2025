package IF2000_Lab_3.domain_lab3;

public class SavingAccount extends Account {

    private String initialDate;
    private int months;
    // porcentaje de interés expresado en decimal (ej. 0.05 para 5%)
    private double interest;

    public SavingAccount() {}

    public SavingAccount(String initialDate, int months, double interest, String accountNumber, double balance, Person client) {
        super(accountNumber, balance, client);
        this.initialDate = initialDate;
        this.months = months;
        this.interest = interest;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount);
    }

    @Override
    public void calcularIntereses() {
        // interés ganado = meses * saldo * porcentaje
        double gained = this.getMonths() * this.getBalance() * this.getInterest();
        this.setBalance(this.getBalance() + gained);
        // opcional: registrar en bitácora a través del banco
        if (this.getBank() != null) {
            this.getBank().getBitacora().addEvent("INTERES", this, gained);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [SavingAccount{initialDate=" + initialDate + ", months=" + months + ", interest=" + interest + "}]";
    }

}