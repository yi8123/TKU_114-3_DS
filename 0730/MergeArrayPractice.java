import java.util.Arrays;

public class MergeArrayPractice {
    public static void main(String[] args) {
        System.out.println("=== 測試標準不同長度排序陣列 ===");
        int[] arr1 = {-5, 2, 8, 8, 12};
        int[] arr2 = {-2, 0, 3, 8, 15, 20};
        int[] res1 = merge(arr1, arr2);
        System.out.println("陣列 1: " + Arrays.toString(arr1));
        System.out.println("陣列 2: " + Arrays.toString(arr2));
        System.out.println("合併結果: " + Arrays.toString(res1));

        System.out.println("\n=== 測試其中一個陣列為空 ===");
        int[] arr3 = {};
        int[] arr4 = {-1, 4, 9};
        System.out.println("合併結果: " + Arrays.toString(merge(arr3, arr4)));

        System.out.println("\n=== 測試兩個陣列皆為空 ===");
        System.out.println("合併結果: " + Arrays.toString(merge(new int[]{}, new int[]{})));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // 使用三個索引進行合併
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) { // 加上等號以維持穩定性
                temp[k++] = arr1[i++];
            } else {
                temp[k++] = arr2[j++];
            }
        }

        // 正確處理左邊剩餘元素
        while (i < arr1.length) {
            temp[k++] = arr1[i++];
        }

        // 正確處理右邊剩餘元素
        while (j < arr2.length) {
            temp[k++] = arr2[j++];
        }

        // 去除重複值：題目要求所有輸入元素「只出現一次」
        if (temp.length == 0) return new int[0];
        
        int uniqueCount = 1;
        for (int m = 1; m < temp.length; m++) {
            if (temp[m] != temp[m - 1]) {
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        result[0] = temp[0];
        int idx = 1;
        for (int m = 1; m < temp.length; m++) {
            if (temp[m] != temp[m - 1]) {
                result[idx++] = temp[m];
            }
        }
        return result;
    }
}