public class Equipment {

    private String code;
    private String name;
    private boolean available;

    // 建構子
    public Equipment(String code, String name) {
        this.code = code;
        this.name = name;
        this.available = true;
    }

    // Getter
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // 顯示設備資訊
    @Override
    public String toString() {
        return "代碼：" + code +
               "　名稱：" + name +
               "　狀態：" + (available ? "可借用" : "已借出");
    }
}