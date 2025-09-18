package IF2000_Lab_3.domain_lab3;

import java.util.Objects;

public abstract class Account {
    // Atributos
    private String accountNumber;
    private double balance;
    private Person client;

    // Constructor
    public Account() {
       
    }
    public Account(String accountNumber, double balance, Person client) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
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
   


   public  abstract void deposit(double amount);
    public  abstract boolean withdraw(double amount);
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
