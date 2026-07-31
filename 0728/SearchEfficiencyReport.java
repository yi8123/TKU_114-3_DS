public class SearchEfficiencyReport {

    public static int sequentialSearchCount(int[] arr, int target) {
        int compares = 0;
        for (int i = 0; i < arr.length; i++) {
            compares++;
            if (arr[i] == target) break;
        }
        return compares;
    }

    public static int binarySearchCount(int[] arr, int target) {
        int compares = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            compares++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                break;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return compares;
    }

    public static void runTest(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i * 2;
        int first = arr[0];
        int last = arr[size - 1];
        int notExist = -99;

        System.out.println("=====================================");
        System.out.printf(" 資料量規模: %d 筆\n", size);
        System.out.println("=====================================");
        System.out.printf("%-12s | %-15s | %-15s\n", "測試情境", "循序搜尋比較次數", "二分搜尋比較次數");
        System.out.println("-------------------------------------");
        System.out.printf("%-12s | %-18d | %-18d\n", "第一筆資料", sequentialSearchCount(arr, first), binarySearchCount(arr, first));
        System.out.printf("%-12s | %-18d | %-18d\n", "最後一筆資料", sequentialSearchCount(arr, last), binarySearchCount(arr, last));
        System.out.printf("%-12s | %-18d | %-18d\n", "不存在資料", sequentialSearchCount(arr, notExist), binarySearchCount(arr, notExist));
        System.out.println();
    }

    public static void main(String[] args) {
        runTest(16);
        runTest(128);
        runTest(1024);

        System.out.println("【程式輸出結論與觀察報告】");
        System.out.println("1. 循序搜尋 (Sequential Search) 的時間複雜度為 O(n)。 當資料量由 16 暴增到 1024 時，");
        System.out.println("   搜尋最後一筆或不存在資料的比較次數成線性放大（達 1024 次）。然而，若目標在第一筆，只需 1 次即可找到。");
        System.out.println("2. 二分搜尋 (Binary Search) 的時間複雜度為 O(log n)。 面對 1024 筆資料的最差情況下，");
        System.out.println("   也僅需約 10-11 次比較。資料量擴大 64 倍（16 -> 1024），其比較次數僅微幅增加幾次。");
        System.out.println("3. 結論：二分搜尋在處理海量且已排序的資料時，效能展現出絕對優勢；而循序搜尋只適用於未排序或極小規模的資料集。");
    }
}