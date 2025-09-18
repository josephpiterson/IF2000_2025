package IF2000_Lab_3.domainlab3;

public class Simpemovil {
    private final TransactionLog log;

    public Simpemovil (TransactionLog log) {
        this.log = log;
    }

    /**
     * Transfer amount from source account to target account, validating bank membership and balances.
     * Returns true if transfer succeeded.
     */
    public boolean transfer(Bank sourceBank, String sourceAccountNumber, Bank targetBank, String targetAccountNumber, double amount) {
        Account src = sourceBank.getAccount(sourceAccountNumber);
        Account tgt = targetBank.getAccount(targetAccountNumber);

        if (src == null || tgt == null) return false;

        // Ensure accounts belong to the declared banks
        if (!src.getBankId().equals(sourceBank.getBankId())) return false;
        if (!tgt.getBankId().equals(targetBank.getBankId())) return false;

        // Validate sufficient funds
        if (src.getBalance() < amount) return false;

        boolean withdrawn = src.withdraw(amount);
        if (!withdrawn) return false;

        tgt.deposit(amount);

        log.record("transfer-out", src.getNumber(), src.getBankId(), amount);
        log.record("transfer-in", tgt.getNumber(), tgt.getBankId(), amount);

        return true;
    }
}
