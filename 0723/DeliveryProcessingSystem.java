import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DeliveryProcessingSystem {
    private Queue<DeliveryTask> taskQueue = new LinkedList<>();
    private Stack<DeliveryTask> completedStack = new Stack<>();
    private List<String> allLogs = new ArrayList<>();

    public void addTask(String taskId, String address) {
        DeliveryTask task = new DeliveryTask(taskId, address);
        taskQueue.offer(task);
        allLogs.add("新增配送任務: " + taskId);
        System.out.println("已指派新任務 -> " + task);
    }

    public void completeNext() {
        if (taskQueue.isEmpty()) {
            System.out.println("【提示】目前沒有等待配送的工作。");
            return;
        }
        DeliveryTask task = taskQueue.poll();
        completedStack.push(task);
        allLogs.add("完成配送任務: " + task.getTaskId());
        System.out.println("【完成】" + task.getTaskId() + " 已順利送達。");
    }

    public void peekNext() {
        if (taskQueue.isEmpty()) {
            System.out.println("目前待配送清單為空。");
        } else {
            System.out.println("下一筆待處理任務: " + taskQueue.peek());
        }
    }

    public void undoLastComplete() {
        if (completedStack.isEmpty()) {
            System.out.println("【提示】沒有任何已完成的任務可以復原！");
            return;
        }
        DeliveryTask standardTask = completedStack.pop();
        taskQueue.offer(standardTask);
        allLogs.add("復原任務: " + standardTask.getTaskId() + " 至等待佇列尾端");
        System.out.println("【復原成功】任務 " + standardTask.getTaskId() + " 已重回等待佇列尾端。");
    }

    
    public void printSummary() {
        System.out.println("\n--- 配送系統即時摘要 ---");
        System.out.println("等待中任務數: " + taskQueue.size());
        System.out.println("已完成任務數: " + completedStack.size());
        System.out.println("歷史系統操作處理紀錄:");
        for (String log : allLogs) {
            System.out.println("  " + log);
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        DeliveryProcessingSystem sys = new DeliveryProcessingSystem();

        sys.addTask("TASK-001", "新北市三重區...");
        sys.addTask("TASK-002", "台北市大安區...");
        sys.addTask("TASK-003", "新北市板橋區...");

        sys.peekNext();
        sys.completeNext();
        sys.completeNext();

        sys.undoLastComplete();

        sys.printSummary();
    }
}