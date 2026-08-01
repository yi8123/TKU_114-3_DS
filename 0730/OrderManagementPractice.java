import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OrderManagementPractice {
    // 主資料庫
    private ArrayList<Order> masterList = new ArrayList<>();
    // 等待狀態 Queue
    private Queue<Order> waitQueue = new LinkedList<>();
    // 完成狀態 Stack
    private Stack<Order> finishedStack = new Stack<>();

    // 加入訂單，防止重複編號
    public boolean addOrder(Order order) {
        for (Order o : masterList) {
            if (o.getOrderId().equalsIgnoreCase(order.getOrderId())) {
                System.out.println("錯誤：訂單編號 " + order.getOrderId() + " 已存在！拒絕重複加入。");
                return false;
            }
        }
        masterList.add(order);
        waitQueue.offer(order);
        return true;
    }

    // 處理下一筆訂單
    public void processNextOrder() {
        if (waitQueue.isEmpty()) {
            System.out.println("等待佇列為空，無待處理訂單。");
            return;
        }
        Order o = waitQueue.poll();
        finishedStack.push(o);
        System.out.println("已成功處理訂單: " + o);
    }

    // 顯示下一筆待處理訂單 (僅查看 peek)
    public void peekNextOrder() {
        if (waitQueue.isEmpty()) {
            System.out.println("無待處理訂單 (Queue 為空)。");
        } else {
            System.out.println("下一筆待處理訂單: " + waitQueue.peek());
        }
    }

    public static void main(String[] args) {
        OrderManagementPractice system = new OrderManagementPractice();

        System.out.println("=== 測試 1: 空 Queue & 空 Stack 邊界情況 ===");
        system.peekNextOrder();
        system.processNextOrder();

        System.out.println("\n=== 測試 2: 加入訂單與防止重複編號 ===");
        system.addOrder(new Order("O01", "張三", 1500.0));
        system.addOrder(new Order("O02", "李四", 3200.0));
        system.addOrder(new Order("O01", "王五", 500.0)); // 重複編號測試

        System.out.println("\n=== 測試 3: 多條件搜尋與找不到資料 ===");
        system.addOrder(new Order("O03", "張三", 4500.0)); // 張三的第二筆
        ArrayList<Order> searchRes = OrderAlgorithms.searchByCustomerName(system.masterList, "張三");
        System.out.println("搜尋 '張三' 的訂單:");
        for(Order o : searchRes) System.out.println("  " + o);
        
        System.out.println("搜尋 '趙六' (不存在) 的訂單:");
        ArrayList<Order> searchResEmpty = OrderAlgorithms.searchByCustomerName(system.masterList, "趙六");
        if(searchResEmpty.isEmpty()) System.out.println("  找不到任何相關訂單。");

        System.out.println("\n=== 測試 4: 依金額降冪的 Merge Sort ===");
        Order[] orderArray = system.masterList.toArray(new Order[0]);
        OrderAlgorithms.mergeSortByAmountDesc(orderArray, 0, orderArray.length - 1);
        System.out.println("主資料庫依金額降冪排序後:");
        for(Order o : orderArray) System.out.println("  " + o);

        System.out.println("\n=== 測試 5: 狀態流轉與待處理查看 ===");
        system.peekNextOrder();
        system.processNextOrder();
        system.peekNextOrder();
    }
}