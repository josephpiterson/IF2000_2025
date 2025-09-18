package IF2000_Lab_3.domainlab3;

public class CheckingAccount {
    private double interestRate; // annual rate in decimal

    public CheckingAccount(String number, double balance, Client accountHolder, String bankId, double interestRate) {
        super(number, balance, accountHolder, bankId);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public double calculateInterest() {
        double interest = (this.balance * interestRate) / 12.0;
        this.balance += interest;
        return interest;
    }
}
