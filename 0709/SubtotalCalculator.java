public class SubtotalCalculator {
    public static void main(String[] args) {
        int result = calculateSubtotal(80,6);
        System.out.println("Subtotal: " + result);
    }

    public static int calculateSubtotal(int price, int quantity) {
        int subtotal = price * quantity;
        return subtotal;
    }
}
