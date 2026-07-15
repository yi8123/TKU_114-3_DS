import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] sales = new int[3][4];

        inputSales(sc, sales);

        System.out.println("\n=== 銷售資料 ===");
        displaySales(sales);

        System.out.println("\n=== 每項商品總銷售量 ===");
        calculateProductTotal(sales);

        System.out.println("\n=== 每天總銷售量 ===");
        calculateDayTotal(sales);

        findBestProduct(sales);

        sc.close();
    }

    // 輸入銷售量
    public static void inputSales(Scanner sc, int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                while (true) {
                    System.out.print("請輸入商品" + (i + 1) + "第" + (j + 1) + "天銷售量：");
                    int value = sc.nextInt();

                    if (value >= 0) {
                        sales[i][j] = value;
                        break;
                    }

                    System.out.println("錯誤！銷售量不可小於0，請重新輸入。");
                }
            }
        }
    }

    // 顯示表格
    public static void displaySales(int[][] sales) {
        System.out.print("      ");
        for (int j = 0; j < sales[0].length; j++) {
            System.out.print("第" + (j + 1) + "天\t");
        }
        System.out.println();

        for (int i = 0; i < sales.length; i++) {
            System.out.print("商品" + (i + 1) + "\t");
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 計算每項商品總銷售量
    public static void calculateProductTotal(int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            int total = 0;

            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }

            System.out.println("商品" + (i + 1) + "總銷售量：" + total);
        }
    }

    // 計算每天總銷售量
    public static void calculateDayTotal(int[][] sales) {
        for (int j = 0; j < sales[0].length; j++) {
            int total = 0;

            for (int i = 0; i < sales.length; i++) {
                total += sales[i][j];
            }

            System.out.println("第" + (j + 1) + "天總銷售量：" + total);
        }
    }

    // 找出總銷售量最高的商品
    public static void findBestProduct(int[][] sales) {
        int maxTotal = 0;
        int bestProduct = 0;

        for (int i = 0; i < sales.length; i++) {
            int total = 0;

            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }

            if (i == 0 || total > maxTotal) {
                maxTotal = total;
                bestProduct = i;
            }
        }

        System.out.println("\n=== 銷售冠軍 ===");
        System.out.println("商品" + (bestProduct + 1) + " 銷售量最高，共 " + maxTotal + " 件。");
    }
}