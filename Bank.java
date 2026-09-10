class BankAccount {

    // Variables
    String accountHolder;
    long accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    // Display account details
    void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class Bank{

    public static void main(String[] args) {

        // Creating an object
        BankAccount account1 =
            new BankAccount("Arun", 1234567890L, 10000.00);

        // Display initial details
        account1.displayAccount();

        // Deposit money
        account1.deposit(5000);

        // Withdraw money
        account1.withdraw(2000);

        // Display final details
        account1.displayAccount();
    }
}

