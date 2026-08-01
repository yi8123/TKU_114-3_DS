import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EventRegistrationSystem {
    private ArrayList<Registration> masterList = new ArrayList<>();
    private Queue<Registration> waitingQueue = new LinkedList<>();
    private Stack<Registration> cancelStack = new Stack<>();
    
    private final int MAX_CAPACITY = 3; // 限制活動正取名額最大為 3 人

    // 處理報名，防止重複編號、處理正取與候補
    public void register(Registration reg) {
        for (Registration r : masterList) {
            if (r.getId() == reg.getId()) {
                System.out.println("拒絕報名：重複的編號 " + reg.getId());
                return;
            }
        }
        
        masterList.add(reg);
        if (masterList.size() - waitingQueue.size() <= MAX_CAPACITY) {
            System.out.println("成功加入正取名額: " + reg);
        } else {
            waitingQueue.offer(reg);
            System.out.println("名額已滿，成功加入候補佇列: " + reg);
        }
    }

    // 依編號取消報名
    public void cancelRegistration(int id) {
        Registration target = null;
        for (Registration r : masterList) {
            if (r.getId() == id) {
                target = r;
                break;
            }
        }

        if (target == null) {
            System.out.println("取消失敗：找不到該編號的報名資料。");
            return;
        }

        masterList.remove(target);
        cancelStack.push(target);
        
        if (waitingQueue.contains(target)) {
            waitingQueue.remove(target);
            System.out.println("已從候補佇列移除取消之資料: " + target);
        } else {
            System.out.println("正取名單有人退出，遞補下一位候補人選...");
            if (!waitingQueue.isEmpty()) {
                Registration luckyReg = waitingQueue.poll();
                System.out.println("遞補成功，新正取人選: " + luckyReg);
            } else {
                System.out.println("候補佇列目前為空，無人可遞補。");
            }
        }
    }

    // 復原最近一次取消
    public void rollbackCancellation() {
        if (cancelStack.isEmpty()) {
            System.out.println("無取消紀錄可供復原。");
            return;
        }
        Registration restored = cancelStack.pop();
        System.out.println("觸發復原流程，重新加入系統: " + restored);
        register(restored);
    }

    public static void main(String[] args) {
        EventRegistrationSystem system = new EventRegistrationSystem();

        System.out.println("=== 測試 1: 報名操作與額滿轉候補 ===");
        system.register(new Registration(102, "張三"));
        system.register(new Registration(101, "李四"));
        system.register(new Registration(105, "王五"));
        system.register(new Registration(104, "趙六")); // 超過3人，進入候補
        system.register(new Registration(102, "重複人")); // 測試重複編號

        System.out.println("\n=== 測試 2: 取消正取與候補遞補機制 ===");
        system.cancelRegistration(101); // 應自動由 104 遞補

        System.out.println("\n=== 測試 3: 復原機制測試 ===");
        system.rollbackCancellation();

        System.out.println("\n=== 測試 4: 排序與搜尋演算法 ===");
        Registration[] arr = system.masterList.toArray(new Registration[0]);
        RegistrationAlgorithms.sortByIdAsc(arr, 0, arr.length - 1);
        System.out.println("排序後正取主資料:");
        for(Registration r : arr) System.out.println("  " + r);

        System.out.println("執行編號 105 的 Binary Search:");
        int idx = RegistrationAlgorithms.binarySearchById(arr, 105);
        System.out.println("  結果位置: " + idx);
    }
}