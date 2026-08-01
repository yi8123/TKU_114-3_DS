import java.util.ArrayList;

public class RegistrationAlgorithms {
    // 依編號升冪排序 (Merge Sort)
    public static void sortByIdAsc(Registration[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sortByIdAsc(arr, left, mid);
        sortByIdAsc(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Registration[] arr, int left, int mid, int right) {
        Registration[] temp = new Registration[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i].getId() <= arr[j].getId()) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int m = 0; m < temp.length; m++) arr[left + m] = temp[m];
    }

    // Binary Search 依編號查詢 (須提供已排好序的陣列)
    public static int binarySearchById(Registration[] arr, int targetId) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].getId() == targetId) return mid;
            else if (arr[mid].getId() < targetId) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Sequential Search 依姓名查詢 (支援未排序且姓名可能相同的情境)
    public static ArrayList<Registration> sequentialSearchByName(ArrayList<Registration> list, String name) {
        ArrayList<Registration> result = new ArrayList<>();
        for (Registration r : list) {
            if (r.getName().equalsIgnoreCase(name)) {
                result.add(r);
            }
        }
        return result;
    }
}