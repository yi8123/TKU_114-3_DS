import java.util.ArrayList;

public class OrderAlgorithms {
    // 依金額降冪的 Merge Sort
    public static void mergeSortByAmountDesc(Order[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByAmountDesc(arr, left, mid);
        mergeSortByAmountDesc(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Order[] arr, int left, int mid, int right) {
        Order[] temp = new Order[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            // 降冪排序：金額大者放前面
            if (arr[i].getAmount() >= arr[j].getAmount()) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int m = 0; m < temp.length; m++) arr[left + m] = temp[m];
    }

    // 依顧客姓名搜尋全部訂單 (Sequential Search，因為姓名未排序且可能有多筆)
    public static ArrayList<Order> searchByCustomerName(ArrayList<Order> list, String name) {
        ArrayList<Order> result = new ArrayList<>();
        for (Order o : list) {
            if (o.getCustomerName().equalsIgnoreCase(name)) {
                result.add(o);
            }
        }
        return result;
    }
}