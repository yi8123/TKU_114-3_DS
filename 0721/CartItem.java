public class CartItem {

    private String code;
    private String name;
    private int price;
    private int quantity;


    // 建構子
    public CartItem(String code, String name, int price, int quantity) {

        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }


    // Getter

    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }



    // 增加數量
    public void addQuantity(int quantity) {

        this.quantity += quantity;

    }



    // 修改數量
    public void setQuantity(int quantity) {

        this.quantity = quantity;

    }



    // 計算小計
    public int getSubtotal() {

        return price * quantity;

    }



    @Override
    public String toString() {

        return "代碼：" + code +
                "　名稱：" + name +
                "　單價：" + price +
                "　數量：" + quantity +
                "　小計：" + getSubtotal();

    }
}