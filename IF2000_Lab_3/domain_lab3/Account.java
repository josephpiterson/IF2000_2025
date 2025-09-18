package IF2000_Lab_3.domain_lab3;

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
   


   public  void deposit(double amount){
    if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
    balance += amount;
    if (bank != null) {
      bank.getBitacora().addEvent("DEPOSIT", this, amount);
    }
   }
    public  boolean withdraw(double amount){
        if (amount <= 0) throw new IllegalArgumentException("Withdraw amount must be positive.");
    if (amount > balance) return false;
    balance -= amount;
    if (bank != null) {
      bank.getBitacora().addEvent("WITHDRAW", this, amount);
    }
    return true;
    }
  public abstract void calculateInterest();
  
  }
  
    
