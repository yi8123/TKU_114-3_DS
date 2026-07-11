import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int totalAmount = 0;
        int totalCount = 0;  
        int option = -1;     

        while (option != 0) {
            
            System.out.println("=== Order System ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請輸入商品選項：");
            
            
            option = sc.nextInt();

            if (option == 1 || option == 2 || option == 3) {
                
                System.out.print("請輸入數量：");
                int quantity = sc.nextInt();

                while (quantity <= 0) {
                    System.out.print("數量必須大於 0，請重新輸入：");
                    quantity = sc.nextInt();
                }

                int price = 0;
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

                int subtotal = price * quantity; 
                totalAmount += subtotal;         
                totalCount += quantity;         

                System.out.println("小計：" + subtotal + " 元");
                System.out.println(); 

            } else if (option == 0) {
                System.out.println("結帳");
                System.out.println();
            } else {
                System.out.println("無效選項，重新選擇。");
                System.out.println();
            }
        }

        System.out.println("====== 結帳明細 ======");
        System.out.println("最後總數量：" + totalCount + " 杯");
        System.out.println("最後總金額：" + totalAmount + " 元");
        System.out.println("Bye");

        sc.close();
    }
}