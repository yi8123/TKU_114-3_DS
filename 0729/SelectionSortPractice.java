import java.util.Arrays;

public class SelectionSortPractice {
    public static void main(String[] args) {
        System.out.println("--- 測試標準陣列 ---");
        int[] arr = {42, 18, 35, 7, 29, 14};
        selectionSortTrack(arr);

        System.out.println("\n--- 測試空陣列 ---");
        selectionSortTrack(new int[]{});

        System.out.println("\n--- 測試單一元素陣列 ---");
        selectionSortTrack(new int[]{99});
    }

    public static void selectionSortTrack(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("陣列為空，無需排序。比較次數 : 0, 交換次數 : 0");
            return;
        }
        if (arr.length == 1) {
            System.out.println("陣列僅有單一元素 " + Arrays.toString(arr) + "，無需排序。比較次數 : 0, 交換次數 : 0");
            return;
        }

        int compareCount = 0;
        int swapCount = 0;
        int n = arr.length;

        System.out.println("原始陣列 : " + Arrays.toString(arr));

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                compareCount++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            System.out.printf("輪次 %d -> start: %d, 選中的最小元素索引 : %d, ", i + 1, i, minIndex);

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swapCount++;
            }
            System.out.println("陣列內容 : " + Arrays.toString(arr));
        }

        System.out.println("排序完成！總比較次數 : " + compareCount + ", 總實際交換次數 : " + swapCount);
    }
}