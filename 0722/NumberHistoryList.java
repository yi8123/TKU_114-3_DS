public class NumberHistoryList {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head = null;

    // 前端新增
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("前端新增: " + data);
    }

    // 尾端新增
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("尾端新增 (做為首節點): " + data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("尾端新增: " + data);
    }

    // 搜尋
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) return true;
            current = current.next;
        }
        return false;
    }

    // 刪除
    public void remove(int value) {
        if (head == null) {
            System.out.println("空串列，無法刪除 " + value);
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println("已刪除: " + value);
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("找不到資料: " + value + "，無法刪除");
            return;
        }
        prev.next = current.next;
        System.out.println("已刪除: " + value);
    }

    // 輸出與統計 (要求空串列要有明確結果)
    public void printStatus() {
        if (head == null) {
            System.out.println("【狀態】串列為空。Size: 0, 總和: 0, 最大值: N/A, 最小值: N/A");
            return;
        }

        Node current = head;
        int size = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        System.out.print("【串列內容】: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            size++;
            sum += current.data;
            if (current.data > max) max = current.data;
            if (current.data < min) min = current.data;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("統計 -> Size: " + size + ", 總和: " + sum + ", 最大值: " + max + ", 最小值: " + min);
    }

    public static void main(String[] args) {
        NumberHistoryList history = new NumberHistoryList();

        System.out.println("--- 測試 1: 空串列統計 ---");
        history.printStatus();

        System.out.println("\n--- 測試 2~7: 進行至少 8 次操作 ---");
        history.addLast(25);      // 操作 1
        history.addLast(50);      // 操作 2
        history.addFirst(10);     // 操作 3
        history.addFirst(5);      // 操作 4
        history.printStatus();    // 操作 5 (輸出)

        System.out.println("搜尋 50: " + history.search(50)); // 操作 6
        System.out.println("搜尋 99: " + history.search(99)); 

        history.remove(10);       // 操作 7 (刪除中間)
        history.remove(5);        // 操作 8 (刪除前端)
        history.remove(99);       // 操作 9 (刪除找不到的資料)

        System.out.println("\n--- 最後狀態 ---");
        history.printStatus();
    }
}