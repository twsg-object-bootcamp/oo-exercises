import java.util.Scanner;

public class Main {
    private static final int LIMIT = 1000;

class Account {
    int balance;

    Account(int initialBalance) { this.balance = initialBalance; }

    boolean canWithdraw(int amount) { return this.balance >= amount; }

    boolean canDeposit(int amount) { return this.balance + amount <= LIMIT; }

    void withdraw(int amount) { this.balance -= amount; }

    void deposit(int amount) { this.balance += amount; }
}

class TransactionService {
    Account from;
    Account to;

    TransactionService(Account from, Account to) {
        this.from = from;
        this.to = to;
    }

    boolean makeTransaction(int transferAmount) {
        if (!this.from.canWithdraw(transferAmount)) {
            System.out.println("Not enough balance!!! Please try again.");
            return false;
        } else if (!this.to.canDeposit(transferAmount)) {
            System.out.println("Balance is over limit!!! Please try again.");
            return false;
        } else {
            executeTransaction(transferAmount);
            System.out.println("Transaction was successful.");
            return true;
        }
    }

    private void executeTransaction(int transferAmount) {
        this.from.withdraw(transferAmount);
        this.to.deposit(transferAmount);
    }
}

    public void run() {
Account from = new Account(1000);
Account to = new Account(500);
TransactionService transactionService = new TransactionService(from, to);

Scanner in = new Scanner(System.in);
int transferAmount;
char confirmation;
do {
    System.out.println("Enter the amount:");
    transferAmount = in.nextInt();
    if (!transactionService.makeTransaction(transferAmount)) {
        confirmation = 'Y';
    } else {
        System.out.println("Do you want to make another one? (Y/N):");
        confirmation = in.next().charAt(0);
    }
} while (confirmation == 'Y');
    }
}