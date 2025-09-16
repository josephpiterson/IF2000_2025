package domain;

public class CheckingAccount extends Account {
    private double interestRate;

    public CheckingAccount(String number, double balance, Client client, Bank bank, double interestRate) {
        super(number, balance, client, bank);
        this.interestRate = interestRate;
    }

    @Override
    public void calculateInterest() {
        double earnedInterest = (balance * interestRate) / 12;
        balance += earnedInterest;
    }

    public double getInterestRate() { return interestRate; }
}