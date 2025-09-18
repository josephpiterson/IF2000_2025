package IF2000_Lab_3.domainlab3;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final String bankId;
    private final String name;
    private final Map<String, Account> accounts = new HashMap<>();

    public Bank(String bankId, String name) {
        this.bankId = bankId;
        this.name = name;
    }

    public String getBankId() {
        return bankId;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
