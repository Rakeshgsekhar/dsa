package Entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){
        this.val = 0;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
