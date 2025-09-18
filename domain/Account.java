package domain;


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
    //metodos
    public  abstract void deposit( double amount);
    public   abstract  void withdraw(  double amount);
    public abstract double interestcalculation();
    @Override
    public String toString() {
       String result="\nBank Account INFORMATION:"
        + "\nAccount Number: " + this.getAccountNumber()
        + "\nBalance: " + this.getBalance()
        + "\nAccount Owner: " + this.getClient().toString();
        return result;
        
    }
    
}
