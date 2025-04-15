import Entity.ListNode;

public class RemoveLinkedListElements {
    /*
    Leetcode easy 203
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0,head);
        ListNode prev = temp;
        while(prev!=null){
            while(prev.next !=null && prev.next.val == val){
                prev.next = prev.next.next;
            }
            prev = prev.next;
        }
        return temp.next;
    }
}
