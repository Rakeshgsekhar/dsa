import Entity.ListNode;

class SolutionRDLL {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0,null);
        newHead.next = head;
        ListNode tempHead = newHead;
        ListNode temp = head;
        while(temp!=null && temp.next !=null){
            if(temp.val == temp.next.val){
                while(temp.next!=null && temp.val ==temp.next.val){
                    temp = temp.next;
                }
                tempHead.next = temp.next;
            }else{
                tempHead= tempHead.next;
            }
            temp = temp.next;
        }
        return newHead.next;
    }
}
public class RemoveDuplicatesLLT {
    public static void main(String[] args) {
        SolutionRDLL rd = new SolutionRDLL();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5,null)))))));
        rd.deleteDuplicates(head);
    }
}
