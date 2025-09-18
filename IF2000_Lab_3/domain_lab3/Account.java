package IF2000_Lab_3.domain_lab3;

/**
 * Clase abstracta Cuenta (Account) con atributos comunes y métodos básicos.
 */
public abstract class Account {
    private String accountNumber;
    private double balance;
    private Person client;
    // referencia opcional al banco que posee la cuenta (para bitácora)
    private Bank bank;

    public Account() {}

    public Account(String accountNumber, double balance, Person client) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalanceInternal(double balance) {
        this.balance = balance;
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

    // métodos de depósito y retiro que registran en la bitácora del banco si existe
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("El monto del depósito debe ser positivo.");
        this.balance += amount;
        if (bank != null) {
            bank.getBitacora().addEvent("DEPOSITO", this, amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("El monto del retiro debe ser positivo.");
        if (amount > this.balance) return false;
        this.balance -= amount;
        if (bank != null) {
            bank.getBitacora().addEvent("RETIRO", this, amount);
        }
        return true;
    }

    // obliga a subclases a implementar el cálculo de intereses
    public abstract void calcularIntereses();

    @Override
    public String toString() {
        return "Cuenta{accountNumber='" + accountNumber + "', balance=" + balance + 
                ", client=" + (client != null ? client.getName() : "null") + '}';
    }

}


