public class PricePrinter {
    public static void main(String[] args) {
        printItem("Apple", 30);
        printItem("Banana", 15);
        printItem("Coffee", 50);
    }

    public static void printItem(String itemName, int price){
        System.out.println("Item: " + itemName + ", Price: " + price);
    }
}
