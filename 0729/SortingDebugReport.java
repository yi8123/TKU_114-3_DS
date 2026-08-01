import java.util.Arrays;

public class SortingDebugReport {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" 錯誤版本一演示：Selection Sort 內層範圍錯誤");
        System.out.println("==================================================");
        int[] testData1 = {5, 2, 9, 1};
        System.out.println("原始資料: " + Arrays.toString(testData1));
        System.out.println("錯誤版輸出: " + Arrays.toString(buggySelectionSort(testData1.clone())));
        System.out.println("修正版輸出: " + Arrays.toString(fixedSelectionSort(testData1.clone())));

        System.out.println("\n==================================================");
        System.out.println(" 錯誤版本二演示：Insertion Sort key 未保存被覆蓋");
        System.out.println("==================================================");
        int[] testData2 = {3, 1, 4, 2};
        System.out.println("原始資料: " + Arrays.toString(testData2));
        System.out.println("錯誤版輸出: " + Arrays.toString(buggyInsertionSortNoKey(testData2.clone())));
        System.out.println("修正版輸出: " + Arrays.toString(fixedInsertionSort(testData2.clone())));

        System.out.println("\n==================================================");
        System.out.println(" 錯誤版本三演示：排序比較方向錯誤 (誤將升冪寫成降冪)");
        System.out.println("==================================================");
        int[] testData3 = {10, 30, 20, 40};
        System.out.println("原始資料: " + Arrays.toString(testData3));
        System.out.println("錯誤版輸出: " + Arrays.toString(buggySelectionSortDirection(testData3.clone())));
        System.out.println("修正版輸出: " + Arrays.toString(fixedSelectionSort(testData3.clone())));
    }

    /* =========================================================================
     * 錯誤版本一：Selection Sort 內層範圍錯誤
     * 原因說明：內層迴圈的 j 仍從 0 開始 (j = 0)，導致它重複去掃描左側已經排序好的區域。
     *          這樣會重新抓到全陣列最小的值並不斷移到前面，整個排序結構會被徹底破壞。
     * ========================================================================= */
    public static int[] buggySelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            // 錯誤點：應為 int j = i + 1
            for (int j = 0; j < n; j++) { 
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        return arr;
    }

    // 修正版本一與三的基準函式
    public static int[] fixedSelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) { // 升冪正確比較
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
        return arr;
    }

    /* =========================================================================
     * 錯誤版本二：Insertion Sort key 未保存
     * 原因說明：沒有先開立獨立變數保存當前的 arr[i]，在右移過程中 (arr[j+1] = arr[j])，
     *          原本 arr[i] 的資料直接被覆蓋不見了。最後塞回來的 arr[j+1] 是已經被污染的錯誤資料。
     * ========================================================================= */
    public static int[] buggyInsertionSortNoKey(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 錯誤點：沒有保存 key = arr[i]
            int j = i - 1;
            // 錯誤點：直接使用了會動態被覆蓋的 arr[i] 進行比對
            while (j >= 0 && arr[j] > arr[i]) { 
                arr[j + 1] = arr[j];
                j--;
            }
            // 錯誤點：此時真正的資料遺失了，寫回來的不是原先的資料
            arr[j + 1] = arr[i]; 
        }
        return arr;
    }

    // 修正版本二的基準函式
    public static int[] fixedInsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // 修正：確實保存
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // 修正：將 key 塞回
        }
        return arr;
    }

    /* =========================================================================
     * 錯誤版本三：比較方向錯誤
     * 原因說明：題目預期要求升冪排序（由小到大），但在內層判斷式中誤寫成了 arr[j] > arr[maxIdx]，
     *          導致實際上做出來的是降冪排序（由大到小），不符合要求標準。
     * ========================================================================= */
    public static int[] buggySelectionSortDirection(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                // 錯誤點：寫成大於 (>) 變成了降冪搜尋
                if (arr[j] > arr[minIdx]) { 
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        return arr;
    }
}
