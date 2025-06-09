import Entity.ListNode;

class SolutionRNKG {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while(temp!=null && count<k){
            temp = temp.next;
            count++;
        }
        if(temp==null) return head;
        ListNode newHead = reverse(head,temp);
        head.next = reverseKGroup(temp,k);

        return newHead;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null, curr = start;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
public class ReverseNodesInKGroups {
    public static void main(String[] args) {
        SolutionRNKG rd = new SolutionRNKG();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        rd.reverseKGroup(head, 2);
    }
}
