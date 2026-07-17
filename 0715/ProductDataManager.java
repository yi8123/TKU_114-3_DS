/*
 ==============================================================================
 1. 正常值：原始資料解析 -> 啟動時自動跑 initializeData() -> 預期結果：成功呼叫 split(",") 載入表格[cite: 1]。
 2. 正常值：精確搜尋 -> 搜尋 "Keyboard" -> 預期結果：使用 equalsIgnoreCase 命中對應商品[cite: 1]。
 3. 正常值：部分搜尋 -> 搜尋 "Cable" -> 預期結果：使用 contains() 模糊篩選出完整資料[cite: 1]。
 4. 邊界值：低庫存篩選 -> 選單輸入 3 -> 預期結果：精確找出數量 <= 10 的邊界短缺商品。
 5. 正常值：總資產試算 -> 選單輸入 4 -> 預期結果：加總並準確輸出當前所有商品的庫存總價值。
 6. 正常值：新字串寫入 -> 輸入 "Laptop,28500,15" -> 預期結果：解析成功並分配至各平行陣列末端[cite: 1]。
 7. 格式錯誤：欄位缺失 -> 輸入 "Speaker,1200" -> 預期結果：命中 parts.length != 3 條件，提示格式錯誤[cite: 1]。
 8. 錯誤值/格式錯誤：型態轉換錯誤 -> 輸入 "Pad,abc,10" -> 預期結果：捕捉 NumberFormatException，不中止程式[cite: 1]。
 ==============================================================================
*/

import java.util.Scanner;

public class ProductDataManager {
    private static final String[] records = {
        "Keyboard,890,12",
        "Mouse,490,20",
        "Monitor,5200,5",
        "USB Cable,250,30",
        "Headset,1290,8"
    };

    private static String[] names = new String[10];
    private static int[] prices = new int[10];
    private static int[] stocks = new int[10];
    private static int productCount = 0; 

    public static void main(String[] args) {
        initializeData();

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
            System.out.print("請選擇功能 (1-6)：");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    displayProductTable();
                    break;
                case "2":
                    System.out.print("請輸入要搜尋的商品名稱：");
                    String keyword = sc.nextLine();
                    searchProduct(keyword);
                    break;
                case "3":
                    displayLowStock(10); 
                    break;
                case "4":
                    displayTotalValue();
                    break;
                case "5":
                    System.out.print("請輸入新商品字串資料 ： ");
                    String newRecord = sc.nextLine();
                    addNewProduct(newRecord);
                    break;
                case "6":
                    System.out.println("系統結束，謝謝使用！");
                    running = false;
                    break;
                default:
                    System.out.println("【錯誤】無效選項，請重新選擇。");
            }
            System.out.println(); 
        }
        sc.close();
    }

    public static void showMenu() {
        System.out.println("===== 商品資料管理系統 =====");
        System.out.println("1. 顯示商品表格");
        System.out.println("2. 搜尋商品");
        System.out.println("3. 篩選低庫存商品 (<=10)");
        System.out.println("4. 計算庫存總價值");
        System.out.println("5. 輸入新商品資料");
        System.out.println("6. 結束程式");
        System.out.println("============================");
    }

    public static void initializeData() {
        for (String record : records) {
            parseAndInsert(record, false); 
        }
        System.out.println(">>> 原始資料初始化解析完畢，共載入 " + productCount + " 筆商品。");
    }

    public static void parseAndInsert(String record, boolean isUserInserted) {
        if (record == null || record.trim().isEmpty()) {
            System.out.println("【錯誤】輸入內容不可為空！");
            return;
        }

        String[] parts = record.split(",");

        if (parts.length != 3) {
            System.out.println("【錯誤】資料格式錯誤！欄位數不符合規範。");
            return;
        }

        String name = parts[0].trim();
        
        try {
            int price = Integer.parseInt(parts[1].trim());
            int stock = Integer.parseInt(parts[2].trim());

            if (price < 0 || stock < 0) {
                System.out.println("【錯誤】價格與庫存數量不可為負數！");
                return;
            }

            if (productCount >= names.length) {
                resizeArrays();
            }

            names[productCount] = name;
            prices[productCount] = price;
            stocks[productCount] = stock;
            productCount++;

            if (isUserInserted) {
                System.out.println("【成功】新商品「" + name + "」已成功匯入系統。");
            }

        } catch (NumberFormatException e) {
            System.out.println("【錯誤】格式錯誤，必須輸入整數！(數字轉型失敗)");
        }
    }

    public static void displayProductTable() {
        System.out.println("\n【商品資料表格】");
        System.out.printf("%-4s | %-15s | %-8s | %-6s%n", "ID", "商品名稱", "商品價格", "庫存量");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < productCount; i++) {
            System.out.printf("%-4d | %-15s | %-8d | %-6d%n", (i + 1), names[i], prices[i], stocks[i]);
        }
    }

    public static void searchProduct(String keyword) {
        String normalized = keyword.trim().toLowerCase();
        boolean found = false;

        System.out.println("\n【搜尋結果】");
        for (int i = 0; i < productCount; i++) {
            String lowerName = names[i].toLowerCase();
            if (lowerName.equals(normalized) || lowerName.contains(normalized)) {
                System.out.printf("- [ID:%d] 名稱：%s, 價格：%d 元, 庫存：%d%n", (i+1), names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("找不到相符資料");
        }
    }

    public static void displayLowStock(int threshold) {
        System.out.println("\n【低庫存商品警告清單 (庫存 <= " + threshold + ")】");
        System.out.printf("%-15s | %-6s%n", "商品名稱", "當前庫存");
        System.out.println("-------------------------");
        boolean hasLowStock = false;

        for (int i = 0; i < productCount; i++) {
            if (stocks[i] <= threshold) {
                System.out.printf("%-15s | %-6d%n", names[i], stocks[i]);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("目前所有商品庫存均十分充足。");
        }
    }

    public static void displayTotalValue() {
        long totalValue = 0; 
        for (int i = 0; i < productCount; i++) {
            totalValue += (long) prices[i] * stocks[i];
        }
        System.out.println("\n【庫存資產評估】");
        System.out.printf("目前系統總計有 %d 種商品，庫存總價值為：%,d 元%n", productCount, totalValue);
    }

    public static void addNewProduct(String inputData) {
        parseAndInsert(inputData, true);
    }

    private static void resizeArrays() {
        int newLength = names.length * 2;
        String[] newNames = new String[newLength];
        int[] newPrices = new int[newLength];
        int[] newStocks = new int[newLength];

        System.arraycopy(names, 0, newNames, 0, names.length);
        System.arraycopy(prices, 0, newPrices, 0, prices.length);
        System.arraycopy(stocks, 0, newStocks, 0, stocks.length);

        names = newNames;
        prices = newPrices;
        stocks = newStocks;
    }
}