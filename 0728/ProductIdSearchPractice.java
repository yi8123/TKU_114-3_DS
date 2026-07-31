import java.util.Scanner;

public class ProductIdSearchPractice {
    public static void main(String[] args) {
        int[] products = {402, 105, 789, 234, 561, 890, 112, 345};
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("目前商品編號: [402, 105, 789, 234, 561, 890, 112, 345]");
        System.out.print("請輸入要搜尋的商品編號: ");
        int target = scanner.nextInt();
        
        int foundIndex = -1;
        int compareCount = 0;
        
        for (int i = 0; i < products.length; i++) {
            compareCount++;
            if (products[i] == target) {
                foundIndex = i;
                break;
            }
        }
        
        if (foundIndex != -1) {
            System.out.println("【結果】找到商品！索引位置為: " + foundIndex);
        } else {
            System.out.println("【結果】很抱歉，找不到該商品編號。");
        }
        System.out.println("實際比較次數: " + compareCount + " 次");
        
        System.out.println("\n[提示] 請自行測試邊界案例：");
        System.out.println("1. 第一筆 (402)  2. 最後一筆 (345)  3. 不存在 (999)");
        scanner.close();
    }
}