package domainlab3;

import java.util.Objects;

public abstract class Account {
    // Atributos
    private String accountNumber;
    private double balance;
    private Person client;
    private Bank bank;

    // Constructor
    public Account() {
       
    }
    public Account(String accountNumber, double balance, Person client, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
        this.bank = bank;
    }
    // Getters y Setters
    public String getAccountNumber() {
        return accountNumber;
    }   
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Person getClient() {
        return client;
    }
    public void setClient(Person client) {
        this.client = client;
    }
    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }


   public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw amount must be positive");
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
  public abstract void calculateInterest();
  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" +
      "accountNumber='" + accountNumber + '\'' +
      ", balance=" + balance +
      ", Client=" + client.getName() +
      ", bank=" + (bank == null ? "None" : bank.getName()) +
      '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Account account = (Account) o;
    return Objects.equals(accountNumber, account.accountNumber);
  }
  @Override
  public int hashCode() {
    return Objects.hash(accountNumber);
  }
    
}
