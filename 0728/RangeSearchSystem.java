import java.util.Arrays;

public class RangeSearchSystem {

    public static int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void searchRange(int[] arr, int target) {
        int firstIndex = findFirst(arr, target);
        int lastIndex = findLast(arr, target);
        
        System.out.println("搜尋目標: " + target);
        if (firstIndex == -1) {
            System.out.println("回傳結果: " + Arrays.toString(new int[]{-1, -1}));
            System.out.println("該目標不存在於陣列中。");
        } else {
            System.out.println("回傳範圍: " + Arrays.toString(new int[]{firstIndex, lastIndex}));
            int count = lastIndex - firstIndex + 1;
            System.out.println("出現次數: " + count + " 次");
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 20, 20, 30, 30, 40, 50, 50, 60};
        System.out.println("排序陣列: [10, 20, 20, 20, 30, 30, 40, 50, 50, 60]\n");

        searchRange(data, 20);
        searchRange(data, 30);
        searchRange(data, 40);
        searchRange(data, 99);
    }
}