import java.util.Scanner;

public class DrinkOrderSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 宣告各商品的銷售計數器
        int blackTeaCount = 0;
        int greenTeaCount = 0;
        int milkTeaCount = 0;
        int coffeeCount = 0;
        
        int totalItems = 0;
        int totalAmount = 0;

        while (true) {
            printMenu();
            System.out.print("請輸入選項：");
            
            if (!sc.hasNextInt()) {
                System.out.println("【錯誤】請輸入數字選項。");
                sc.next();
                continue;
            }
            
            int option = sc.nextInt();

            if (option == 0) {
                // 選擇 0 結束點餐，前往結帳流程
                break;
            }

            // 檢查選項是否在 1~4 內
            if (option < 1 || option > 4) {
                System.out.println("【錯誤】無此商品選項，請重新選擇。");
                continue;
            }

            // 讀取並驗證大於 0 的數量
            int quantity = readValidQuantity(sc);

            // 計算小計與累加
            int price = getPrice(option);
            int subtotal = calculateSubtotal(price, quantity);
            
            String itemName = getItemName(option);
            System.out.println(itemName + " x " + quantity);
            System.out.println("Subtotal: " + subtotal + "\n");

            totalItems += quantity;
            totalAmount += subtotal;

            // 統計個別商品數量
            switch (option) {
                case 1: blackTeaCount += quantity; break;
                case 2: greenTeaCount += quantity; break;
                case 3: milkTeaCount += quantity; break;
                case 4: coffeeCount += quantity; break;
            }
        }

        // 計算折扣與產出收據
        int finalAmount = calculateDiscountedTotal(totalAmount);
        printReceipt(blackTeaCount, greenTeaCount, milkTeaCount, coffeeCount, totalItems, totalAmount, finalAmount);

        sc.close();
    }

    /**
     * 列印飲料系統商品選單
     */
    public static void printMenu() {
        System.out.println("=== Drink Menu ===");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Milk tea   $45");
        System.out.println("4. Coffee     $50");
        System.out.println("0. Checkout");
    }

    /**
     * 依選項取得商品單價
     */
    public static int getPrice(int option) {
        switch (option) {
            case 1: return 30;
            case 2: return 35;
            case 3: return 45;
            case 4: return 50;
            default: return 0;
        }
    }

    /**
     * 依選項取得商品名稱
     */
    public static String getItemName(int option) {
        switch (option) {
            case 1: return "Black tea";
            case 2: return "Green tea";
            case 3: return "Milk tea";
            case 4: return "Coffee";
            default: return "";
        }
    }

    /**
     * 讀取購買數量（必須大於 0）
     */
    public static int readValidQuantity(Scanner sc) {
        int qty = 0;
        while (true) {
            System.out.print("請輸入數量：");
            if (sc.hasNextInt()) {
                qty = sc.nextInt();
                if (qty > 0) {
                    break;
                } else {
                    System.out.println("【錯誤】數量必須大於 0。");
                }
            } else {
                System.out.println("【錯誤】請輸入合法的整數數量。");
                sc.next();
            }
        }
        return qty;
    }

    /**
     * 計算單項小計
     */
    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    /**
     * 滿 300 打 9 折，回傳折扣後的整數金額（無條件捨去小數點）
     */
    public static int calculateDiscountedTotal(int totalAmount) {
        if (totalAmount >= 300) {
            return (int) (totalAmount * 0.9);
        }
        return totalAmount;
    }

    /**
     * 列印最終結帳發票明細
     */
    public static void printReceipt(int blackTeaCount, int greenTeaCount, int milkTeaCount, int coffeeCount, int totalItems, int totalAmount, int finalAmount) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Black tea: " + blackTeaCount);
        System.out.println("Green tea: " + greenTeaCount);
        System.out.println("Milk tea: " + milkTeaCount);
        System.out.println("Coffee: " + coffeeCount);
        System.out.println("Total items: " + totalItems);
        System.out.println("Original amount: " + totalAmount);
        System.out.println("Discount: " + (totalAmount >= 300 ? "Yes (10% OFF)" : "No"));
        System.out.println("Final amount: " + finalAmount);
    }
}