
public class MyQueue {
     class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void offer(int v) {
        Node node = new Node(v);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = tail.next;
        size++;
        return;
    }
    public Integer poll() {
        if(size == 0) {
            return null;
        }
        Integer ret = head.val;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return ret;
    }
    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return head.val;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
}
