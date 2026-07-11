import java.util.Scanner;

public class OrderSystem_demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 宣告累加總金額與計算總數量的變數
        int totalAmount = 0; // 總金額
        int totalItems = 0;  // 總數量
        int option = -1;

        // 使用 while 建立重複選單，直到選擇 0 才結束
        while (option != 0) {
            System.out.println("=== Order Menu ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");
            
            option = sc.nextInt();

            if (option == 1 || option == 2 || option == 3) {
                System.out.print("請輸入數量：");
                int quantity = sc.nextInt();

                // 使用輸入驗證確認數量必須大於 0
                while (quantity <= 0) {
                    System.out.print("數量必須大於 0，請重新輸入：");
                    quantity = sc.nextInt();
                }

                int price = 0;
                // 使用 switch 判斷商品選項並給予對應單價
                switch (option) {
                    case 1:
                        price = 30;
                        break;
                    case 2:
                        price = 35;
                        break;
                    case 3:
                        price = 50;
                        break;
                }

                // 計算本次小計
                int subtotal = price * quantity;
                System.out.println("Subtotal: " + subtotal);
                System.out.println();

                // 累加總金額與總數量
                totalAmount += subtotal;
                totalItems += quantity;

            } else if (option == 0) {
                System.out.println();
            } else {
                System.out.println("無效的選項，請重新輸入。\n");
            }
        }

        // 輸出總數量與總金額
        System.out.println("=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);

        sc.close();
    }
}