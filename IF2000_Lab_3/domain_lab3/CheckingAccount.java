package IF2000_Lab_3.domain_lab3;

public class CheckingAccount extends Account {
    // porcentaje de interés anual en decimal (ej. 0.03 = 3%)
    private double interest;

    public CheckingAccount() {}

    public CheckingAccount(String accountNumber, double balance, Person client, double interest) {
        super(accountNumber, balance, client);
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public void calcularIntereses() {
        // interés ganado = saldo * porcentaje / 12
        double gained = this.getBalance() * this.interest / 12.0;
        this.setBalance(this.getBalance() + gained);
        if (this.getBank() != null) {
            this.getBank().getBitacora().addEvent("INTERES", this, gained);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [CheckingAccount{interest=" + interest + "}]";
    }
}
