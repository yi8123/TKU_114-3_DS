public class BankAccount {
    private String accountNumber;
    private String accountName;
    private int balance;

    public BankAccount(String accountNumber, String accountName, int initialBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialBalance > 0 ? initialBalance : 0;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountName() { return accountName; }
    public int getBalance() { return balance; }

    public boolean deposit(int amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount target, int amount) {
        if (target == null || amount <= 0 || amount > this.balance) {
            return false;
        }
        // 扣除目前帳戶並存入目標帳戶
        this.balance -= amount;
        target.deposit(amount);
        return true;
    }

    @Override
    public String toString() {
        return String.format("帳號: %s | 戶名: %s | 餘額: %d 元", accountNumber, accountName, balance);
    }
}