import java.util.ArrayList;
import java.util.List;

public class AllOccurrenceSearch {
    public static void searchAll(int[] arr, int target) {
        List<Integer> indices = new ArrayList<>();
        int compareCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            compareCount++;
            if (arr[i] == target) {
                indices.add(i);
            }
        }
        
        System.out.println("搜尋目標: " + target);
        System.out.println("實際總比較次數: " + compareCount + " 次");
        
        if (!indices.isEmpty()) {
            System.out.println("找到資料！所有符合的索引位置為: " + indices);
            System.out.println("總共出現次數: " + indices.size() + " 次");
        } else {
            System.out.println("【訊息】很抱歉，在陣列中找不到該數值。");
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        int[] data = {12, 45, 78, 45, 90, 45, 23, 11};
        System.out.println("測試陣列: [12, 45, 78, 45, 90, 45, 23, 11]\n");
        
        searchAll(data, 45);
        searchAll(data, 78);
        searchAll(data, 99);
    }
}