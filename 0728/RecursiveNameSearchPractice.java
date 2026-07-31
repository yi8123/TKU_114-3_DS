public class RecursiveNameSearchPractice {
    public static int search(String[] names, String target, int index) {
        if (names == null || index >= names.length) {
            return -1;
        }
        if (names[index] != null && names[index].equals(target)) {
            return index;
        }
        return search(names, target, index + 1);
    }

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
        
        System.out.println("--- 課堂實作四：遞迴版文字搜尋測試 ---");
        System.out.println("搜尋 'Alice' (第一筆): " + search(names, "Alice", 0));
        System.out.println("搜尋 'Eve' (最後一筆): " + search(names, "Eve", 0));
        System.out.println("搜尋 'Frank' (不存在): " + search(names, "Frank", 0));
        String[] emptyArray = {};
        System.out.println("搜尋 空陣列: " + search(emptyArray, "Alice", 0));
    }
}