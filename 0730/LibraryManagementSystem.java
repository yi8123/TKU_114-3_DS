import java.util.ArrayList;

public class LibraryManagementSystem {
    private ArrayList<Book> mainLibrary = new ArrayList<>();

    public boolean registerBook(Book book) {
        for (Book b : mainLibrary) {
            if (b.getId().equalsIgnoreCase(book.getId())) {
                System.out.println("註冊失敗：書籍編號 " + book.getId() + " 已存在，不可重複。");
                return false;
            }
        }
        mainLibrary.add(book);
        return true;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        System.out.println("=== 測試案例：空資料處理 ===");
        ArrayList<Book> emptyRes = BookAlgorithms.sequentialSearchByCategory(library.mainLibrary, "文學");
        System.out.println("空圖書館搜尋結果數量: " + emptyRes.size());

        // 注入測試書籍
        library.registerBook(new Book("B005", "Java 進階題", "資訊", 120));
        library.registerBook(new Book("B001", "心理學導論", "科普", 45));
        library.registerBook(new Book("B003", "演算法奧秘", "資訊", 310));
        library.registerBook(new Book("B002", "歷史的軌跡", "人文", 15));
        library.registerBook(new Book("B001", "重複書本編號測試", "人文", 0)); // 重複邊界測試

        System.out.println("\n=== 測試案例：編號升冪 (Merge Sort) ===");
        Book[] arr = library.mainLibrary.toArray(new Book[0]);
        BookAlgorithms.sortByIdAsc(arr, 0, arr.length - 1);
        for(Book b : arr) System.out.println(b);

        System.out.println("\n=== 測試案例：Binary Search 依編號搜尋 ===");
        int idx = BookAlgorithms.binarySearchById(arr, "B003");
        System.out.println("搜尋 B003 結果: " + (idx != -1 ? arr[idx] : "找不到"));
        int idxFail = BookAlgorithms.binarySearchById(arr, "B999");
        System.out.println("搜尋 B999 (不存在) 結果: " + (idxFail != -1 ? arr[idxFail] : "找不到"));

        System.out.println("\n=== 測試案例：借閱次數降冪 (Merge Sort) ===");
        Book[] arr2 = library.mainLibrary.toArray(new Book[0]);
        BookAlgorithms.sortByBorrowCountDesc(arr2, 0, arr2.length - 1);
        for(Book b : arr2) System.out.println(b);

        System.out.println("\n=== 測試案例：Sequential Search 依分類搜尋 ===");
        ArrayList<Book> searchRes = BookAlgorithms.sequentialSearchByCategory(library.mainLibrary, "資訊");
        for(Book b : searchRes) System.out.println(b);
    }
}