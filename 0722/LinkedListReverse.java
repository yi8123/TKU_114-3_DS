public class LinkedListReverse {
    
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head = null;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = newNode; return; }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    public void printList() {
        if (head == null) { System.out.println("null (空串列)"); return; }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("--- 測試空串列 ---");
        LinkedListReverse emptyList = new LinkedListReverse();
        emptyList.printList();
        emptyList.reverse();
        emptyList.printList();

        System.out.println("\n--- 測試單一節點 ---");
        LinkedListReverse singleList = new LinkedListReverse();
        singleList.append(100);
        singleList.printList();
        singleList.reverse();
        singleList.printList();

        System.out.println("\n--- 測試多節點 ---");
        LinkedListReverse multiList = new LinkedListReverse();
        multiList.append(10);
        multiList.append(20);
        multiList.append(30);
        multiList.append(40);
        System.out.print("反轉前: ");
        multiList.printList();
        
        multiList.reverse();
        System.out.print("反轉後: ");
        multiList.printList();
    }
}