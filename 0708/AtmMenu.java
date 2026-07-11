import java.util.Scanner;

public class AtmMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 初始設定 1000
        int balance = 1000;
        int option = -1;

        while (option != 0) {
            System.out.println("=== ATM Menu ===");
            System.out.println("1：查詢餘額");
            System.out.println("2：存款");
            System.out.println("3：提款");
            System.out.println("0：離開");
            System.out.print("請輸入選項：");
            option = sc.nextInt();
        switch (option) {
                case 1:
                    System.out.println("目前帳戶餘額為：" + balance + " 元");
                    break;

                case 2:
                    System.out.print("請輸入存款金額：");
                    int deposit = sc.nextInt();

                    // 存款金額必須大於 0
                    while (deposit <= 0) {
                        System.out.print("存款金額必須大於 0，請重新輸入：");
                        deposit = sc.nextInt();
                    }

                    // 更新餘額並顯示結果
                    balance += deposit;
                    System.out.println("存款成功！目前帳戶餘額為：" + balance + " 元");
                    break;

                case 3:
                    System.out.print("請輸入提款金額：");
                    int withdraw = sc.nextInt();

                    // 提款金額必須大於 0
                    while (withdraw <= 0) {
                        System.out.print("提款金額必須大於 0，請重新輸入：");
                        withdraw = sc.nextInt();
                    }

                    // 提款不能大於目前餘額
                    if (withdraw > balance) {
                        System.out.println("錯誤：提款失敗，帳戶餘額不足！");
                    } else {
                        // 更新餘額顯示結果
                        balance -= withdraw;
                        System.out.println("提款成功！請領取現金。目前帳戶餘額為：" + balance + " 元");
                    }
                    break;

                case 0:
                    System.out.println("結束");
                    break;

                default:
                    System.out.println("無效選項，重新輸入。");
            }
            System.out.println();
        }

        sc.close();
    }
}