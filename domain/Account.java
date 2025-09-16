package domain;

public abstract class Account {
    // Atributos
    private String accountNumber;
    private double balance;
    private Person client;
    protected  Bank bank;

    // Constructor
    public Account() {
       
    }
    public Account(String accountNumber, double balance, Person client, Bank bank) {
         this.accountNumber = accountNumber;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
        this.bank=bank;
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
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public Bank getBank() {
        return bank;
    }
    

    //metodos
    public void deposit( double amount){
        if(amount>0){
            balance+=amount;
        }
    }
    public  void withdraw(  double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
        }
    }
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
