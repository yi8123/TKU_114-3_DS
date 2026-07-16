public class Q11_LabDevice {
    private String code;
    private String name;
    private int usageHours;
    private boolean active;

    public Q11_LabDevice(String code, String name, int usageHours, boolean active) {
        // 1. code 為 null 或移除前後空白後為空字串，儲存為 UNKNOWN
        if (code == null || code.trim().isEmpty()) {
            this.code = "UNKNOWN";
        } else {
            this.code = code.trim();
        }
        
        // 2. name 為 null 或移除前後空白後為空字串，儲存為 Unnamed
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unnamed";
        } else {
            this.name = name.trim();
        }
        
        // 3. usageHours 小於 0 儲存為 0
        this.usageHours = Math.max(0, usageHours);
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getUsageHours() {
        return usageHours;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        // 只接受非 null 且非空白的名稱；輸入不合法時保留原名稱
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public void addUsageHours(int hours) {
        // 只接受大於 0 的時數
        if (hours > 0) {
            this.usageHours += hours;
        }
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean needsMaintenance() {
        return this.usageHours >= 100;
    }

    @Override
    public String toString() {
        String status = active ? "active" : "inactive";
        return this.code + " | " + this.name + " | " + this.usageHours + " hours | " + status;
    }

    public static void main(String[] args) {
        Q11_LabDevice device = new Q11_LabDevice("D01", " Printer ", 90, true);
        device.addUsageHours(30);
        device.addUsageHours(-5);
        device.setName(" 3D Printer ");
        System.out.println(device);
        System.out.println("需要保養:" + device.needsMaintenance());
        device.deactivate();
        System.out.println("啟用狀態:" + device.isActive());
    }
}