import java.util.Scanner;

public class ProductManagementSystem {
    private static Product[] products = new Product[10];
    private static int productCount = 0;
    private static int totalOperations = 0;

    public static void main(String[] args) {
        initProducts();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            printMenu();
            System.out.print("請選擇功能 (1-9): ");
            String choice = scanner.nextLine().trim();
            System.out.println("---------------------------------");

            if (choice.equals("9")) {
                showSummary();
                break;
            }

            switch (choice) {
                case "1": showAllProducts(); break;
                case "2": searchProduct(scanner); break;
                case "3": addNewProduct(scanner); break;
                case "4": sellProduct(scanner); break;
                case "5": restockProduct(scanner); break;
                case "6": updatePrice(scanner); break;
                case "7": showLowStock(); break;
                case "8": showTotalValue(); break;
                default: System.out.println("無效的選項，請重新輸入。");
            }
            System.out.println("---------------------------------");
        }
        scanner.close();
    }

    // --- 輔助方法 1：初始化資料 ---
    private static void initProducts() {
        products[0] = new Product("iPhone 15", 29900, 15);
        products[1] = new Product("iPad Air", 19900, 5);
        products[2] = new Product("MacBook Pro", 59900, 8);
        products[3] = new Product("AirPods Pro", 74900, 25);
        products[4] = new Product("Apple Watch", 13900, 3);
        productCount = 5;
    }

    // --- 輔助方法 2：顯示主選單 ---
    private static void printMenu() {
        System.out.println("\n===== 商品管理系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依完整名稱搜尋");
        System.out.println("3. 新增商品");
        System.out.println("4. 出售商品");
        System.out.println("5. 補充庫存");
        System.out.println("6. 修改商品價格");
        System.out.println("7. 顯示低庫存商品");
        System.out.println("8. 顯示全部庫存總價值");
        System.out.println("9. 結束並顯示操作摘要");
    }

    // --- 輔助方法 3：顯示全部商品 ---
    private static void showAllProducts() {
        System.out.println("【目前商品列表】");
        for (int i = 0; i < productCount; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
        totalOperations++;
    }

    // --- 輔助方法 4：依完整名稱搜尋 (不分大小寫、去空白) ---
    private static void searchProduct(Scanner sc) {
        System.out.print("請輸入欲搜尋的完整商品名稱: ");
        String name = sc.nextLine();
        int index = findProductIndex(name);
        
        if (index != -1) {
            System.out.println("找到商品: " + products[index]);
        } else {
            System.out.println("找不到該商品。");
        }
        totalOperations++;
    }

    // --- 輔助方法 5：新增商品 ---
    private static void addNewProduct(Scanner sc) {
        if (productCount >= products.length) {
            System.out.println("錯誤：商品陣列已滿，無法新增！");
            return;
        }

        System.out.print("請輸入新商品名稱: ");
        String name = sc.nextLine();
        
        if (findProductIndex(name) != -1) {
            System.out.println("錯誤：已有重複名稱的商品！");
            return;
        }

        System.out.print("請輸入價格: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("請輸入庫存: ");
        int stock = Integer.parseInt(sc.nextLine());

        products[productCount] = new Product(name, price, stock);
        System.out.println("成功新增商品: " + products[productCount]);
        productCount++;
        totalOperations++;
    }

    // --- 輔助方法 6：共同商組邏輯 - 依名稱尋找索引位置 ---
    private static int findProductIndex(String name) {
        if (name == null) return -1;
        String target = name.trim().toLowerCase();
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().trim().toLowerCase().equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // --- 輔助方法 7：出售、補貨、改價的業務執行邏輯 ---
    private static void sellProduct(Scanner sc) {
        System.out.print("請輸入欲出售的商品名稱: ");
        int index = findProductIndex(sc.nextLine());
        if (index == -1) {
            System.out.println("錯誤：找不到該商品。");
            return;
        }
        System.out.print("請輸入出售數量: ");
        int qty = Integer.parseInt(sc.nextLine());
        if (products[index].sell(qty)) {
            System.out.println("出售成功！目前商品狀態: " + products[index]);
        } else {
            System.out.println("出售失敗：庫存不足或輸入數量不合法。");
        }
        totalOperations++;
    }

    private static void restockProduct(Scanner sc) {
        System.out.print("請輸入欲補貨的商品名稱: ");
        int index = findProductIndex(sc.nextLine());
        if (index == -1) {
            System.out.println("錯誤：找不到該商品。");
            return;
        }
        System.out.print("請輸入補貨數量: ");
        int qty = Integer.parseInt(sc.nextLine());
        if (products[index].restock(qty)) {
            System.out.println("補貨成功！目前商品狀態: " + products[index]);
        } else {
            System.out.println("補貨失敗：輸入數量不合法。");
        }
        totalOperations++;
    }

    private static void updatePrice(Scanner sc) {
        System.out.print("請輸入欲修改價格的商品名稱: ");
        int index = findProductIndex(sc.nextLine());
        if (index == -1) {
            System.out.println("錯誤：找不到該商品。");
            return;
        }
        System.out.print("請輸入新價格: ");
        int price = Integer.parseInt(sc.nextLine());
        if (products[index].setPrice(price)) {
            System.out.println("價格修改成功！目前商品狀態: " + products[index]);
        } else {
            System.out.println("修改失敗：價格必須大於 0。");
        }
        totalOperations++;
    }

    private static void showLowStock() {
        System.out.println("【低庫存商品列表 (庫存 < 10)】");
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].isLowStock()) {
                System.out.println(products[i]);
                found = true;
            }
        }
        if (!found) System.out.println("目前無任何低庫存商品。");
        totalOperations++;
    }

    private static void showTotalValue() {
        long totalValue = 0;
        for (int i = 0; i < productCount; i++) {
            totalValue += products[i].getInventoryValue();
        }
        System.out.println("全店目前商品總價值為: " + totalValue + " 元");
        totalOperations++;
    }

    // --- 輔助方法 8：結束並顯示摘要 ---
    private static void showSummary() {
        System.out.println("謝謝使用！本次運行期間您共執行了 " + totalOperations + " 次有效功能操作。");
    }
}