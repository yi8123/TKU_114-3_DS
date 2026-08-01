import java.util.Arrays;

public class InsertionSortPractice {
    public static void main(String[] args) {
        System.out.println("=== 1. 測試標準隨機資料 ===");
        int[] arr1 = {30, 10, 20, 50, 40, 5};
        insertionSortTrack(arr1);

        System.out.println("\n=== 2. 測試已排序資料 ===");
        int[] arr2 = {5, 10, 20, 30, 40, 50};
        insertionSortTrack(arr2);

        System.out.println("\n=== 3. 測試反向排序資料 ===");
        int[] arr3 = {50, 40, 30, 20, 10, 5};
        insertionSortTrack(arr3);
        
        System.out.println("\n=== 移動次數最多之資料組說明 ===");
        System.out.println("「反向排序資料」的移動次數最多。");
        System.out.println("原因：在 Insertion Sort 中，當資料完全反序時，每一個新加入的 key 都比左側已排序區的所有元素還要小。");
        System.out.println("這導致內層迴圈必須一路比對到索引 0，並讓前面所有的元素都向右移動一格，因而達到最大移動與比較次數。");
    }

    public static void insertionSortTrack(int[] source) {
        int[] arr = source.clone();
        int compareCount = 0;
        int shiftCount = 0;
        int n = arr.length;

        System.out.println("原始陣列: " + Arrays.toString(arr));

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                compareCount++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    shiftCount++;
                    j--;
                } else {
                    break;
                }
            }
            
            arr[j + 1] = key;
            System.out.printf("輪次 %d -> key: %d, 插入位置: %d, 陣列內容: %s\n", 
                              i, key, (j + 1), Arrays.toString(arr));
        }
        System.out.println("統計 -> 資料比較次數: " + compareCount + ", 元素右移次數: " + shiftCount);
    }
}