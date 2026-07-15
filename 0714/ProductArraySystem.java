import java.util.Scanner;

public class ProductArraySystem {

    static int buyCount = 0;
    static int restockCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int choice;

        do {
            showMenu();
            System.out.print("請輸入選項：");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showAllProducts(names, prices, stocks);
                    break;
                case 2:
                    queryProduct(sc, names, prices, stocks);
                    break;
                case 3:
                    buyProduct(sc, names, prices, stocks);
                    break;
                case 4:
                    restockProduct(sc, names, stocks);
                    break;
                case 5:
                    showLowStock(names, stocks);
                    break;
                case 6:
                    showInventoryValue(prices, stocks);
                    break;
                case 7:
                    showSummary();
                    System.out.println("程式結束！");
                    break;
                default:
                    System.out.println("選項錯誤！");
            }

        } while (choice != 7);

        sc.close();
    }

    // 顯示選單
    public static void showMenu() {
        System.out.println("\n===== 商品管理系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依商品編號查詢");
        System.out.println("3. 購買商品");
        System.out.println("4. 補充庫存");
        System.out.println("5. 顯示低庫存商品");
        System.out.println("6. 顯示全部庫存總價值");
        System.out.println("7. 結束");
    }

    // 顯示全部商品
    public static void showAllProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n編號\t商品\t\t價格\t庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + "\t" + names[i] + "\t" + prices[i] + "\t" + stocks[i]);
        }
    }

    // 查詢商品
    public static void queryProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入商品編號：");
        int no = sc.nextInt();

        if (no >= 1 && no <= names.length) {
            int index = no - 1;
            System.out.println("商品：" + names[index]);
            System.out.println("價格：" + prices[index]);
            System.out.println("庫存：" + stocks[index]);
        } else {
            System.out.println("商品編號不存在！");
        }
    }

    // 購買商品
    public static void buyProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入商品編號：");
        int no = sc.nextInt();

        if (no < 1 || no > names.length) {
            System.out.println("商品編號不存在！");
            return;
        }

        int index = no - 1;

        System.out.print("請輸入購買數量：");
        int qty = sc.nextInt();

        if (qty <= 0) {
            System.out.println("購買數量必須大於0！");
        } else if (qty > stocks[index]) {
            System.out.println("庫存不足！");
        } else {
            stocks[index] -= qty;
            buyCount++;
            System.out.println("購買成功！");
        }
    }

    // 補充庫存
    public static void restockProduct(Scanner sc, String[] names, int[] stocks) {
        System.out.print("請輸入商品編號：");
        int no = sc.nextInt();

        if (no < 1 || no > names.length) {
            System.out.println("商品編號不存在！");
            return;
        }

        int index = no - 1;

        System.out.print("請輸入補貨數量：");
        int qty = sc.nextInt();

        if (qty <= 0) {
            System.out.println("補貨數量必須大於0！");
        } else {
            stocks[index] += qty;
            restockCount++;
            System.out.println("補貨成功！");
        }
    }

    // 顯示低庫存商品
    public static void showLowStock(String[] names, int[] stocks) {
        System.out.println("\n=== 低庫存商品 ===");

        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (stocks[i] < 10) {
                System.out.println(names[i] + "，庫存：" + stocks[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("沒有低庫存商品。");
        }
    }

    // 顯示全部庫存總價值
    public static void showInventoryValue(int[] prices, int[] stocks) {
        int total = 0;

        for (int i = 0; i < prices.length; i++) {
            total += prices[i] * stocks[i];
        }

        System.out.println("全部庫存總價值：" + total + " 元");
    }

    // 操作摘要
    public static void showSummary() {
        System.out.println("\n===== 操作摘要 =====");
        System.out.println("購買操作次數：" + buyCount);
        System.out.println("補貨操作次數：" + restockCount);
    }

}