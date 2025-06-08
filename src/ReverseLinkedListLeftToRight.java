import Entity.ListNode;

import java.util.List;

class SolutionRLR {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head,Lprev = null;
        int i = 0;
        while(temp.next != null && i<left){
            Lprev = temp;
            temp = temp.next;
            i++;
        }
        if(i!=left) return head; // not enough node to perform the operations

        ListNode next,prev = null,Rleft = temp;
        while(Rleft != null && i<=right){
            next = Rleft.next;
            Rleft.next=prev;
            prev = Rleft;
            Rleft=next;
            i++;
        }
        if(Lprev == null){
            head = prev;
        }else
            Lprev.next = prev;
        temp.next = Rleft;




        ListNode dis = head;
        while(dis != null){
            System.out.print(dis.val);
            System.out.print("->");
            dis = dis.next;
        }
        System.out.println();

        return head;
    }
}
public class ReverseLinkedListLeftToRight {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        SolutionRLR rlr = new SolutionRLR();
        rlr.reverseBetween(head,0,4);
        rlr.reverseBetween(new ListNode(1,null),1,1);
    }

}
