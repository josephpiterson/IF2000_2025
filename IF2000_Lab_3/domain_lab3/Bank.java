package IF2000_Lab_3.domain_lab3;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts = new ArrayList<>();
    private Bitacora bitacora = new Bitacora();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account a) {
        a.setBank(this);
        accounts.add(a);
    }

    public Account findByNumber(String accountNumber) {
        for (Account a : accounts) if (a.getAccountNumber().equals(accountNumber)) return a;
        return null;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
