import java.util.Arrays;

public class MergeSortPractice {
    public static void main(String[] args) {
        System.out.println("=== 1. 測試標準隨機資料 ===");
        int[] arr = {41, 12, 35, 8, 27, 19, 50, 3};
        System.out.println("原始陣列: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("排序結果: " + Arrays.toString(arr));

        System.out.println("\n=== 2. 測試空陣列 ===");
        int[] empty = {};
        mergeSort(empty, 0, empty.length - 1);

        System.out.println("\n=== 3. 測試單一元素 ===");
        int[] single = {99};
        mergeSort(single, 0, single.length - 1);
        System.out.println("排序結果: " + Arrays.toString(single));

        System.out.println("\n=== 4. 測試已排序資料 ===");
        int[] sorted = {1, 2, 3, 4};
        mergeSort(sorted, 0, sorted.length - 1);
        System.out.println("排序結果: " + Arrays.toString(sorted));

        System.out.println("\n=== 5. 測試反向資料 ===");
        int[] reversed = {4, 3, 2, 1};
        mergeSort(reversed, 0, reversed.length - 1);
        System.out.println("排序結果: " + Arrays.toString(reversed));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        // 停止條件：當區間長度小於等於 1 時停止
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        
        // 顯示拆分範圍
        System.out.printf("拆分區間 -> [%d, %d] 分為 [%d, %d] 與 [%d, %d]\n", left, right, left, mid, mid + 1, right);
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) { // 使用 <= 以確保排序穩定度
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 將暫存陣列複製回原陣列，使用正確的偏移量 left
        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = temp[m];
        }

        // 顯示合併後的區間內容
        int[] currentSection = Arrays.copyOfRange(arr, left, right + 1);
        System.out.printf("  合併完成 -> 區間 [%d, %d] 內容: %s\n", left, right, Arrays.toString(currentSection));
    }
}