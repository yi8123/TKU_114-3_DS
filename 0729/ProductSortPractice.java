public class ProductSortPractice {
        public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "MacBook", 35000.0, 10),
            new Product("P002", "iPhone", 25000.0, 20),
            new Product("P003", "滑鼠 A", 250.0, 50),
            new Product("P004", "鍵盤", 1200.0, 15),
            new Product("P005", "滑鼠 B", 250.0, 30),
            new Product("P006", "耳機", 1800.0, 8),
            new Product("P007", "滑鼠 C", 250.0, 45),
            new Product("P008", "行動電源", 800.0, 10)
        };

        System.out.println("=== 排序前 ===");
        for (Product p : products) {
            System.out.println(p);
        }

        int n = products.length;
        for (int i = 1; i < n; i++) {
            Product key = products[i];
            int j = i - 1;
            
            while (j >= 0 && products[j].getPrice() > key.getPrice()) {
                products[j + 1] = products[j];
                j--;
            }
            products[j + 1] = key;
        }

        System.out.println("\n=== 排序後 (依價格升冪，同價者應保持 A -> B -> C 順序) ===");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}