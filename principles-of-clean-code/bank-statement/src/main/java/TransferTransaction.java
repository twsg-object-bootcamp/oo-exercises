import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferTransaction implements Transaction {
    private final String account;
    private final String toAccount;
    private final BigDecimal amount;
    private final LocalDateTime time;

    public TransferTransaction(String account, String toAccount, BigDecimal amount, LocalDateTime time) {
        this.account = account;
        this.toAccount = toAccount;
        this.amount = amount;
        this.time = time;
    }

    public String format() {
        return null;
    }
}