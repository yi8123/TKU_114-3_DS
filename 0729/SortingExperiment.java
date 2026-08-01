public class SortingExperiment {
    public static void main(String[] args) {
        // 準備三組相同元素但排列不同的原始輸入
        int[] originalSorted    = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] originalReversed  = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] originalRandom    = {4, 7, 1, 9, 2, 8, 5, 3, 10, 6};

        System.out.println("========== Selection Sort 實驗結果 ==========");
        runSelectionSort("已排序資料", originalSorted.clone());
        runSelectionSort("反向排序資料", originalReversed.clone());
        runSelectionSort("隨機排列資料", originalRandom.clone());

        System.out.println("\n========== Insertion Sort 實驗結果 ==========");
        runInsertionSort("已排序資料", originalSorted.clone());
        runInsertionSort("反向排序資料", originalReversed.clone());
        runInsertionSort("隨機排列資料", originalRandom.clone());

        System.out.println("\n========== 實驗觀察結論 ==========");
        System.out.println("1. Selection Sort 結論：");
        System.out.println("   - 無論資料初始狀態為何，【比較次數】皆固定為 N*(N-1)/2 = 45 次。因為它一定要掃描完未排序區。");
        System.out.println("   - 【交換次數】受初始狀態影響。已排序時為 0 次，反向或隨機時則視情況發生實際交換（最多 N-1 次）。");
        System.out.println("2. Insertion Sort 結論：");
        System.out.println("   - 在【已排序】最佳狀態下，比較次數僅需 N-1 = 9 次，且完全不需要移動元素（0次），效能極高。");
        System.out.println("   - 在【反向排序】最差狀態下，比較次數與移動次數皆暴增。移動次數達 45 次。");
        System.out.println("3. 綜合對比：");
        System.out.println("   - 對於幾乎已排序的資料，Insertion Sort 遠比 Selection Sort 優秀。");
        System.out.println("   - Selection Sort 的優勢在於交換次數的上限是 O(N)，而 Insertion Sort 在最差情況下元素右移次數會達到 O(N^2)。");
    }

    public static void runSelectionSort(String label, int[] arr) {
        int compares = 0;
        int swaps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                compares++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
                swaps++;
            }
        }
        System.out.printf("[%s] -> 比較次數: %2d, 交換次數: %2d\n", label, compares, swaps);
    }

    public static void runInsertionSort(String label, int[] arr) {
        int compares = 0;
        int shifts = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                compares++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        System.out.printf("[%s] -> 比較次數: %2d, 移動次數(右移): %2d\n", label, compares, shifts);
    }
}