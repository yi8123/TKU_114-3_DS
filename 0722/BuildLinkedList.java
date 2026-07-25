public class BuildLinkedList {
        static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {  
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        
        head.next = second;
        second.next = third;
        third.next = fourth;

        
        System.out.print("鏈結串列內容: ");
        
            if (head == null) {
            System.out.println("空串列");
            System.out.println("節點數: 0, 總和: 0");
            return;
        }

        Node current = head;
        int count = 0;
        int sum = 0;

        while (current != null) {
            System.out.print(current.data + " -> ");
            count++;
            sum += current.data;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("節點數: " + count);
        System.out.println("總和: " + sum);
    }
}
