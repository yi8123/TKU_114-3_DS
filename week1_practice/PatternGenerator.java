import java.util.Scanner;

public class PatternGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("請輸入選項：");

            if (!sc.hasNextInt()) {
                System.out.println("【錯誤】請輸入正確的數字選項。");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("謝謝使用，系統已關閉。");
                break;
            }

            switch (choice) {
                case 1:
                    printMultiplicationTable();
                    break;
                case 2:
                    int height = readPositiveInt(sc, "請輸入正三角形高度：");
                    printTriangle(height);
                    break;
                case 3:
                    int revHeight = readPositiveInt(sc, "請輸入倒三角形高度：");
                    printReverseTriangle(revHeight);
                    break;
                case 4:
                    int rows = readPositiveInt(sc, "請輸入數字方格的列數 (rows)：");
                    int cols = readPositiveInt(sc, "請輸入數字方格的欄數 (cols)：");
                    printNumberGrid(rows, cols);
                    break;
                default:
                    System.out.println("【錯誤】沒有這個選項，請重新輸入。");
                    break;
            }
            System.out.println(); 
        }

        sc.close();
    }

    /**
     * 印出系統主選單
     */
    public static void printMenu() {
        System.out.println("=== Pattern & Table Generator ===");
        System.out.println("1. 九九乘法表");
        System.out.println("2. 正三角形 ");
        System.out.println("3. 倒三角形");
        System.out.println("4. 數字方格");
        System.out.println("0. 離開");
    }

    public static int readPositiveInt(Scanner sc, String message) {
        int val = 0;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                val = sc.nextInt();
                if (val > 0) {
                    break;
                } else {
                    System.out.println("【錯誤】輸入數值必須大於 0。");
                }
            } else {
                System.out.println("【錯誤】請輸入合法的整數。");
                sc.next();
            }
        }
        return val;
    }

    /**
     * 使用巢狀迴圈輸出 1x1 到 9x9 的九九乘法表
     */
    public static void printMultiplicationTable() {
        System.out.println("\n--- 九九乘法表 ---");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf(i + "x" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 繪製正三角形
     */
    public static void printTriangle(int height) {
        System.out.println("\n--- 正三角形 ---");
        for (int i = 1; i <= height; i++) {
            // 第 i 行印出 i 個星號
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 繪製倒三角形
     */
    public static void printReverseTriangle(int height) {
        System.out.println("\n--- 倒三角形 ---");
        for (int i = height; i >= 1; i--) {
            // 第 i 行印出 i 個星號 (i 從 height 遞減到 1)
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 印出數字方格。
     */
    public static void printNumberGrid(int rows, int cols) {
        System.out.println("\n--- 數字方格 ---");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}