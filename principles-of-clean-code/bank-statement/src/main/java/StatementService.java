import java.util.List;

public class StatementService {
    private final List<Transaction> transactions;

    public StatementService(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String printStatement() {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < transactions.size(); index++) {
            builder.append(String.format(
                    "\n==========%02d==========\n", index + 1));
            builder.append(transactions.get(index).format());
            builder.append("\n======================");
        }

        return builder.toString();
    }
}
