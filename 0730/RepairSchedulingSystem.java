import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RepairSchedulingSystem {
    // 系統定義之主資料庫 (完整資料)
    private ArrayList<RepairTask> allTasks = new ArrayList<>();
    // 等待維修 Queue
    private Queue<RepairTask> waitQueue = new LinkedList<>();
    // 已完成工作 Stack
    private Stack<RepairTask> finishedStack = new Stack<>();

    public void addTask(RepairTask task) {
        allTasks.add(task);
        waitQueue.offer(task);
    }

    // 重新排序排程等待佇列中的工作
    public void rescheduleQueue() {
        RepairTask[] arr = waitQueue.toArray(new RepairTask[0]);
        RepairAlgorithms.sortByPriorityDesc(arr, 0, arr.length - 1);
        waitQueue.clear();
        for (RepairTask t : arr) {
            waitQueue.offer(t);
        }
        System.out.println("等待佇列已依優先級重排完畢。");
    }

    public void executeTask() {
        if (waitQueue.isEmpty()) {
            System.out.println("無等待維修之工作。");
            return;
        }
        RepairTask task = waitQueue.poll();
        finishedStack.push(task);
        System.out.println("執行維修完成: " + task);
    }

    // 支援復原流程：從完成區回復至等待佇列最前端
    public void undoFinishedTask() {
        if (finishedStack.isEmpty()) {
            System.out.println("已完成區域無任何紀錄，無法復原。");
            return;
        }
        RepairTask undoneTask = finishedStack.pop();
        
        // 為了將其推回排程最前面，重建 Queue 的順序
        Queue<RepairTask> newQueue = new LinkedList<>();
        newQueue.offer(undoneTask); // 復原的資料放在最優先處理順序
        while (!waitQueue.isEmpty()) {
            newQueue.offer(waitQueue.poll());
        }
        waitQueue = newQueue;
        System.out.println("已成功復原工作，重回佇列前端: " + undoneTask);
    }

    public void displayStatistics() {
        System.out.println("---- 系統即時維修統計 ----");
        System.out.println("  [全部登記總數]: " + allTasks.size());
        System.out.println("  [等待佇列數量]: " + waitQueue.size());
        System.out.println("  [已完成棧數量]: " + finishedStack.size());
    }

    public static void main(String[] args) {
        RepairSchedulingSystem system = new RepairSchedulingSystem();
        
        // 建立資料，測試同等級工作是否維持登記順序
        system.addTask(new RepairTask("R01", "伺服器A", 3));
        system.addTask(new RepairTask("R02", "印表機B", 1));
        system.addTask(new RepairTask("R03", "伺服器B", 3)); // 與 R01 優先級相同
        system.addTask(new RepairTask("R04", "發電機C", 5));

        System.out.println("=== 進行排序排程前 ===");
        system.displayStatistics();

        system.rescheduleQueue();
        
        System.out.println("\n=== 開始執行工作 ===");
        system.executeTask(); // 應為最高優先級 R04
        system.executeTask(); // 應為同級且先到的 R01

        System.out.println("\n=== 執行復原操作 ===");
        system.undoFinishedTask(); // 復原 R01
        
        System.out.println("\n=== 最終統計狀態 ===");
        system.displayStatistics();
    }
}