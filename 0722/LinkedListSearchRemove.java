public class LinkedListSearchRemove {
    
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head = null;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean contains(int value) {
        if (head == null) return false;
        Node current = head;
        while (current != null) {
            if (current.data == value) return true;
            current = current.next;
        }
        return false;
    }

    public void removeValue(int value) {
        if (head == null) {
            System.out.println("串列為空，無法刪除 " + value);
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println("成功刪除 Head 節點 [" + value + "]");
            return;
        }
        
        Node current = head;
        Node prev = null;
        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("找不到包含數值 " + value + " 的節點");
            return;
        }

        prev.next = current.next;
        System.out.println("成功刪除節點 [" + value + "]");
    }

    public void printList() {
        if (head == null) {
            System.out.println("Empty List (null)");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListSearchRemove list = new LinkedListSearchRemove();
        
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        System.out.print("初始串列: ");
        list.printList();

        System.out.println("是否包含 30? " + list.contains(30));
        System.out.println("是否包含 99? " + list.contains(99));

        list.removeValue(10);
        list.printList();

        list.removeValue(30);
        list.printList();

        list.removeValue(40);
        list.printList();

        list.removeValue(99);
        list.printList();
    }
}