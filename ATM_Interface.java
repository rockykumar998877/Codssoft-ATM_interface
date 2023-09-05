import java.util.Scanner;

public class ATM_Interface {
    private BankAccount account;
    private Scanner scanner;

    public ATM_Interface(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            processChoice(choice);
        }
    }

    public void printMenu() {
        System.out.println("===== ATM Interface =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    public void deposit() {
        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
    }

    public void exit() {
        System.out.println("Exiting...");
        scanner.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0); // Initial balance
        ATM_Interface atm = new ATM_Interface(bankAccount);
        atm.start();
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount for withdrawal.");
        }
    }
}
