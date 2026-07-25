public class TaskLinkedListSystem {
    public static void main(String[] args) {
        TaskLinkedList system = new TaskLinkedList();

        // 1. 測試空狀態
        system.listStatus();

        // 2. 測試新增一般與緊急工作
        system.addGeneral("T001", "撰寫資料結構報告");
        system.addGeneral("T002", "預習下週 Java 課程");
        system.addUrgent("T003", "修復伺服器重大 Bug "); // 應該會被插隊到最前面
        
        system.listStatus();

        // 3. 測試完成工作
        system.completeTask("T003");
        system.listStatus(); // T003 應該不會出現在未完成清單中，但總數依然算它

        // 4. 測試刪除工作
        system.deleteTask("T001"); // 刪除中間工作
        system.listStatus();

        // 5. 測試找不到資料的防呆
        system.completeTask("T999");
        system.deleteTask("T999");
    }
}