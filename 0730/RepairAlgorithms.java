public class RepairAlgorithms {
    // 依優先等級降冪排序，相同優先等即時維持原有順序 (Merge Sort 具備穩定性)
    public static void sortByPriorityDesc(RepairTask[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sortByPriorityDesc(arr, left, mid);
        sortByPriorityDesc(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(RepairTask[] arr, int left, int mid, int right) {
        RepairTask[] temp = new RepairTask[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            // 加上等號條件，當優先等級相同時，先取左側區間的元素，以維持「穩定排序」
            if (arr[i].getPriority() >= arr[j].getPriority()) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int m = 0; m < temp.length; m++) arr[left + m] = temp[m];
    }
}