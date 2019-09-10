import humanize.Humanize;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class DepositTransaction extends Transaction {
    private final String account;
    private final BigDecimal amount;
    private final LocalDateTime time;

    public DepositTransaction(String account, BigDecimal amount, LocalDateTime time) {
        this.account = account;
        this.amount = amount;
        this.time = time;
    }

    public String format() {
        LocalDateTime now = LocalDateTime.now();
        String formattedTime;
        if (time.isAfter(now.minusDays(1))) {
            formattedTime = Humanize.naturalTime(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()));
        } else {
            formattedTime = time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        }

        return String.format(
                "Type: Deposit.\n" +
                "Account: %s.\n" +
                "Time: %s.\n" +
                "Amount: %.2f.", account, formattedTime, amount);
    }
}
