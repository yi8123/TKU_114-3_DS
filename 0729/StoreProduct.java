public class StoreProduct {
    private String id;
    private String name;
    private double price;
    private int stock;

    public StoreProduct(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public double getPrice() { return price; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return String.format("編號: %s | 名稱: %-8s | 價格: %6.1f | 庫存: %3d", id, name, price, stock);
    }
}