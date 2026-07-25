public class TaskLinkedList {
    private TaskNode head = null;

    // 緊急工作加到前端
    public void addUrgent(String taskCode, String description) {
        TaskNode newNode = new TaskNode(taskCode, description);
        newNode.next = head;
        head = newNode;
        System.out.println("已加入緊急工作: " + description);
    }

    // 一般工作加到尾端
    public void addGeneral(String taskCode, String description) {
        TaskNode newNode = new TaskNode(taskCode, description);
        if (head == null) {
            head = newNode;
            System.out.println("已加入一般工作 (首項): " + description);
            return;
        }
        TaskNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println(" 已加入一般工作: " + description);
    }

    // 支援完成工作（變更狀態）
    public void completeTask(String taskCode) {
        TaskNode current = head;
        while (current != null) {
            if (current.taskCode.equals(taskCode)) {
                current.isCompleted = true;
                System.out.println("工作項目 [" + taskCode + "] 已標記為完成！");
                return;
            }
            current = current.next;
        }
        System.out.println("找不到工作代碼 [" + taskCode + "]，無法完成。");
    }

    // 支援刪除工作
    public void deleteTask(String taskCode) {
        if (head == null) {
            System.out.println("無任何工作，無法刪除。");
            return;
        }
        if (head.taskCode.equals(taskCode)) {
            System.out.println("已刪除工作: " + head.description);
            head = head.next;
            return;
        }
        TaskNode current = head;
        TaskNode prev = null;
        while (current != null && !current.taskCode.equals(taskCode)) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("找不到工作代碼 [" + taskCode + "]，無法刪除。");
            return;
        }
        prev.next = current.next;
        System.out.println("已刪除工作: " + current.description);
    }

    // 列出未完成工作，並輸出工作總數與未完成數量
    public void listStatus() {
        int totalCount = 0;
        int uncompletedCount = 0;

        System.out.println("\n===== 工作項目系統狀態 =====");
        if (head == null) {
            System.out.println("目前無任何工作項目。");
            System.out.println("工作總數: 0, 未完成數量: 0");
            return;
        }

        TaskNode current = head;
        System.out.println("【未完成工作清單】:");
        while (current != null) {
            totalCount++;
            if (!current.isCompleted) {
                uncompletedCount++;
                System.out.println("- [" + current.taskCode + "] " + current.description);
            }
            current = current.next;
        }
        
        if (uncompletedCount == 0) {
            System.out.println("(暫無未完成的工作！)");
        }
        
        System.out.println("--------------------------");
        System.out.println("工作總數: " + totalCount + ", 未完成數量: " + uncompletedCount);
        System.out.println("==========================");
    }
}