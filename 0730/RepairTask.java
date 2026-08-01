public class RepairTask {
    private String taskId;
    private String deviceName;
    private int priority; // 數字愈大代表優先等級愈高

    public RepairTask(String taskId, String deviceName, int priority) {
        this.taskId = taskId;
        this.deviceName = deviceName;
        this.priority = priority;
    }

    public String getTaskId() { return taskId; }
    public String getDeviceName() { return deviceName; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return String.format("工作編號: %s | 設備: %-8s | 優先級: %d", taskId, deviceName, priority);
    }
}