import java.util.Arrays;

public class InventorySearchPractice {
    public static void main(String[] args) {
        // 建立 12 筆未排序庫存編號
        int[] inventoryIds = {1012, 1005, 1001, 1009, 1011, 1003, 1007, 1002, 1008, 1006, 1010, 1004};
        
        System.out.println("排序前庫存編號: " + Arrays.toString(inventoryIds));
        
        // 1. 使用 Merge Sort 依編號升冪排序
        mergeSort(inventoryIds, 0, inventoryIds.length - 1);
        System.out.println("排序後庫存編號: " + Arrays.toString(inventoryIds));

        // 2. 測試各種邊界案例的 Binary Search
        int[] targets = {1001, 1012, 1007, 9999}; // 第一筆、最後一筆、中間值、不存在的值
        for (int target : targets) {
            int index = binarySearch(inventoryIds, target);
            if (index != -1) {
                System.out.printf("搜尋編號 %d -> 找到，索引位置: %d (值為: %d)\n", target, index, inventoryIds[index]);
            } else {
                System.out.printf("搜尋編號 %d -> 找不到該品項\n", target);
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int m = 0; m < temp.length; m++) arr[left + m] = temp[m];
    }

    // Binary Search 實作
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid; // 找到目標，回傳索引
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // 找不到
    }
}