public class ProductSortingSystem {
    public static void main(String[] args) {
        // 建立 10 筆原始商品資料
        StoreProduct[] originalData = {
            new StoreProduct("S01", "可樂", 25.0, 100),
            new StoreProduct("S02", "洋芋片", 45.0, 50),
            new StoreProduct("S03", "泡麵", 35.0, 80),
            new StoreProduct("S04", "鮮奶", 95.0, 12),
            new StoreProduct("S05", "巧克力", 55.0, 40),
            new StoreProduct("S06", "微波便當", 89.0, 15),
            new StoreProduct("S07", "礦泉水", 20.0, 200),
            new StoreProduct("S08", "冰淇淋", 65.0, 30),
            new StoreProduct("S09", "軟糖", 30.0, 85),
            new StoreProduct("S10", "咖啡", 70.0, 25)
        };

        // 模式 1: 價格升冪 (使用 Insertion Sort 示範)
        System.out.println("\n--- [排序欄位: 價格 / 排序方向: 升冪] ---");
        StoreProduct[] mode1Data = originalData.clone(); // 從原始資料複製一份
        sortByPriceAsc(mode1Data);
        printProducts(mode1Data);

        // 模式 2: 價格降冪 (使用 Selection Sort 示範)
        System.out.println("\n--- [排序欄位: 價格 / 排序方向: 降冪] ---");
        StoreProduct[] mode2Data = originalData.clone();
        sortByPriceDesc(mode2Data);
        printProducts(mode2Data);

        // 模式 3: 庫存降冪 (使用 Insertion Sort 示範)
        System.out.println("\n--- [排序欄位: 庫存 / 排序方向: 降冪] ---");
        StoreProduct[] mode3Data = originalData.clone();
        sortByStockDesc(mode3Data);
        printProducts(mode3Data);
    }

    // 價格升冪 (Insertion Sort)
    public static void sortByPriceAsc(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrice() > key.getPrice()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 價格降冪 (Selection Sort)
    public static void sortByPriceDesc(StoreProduct[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getPrice() > arr[maxIdx].getPrice()) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                StoreProduct temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }
    }

    // 庫存降冪 (Insertion Sort)
    public static void sortByStockDesc(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getStock() < key.getStock()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printProducts(StoreProduct[] arr) {
        for (StoreProduct p : arr) {
            System.out.println(p);
        }
    }
}