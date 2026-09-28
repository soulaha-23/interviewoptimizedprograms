import java.util.*;
import java.util.stream.*;

class Transaction {

    private String account;
    private String type;
    private String status;
    private Double amount;

    public Transaction(String account, String type,
                        String status, Double amount) {
        this.account = account;
        this.type = type;
        this.status = status;
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public Double getAmount() {
        return amount;
    }
}

public class TransactionSummary {

    public static Map<String, Double> summarize(
            List<Transaction> transactions) {

        return transactions.stream()

                .filter(Objects::nonNull)

                .filter(t -> t.getAccount() != null)

                .filter(t -> t.getAmount() != null)

                .filter(t -> "SUCCESS".equals(t.getStatus()))

                .collect(Collectors.groupingBy(
                        Transaction::getAccount,
                        LinkedHashMap::new,
                        Collectors.summingDouble(
                                t -> "CREDIT".equals(t.getType())
                                        ? t.getAmount()
                                        : -t.getAmount()
                        )
                ));
    }

    public static Map<String, Map<String, Double>> summarizeByType(
            List<Transaction> transactions) {

        return transactions.stream()
                .filter(Objects::nonNull)
                .filter(t -> t.getAccount() != null)
                .filter(t -> t.getAmount() != null)
                .filter(t -> "SUCCESS".equals(t.getStatus()))
                .collect(Collectors.groupingBy(
                        Transaction::getAccount,
                        LinkedHashMap::new,
                        Collectors.groupingBy(
                                Transaction::getType,
                                LinkedHashMap::new,
                                Collectors.summingDouble(
                                        Transaction::getAmount
                                )
                        )
                ));
    }

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction("A1", "CREDIT", "SUCCESS", 100.0),
                new Transaction("A1", "DEBIT", "SUCCESS", 40.0),
                new Transaction("A1", "DEBIT", "FAILED", 999.0),
                new Transaction("A2", "CREDIT", "SUCCESS", 200.0),
                new Transaction(null, "CREDIT", "SUCCESS", 500.0)
        );

        System.out.println(summarize(transactions));
        System.out.println(summarizeByType(transactions));
    }
}
