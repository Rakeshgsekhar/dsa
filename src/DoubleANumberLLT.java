import Entity.ListNode;

import java.util.List;

class SolutionLLT {
    public ListNode doubleIt(ListNode head) {

        return multiplyIt(head,2);
    }

    private ListNode multiplyIt(ListNode head,int k){
        if(head.val >= 5){
            ListNode newHead = new ListNode();
            newHead.next = head;
            head = newHead;
        }
        ListNode temp = head;
        while(temp !=null){
            int num = temp.val*2;
            temp.val = num%10;

            if(temp.next != null && temp.next.val >= 5){
                int carr = (temp.next.val*2)/10;
                temp.val+=carr;
            }
        }
        return head;
    }
}
public class DoubleANumberLLT {
}
