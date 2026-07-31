import java.util.Scanner;

public class SeatNumberSearchPractice {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int round = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.printf("第 %d 輪 -> low: %d, mid: %d, high: %d\n", round++, low, mid, high);
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] seats = {101, 105, 110, 112, 115, 120, 125, 130, 132, 140, 145, 150};
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("已排序座位: [101, 105, 110, 112, 115, 120, 125, 130, 132, 140, 145, 150]");
        System.out.print("請輸入要搜尋的座位編號: ");
        int target = scanner.nextInt();
        
        int result = binarySearch(seats, target);
        
        if (result != -1) {
            System.out.println("【結果】搜尋成功！座位索引為: " + result);
        } else {
            System.out.println("【結果】該座位編號不存在。");
        }
        
        System.out.println("\n[提示] 請依要求測試邊界：第一筆(101)、最後一筆(150)、中間(120 或 125)、不存在(999)");
        scanner.close();
    }
}