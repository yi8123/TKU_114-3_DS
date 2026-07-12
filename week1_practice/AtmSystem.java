import java.util.Scanner;

public class AtmSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int balance = 1000;       // 初始餘額
        int depositCount = 0;    // 存款成功次數
        int withdrawCount = 0;   // 提款成功次數
        int totalDeposit = 0;    // 總存款金額
        int totalWithdraw = 0;   // 總提款金額

        while (true) {
            printMenu();
            System.out.print("請輸入選項：");

            if (!sc.hasNextInt()) {
                System.out.println("【錯誤】請輸入數字指令。");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    printBalance(balance);
                    break;

                case 2:
                    int dAmount = readPositiveAmount(sc, "請輸入存款金額：");
                    balance = deposit(balance, dAmount);
                    totalDeposit += dAmount;
                    depositCount++;
                    printBalance(balance);
                    break;

                case 3:
                    int wAmount = readPositiveAmount(sc, "請輸入提款金額：");
                    // 驗證 ATM 餘額是否足夠扣款
                    if (canWithdraw(balance, wAmount)) {
                        balance = withdraw(balance, wAmount);
                        totalWithdraw += wAmount;
                        withdrawCount++;
                        printBalance(balance);
                    } else {
                        System.out.println("【交易失敗】餘額不足，無法提款。目前餘額為: " + balance);
                    }
                    break;

                case 4:
                    printSummary(balance, depositCount, withdrawCount, totalDeposit, totalWithdraw);
                    break;

                default:
                    System.out.println("【錯誤】無效的選項，請重新輸入。");
                    break;
            }
            System.out.println();
        }

        // 離開時印出最終操作
        printSummary(balance, depositCount, withdrawCount, totalDeposit, totalWithdraw);
        sc.close();
    }

    /**
     * 顯示 ATM 功能選單
     */
    public static void printMenu() {
        System.out.println("=== ATM Menu ===");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show summary");
        System.out.println("0. Exit");
    }

    /**
     * 讀取大於 0 的金額
     */
    public static int readPositiveAmount(Scanner sc, String message) {
        int amount = 0;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                amount = sc.nextInt();
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("【錯誤】金額必須大於 0。");
                }
            } else {
                System.out.println("【錯誤】請輸入合法的整數金額。");
                sc.next();
            }
        }
        return amount;
    }

    /**
     * 執行存款
     */
    public static int deposit(int balance, int amount) {
        return balance + amount;
    }

    /**
     * 執行提款
     */
    public static int withdraw(int balance, int amount) {
        return balance - amount;
    }

    /**
     * 檢查帳戶餘額是否足夠提款
     */
    public static boolean canWithdraw(int balance, int amount) {
        return balance >= amount;
    }

    /**
     * 印出目前餘額
     */
    public static void printBalance(int balance) {
        System.out.println("Balance: " + balance);
    }

    public static void printSummary(int balance, int depositCount, int withdrawCount, int totalDeposit, int totalWithdraw) {
        System.out.println("\n=== ATM Summary ===");
        System.out.println("Final balance: " + balance);
        System.out.println("Deposit count: " + depositCount);
        System.out.println("Withdraw count: " + withdrawCount);
        System.out.println("Total deposit: " + totalDeposit);
        System.out.println("Total withdraw: " + totalWithdraw);
    }
}
