import java.util.ArrayList;

public class BookAlgorithms {
    // 依編號升冪排序 (Merge Sort)
    public static void sortByIdAsc(Book[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sortByIdAsc(arr, left, mid);
        sortByIdAsc(arr, mid + 1, right);
        mergeId(arr, left, mid, right);
    }

    private static void mergeId(Book[] arr, int left, int mid, int right) {
        Book[] temp = new Book[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i].getId().compareTo(arr[j].getId()) <= 0) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int m = 0; m < temp.length; m++) arr[left + m] = temp[m];
    }

    // 依借閱次數降冪排序 (Merge Sort)
    public static void sortByBorrowCountDesc(Book[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sortByBorrowCountDesc(arr, left, mid);
        sortByBorrowCountDesc(arr, mid + 1, right);
        mergeCount(arr, left, mid, right);
    }

    private static void mergeCount(Book[] arr, int left, int mid, int right) {
        Book[] temp = new Book[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i].getBorrowCount() >= arr[j].getBorrowCount()) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int m = 0; m < temp.length; m++) arr[left + m] = temp[m];
    }

    // Binary Search 依編號查詢 (必須已進行編號升冪排序)
    public static int binarySearchById(Book[] arr, String targetId) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = arr[mid].getId().compareTo(targetId);
            if (comp == 0) return mid;
            else if (comp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Sequential Search 依分類找出全部書籍 (分類未完全排序或包含重複多筆結果)
    public static ArrayList<Book> sequentialSearchByCategory(ArrayList<Book> list, String category) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book b : list) {
            if (b.getCategory().equalsIgnoreCase(category)) {
                res.add(b);
            }
        }
        return res;
    }
}