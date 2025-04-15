import Entity.ListNode;

public class RotateList {
    /*
    Leetcode Medium 61
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        ListNode temp2 = head;
        ListNode newHead = new ListNode();
        int len = 1;
        if(head == null) return head;
        if(head.next == null) return head;
        if(k==0) return head;

        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        int n = k%len;
        if(n==0) return head;

        //temp = head;
        for(int i = 0;i<len-n-1;i++){
            temp2 = temp2.next;
        }
        newHead = temp2.next;
        temp2.next = null;
        temp.next = head;
        return newHead;
    }
}
