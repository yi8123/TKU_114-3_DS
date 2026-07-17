/*
 ==============================================================================
 1. 正常值：顯示全部商品 -> 選單輸入 1 -> 預期結果：完整印出 5 筆原始商品[cite: 1]。
 2. 正常值：完整名稱搜尋 -> 輸入 "  mOnItOr  " -> 預期結果：成功處理前後空白與大小寫，查到 Monitor[cite: 1]。
 3. 不存在：完整名稱搜尋 -> 輸入 "Camera" -> 預期結果：顯示「找不到此商品！」[cite: 1]。
 4. 正常值：部分名稱搜尋 -> 輸入 "o" -> 預期結果：利用 toLowerCase().contains() 匹配出 Keyboard 與 Monitor[cite: 1]。
 5. 邊界值：最長商品查詢 -> 選單輸入 4 -> 預期結果：精確比對長度，抓出含空格長度最長的 "USB Cable"。
 6. 正常值：位置搜尋 -> 輸入 "board" -> 預期結果：利用 indexOf() 回傳在 "Keyboard" 的索引值 3[cite: 1]。
 ==============================================================================
*/

import java.util.Scanner;

public class ProductSearchSystem {
    private static final String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
    private static final int[] prices = {890, 490, 5200, 250, 1290};
    private static final int[] stocks = {12, 20, 5, 30, 8};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
            System.out.print("請選擇功能 (1-6)：");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    displayAllProducts();
                    break;
                case "2":
                    System.out.print("請輸入要精確搜尋的商品名稱：");
                    String exactKey = sc.nextLine();
                    searchExact(exactKey);
                    break;
                case "3":
                    System.out.print("請輸入要模糊搜尋的商品關鍵字：");
                    String partialKey = sc.nextLine();
                    searchPartial(partialKey);
                    break;
                case "4":
                    displayLongestProduct();
                    break;
                case "5":
                    System.out.print("請輸入要尋找位置的關鍵字：");
                    String indexKey = sc.nextLine();
                    findKeywordIndex(indexKey);
                    break;
                case "6":
                    System.out.println("系統已結束，謝謝使用！");
                    running = false;
                    break;
                default:
                    System.out.println("【錯誤】無效的選項，請重新選擇。");
            }
            System.out.println(); 
        }
        sc.close();
    }

    public static void showMenu() {
        System.out.println("===== 商品搜尋系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 完整名稱搜尋 (忽略大小寫與前後空白)");
        System.out.println("3. 部分名稱搜尋 (可顯示多筆)");
        System.out.println("4. 顯示名稱最長的商品");
        System.out.println("5. 顯示關鍵字第一次出現的位置");
        System.out.println("6. 結束");
        System.out.println("========================");
    }

    public static void displayAllProducts() {
        System.out.println("\n【目前所有商品清單】");
        System.out.printf("%-12s | %-6s | %-4s%n", "商品名稱", "價格", "庫存");
        System.out.println("---------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-12s | %-6d | %-4d%n", names[i], prices[i], stocks[i]);
        }
    }

    public static void searchExact(String keyword) {
        String cleanKey = keyword.trim();
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(cleanKey)) {
                System.out.printf("找到商品！名稱：%s, 價格：%d, 庫存：%d%n", names[i], prices[i], stocks[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("找不到此商品！");
        }
    }

    public static void searchPartial(String keyword) {
        String normalized = keyword.trim().toLowerCase();
        boolean found = false;

        System.out.println("\n【部分搜尋結果】");
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(normalized)) {
                System.out.printf("- 名稱：%s, 價格：%d, 庫存：%d%n", names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("找不到相符資料");
        }
    }

    public static void displayLongestProduct() {
        String longest = names[0];
        int longestIndex = 0;

        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > longest.length()) {
                longest = names[i];
                longestIndex = i;
            }
        }
        System.out.println("\n【名稱最長的商品】");
        System.out.printf("名稱：%s (字元數：%d), 價格：%d, 庫存：%d%n", 
                longest, longest.length(), prices[longestIndex], stocks[longestIndex]);
    }

    public static void findKeywordIndex(String keyword) {
        String normalizedKeyword = keyword.toLowerCase();
        boolean found = false;

        System.out.println("\n【關鍵字首次出現位置 (索引自 0 開始)】");
        for (String name : names) {
            String normalizedName = name.toLowerCase();
            int index = normalizedName.indexOf(normalizedKeyword);
            if (index != -1) {
                System.out.printf("商品「%-12s」-> 關鍵字首次出現在第 %d 個字元%n", name, index);
                found = true;
            }
        }
        if (!found) {
            System.out.println("所有商品名稱中皆未包含此關鍵字。");
        }
    }
}