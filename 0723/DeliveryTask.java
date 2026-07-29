public class DeliveryTask {
    private String taskId;
    private String address;

    public DeliveryTask(String taskId, String address) {
        this.taskId = taskId;
        this.address = address;
    }

    public String getTaskId() { return taskId; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "任務編號: " + taskId + ", 配送地址: " + address;
    }
}