package IF2000_Lab_3.domainlab3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionLog {
    public static class Entry {
        private final int idEvent;
        private final String event; // deposit or withdraw or transfer
        private final LocalDateTime timestamp;
        private final String accountNumber;
        private final String bankId;
        private final double amount;

        public Entry(int idEvent, String event, LocalDateTime timestamp, String accountNumber, String bankId, double amount) {
            this.idEvent = idEvent;
            this.event = event;
            this.timestamp = timestamp;
            this.accountNumber = accountNumber;
            this.bankId = bankId;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "idEvent=" + idEvent +
                    ", event='" + event + '\'' +
                    ", timestamp=" + timestamp +
                    ", accountNumber='" + accountNumber + '\'' +
                    ", bankId='" + bankId + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    private final List<Entry> entries = new ArrayList<>();
    private int nextId = 1;

    public Entry record(String event, String accountNumber, String bankId, double amount) {
        Entry e = new Entry(nextId++, event, LocalDateTime.now(), accountNumber, bankId, amount);
        entries.add(e);
        return e;
    }

    public List<Entry> getEntries() {
        return new ArrayList<>(entries);
    }
}
