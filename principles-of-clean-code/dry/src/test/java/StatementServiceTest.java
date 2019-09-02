import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class StatementServiceTest {
    private static final LocalDateTime NOW = LocalDateTime.now();

    @Test
    public void shouldPrintDepositTransactionCorrectly() {
        LocalDateTime transactionTime = NOW.minusDays(2);
        Transaction transaction = new DepositTransaction("1234-5678", BigDecimal.TEN, transactionTime);
        StatementService statementService = new StatementService(singletonList(transaction));

        String expected = String.format("\n" +
                "==========01==========\n" +
                "Type: Deposit.\n" +
                "Account: 1234-5678.\n" +
                "Time: %s.\n" +
                "Amount: 10.00.\n" +
                "======================",
                transactionTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        );
        assertEquals(expected, statementService.printStatement());
    }

    @Test
    public void shouldPrintWithdrawalTransactionCorrectly() {
        LocalDateTime transactionTime = NOW.minusDays(2);
        Transaction transaction = new WithdrawalTransaction("1234-5678", BigDecimal.TEN, transactionTime);
        StatementService statementService = new StatementService(singletonList(transaction));

        String expected = String.format("\n" +
                        "==========01==========\n" +
                        "Type: Withdrawal.\n" +
                        "Account: 1234-5678.\n" +
                        "Time: %s.\n" +
                        "Amount: -10.00.\n" +
                        "======================",
                transactionTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        );
        assertEquals(expected, statementService.printStatement());
    }

    @Test
    public void shouldPrintTimeInNaturalForm_whenTransactionTimeIsLessThan24Hours() {
        LocalDateTime transactionTime = NOW.minusMinutes(5);
        Transaction transaction = new WithdrawalTransaction("1234-5678", BigDecimal.TEN, transactionTime);
        StatementService statementService = new StatementService(singletonList(transaction));

        String expected = "\n" +
                        "==========01==========\n" +
                        "Type: Withdrawal.\n" +
                        "Account: 1234-5678.\n" +
                        "Time: 5 minutes ago.\n" +
                        "Amount: -10.00.\n" +
                        "======================";
        assertEquals(expected, statementService.printStatement());
    }

    @Test
    public void shouldPrintMultipleTransactionInOrder() {
        LocalDateTime transactionTime = NOW.minusDays(2);
        Transaction first = new DepositTransaction("1234-5678", BigDecimal.TEN, transactionTime);
        Transaction second = new WithdrawalTransaction("1234-5678", BigDecimal.TEN, transactionTime);
        StatementService statementService = new StatementService(asList(first, second));

        String expected = String.format("\n" +
                        "==========01==========\n" +
                        "Type: Deposit.\n" +
                        "Account: 1234-5678.\n" +
                        "Time: %1$s.\n" +
                        "Amount: 10.00.\n" +
                        "======================" +
                        "\n" +
                        "==========02==========\n" +
                        "Type: Withdrawal.\n" +
                        "Account: 1234-5678.\n" +
                        "Time: %1$s.\n" +
                        "Amount: -10.00.\n" +
                        "======================",
                transactionTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        );
        assertEquals(expected, statementService.printStatement());
    }
}