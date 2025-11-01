import Entity.ListNode;

class SolutionDNFLL {
    public ListNode modifiedList(int[] nums, ListNode head) {
        for(int num : nums){
            ListNode temp = head;
            ListNode prev = null;
            while(temp != null){
                if(temp.val == num){
                   if(temp == head){
                       head = head.next;
                   }else{
                       prev.next = temp.next;
                   }
                }else{
                    prev = temp;
//                    temp = temp.next;
                }
                temp = temp.next;
            }
        }

        return head;
    }
}
public class DeleteNodeFromLLFromArray {
    public static void main(String[] args) {
        SolutionDNFLL dn = new SolutionDNFLL();
        dn.modifiedList(new int[]{1},new ListNode(1,new ListNode(2,new ListNode(1,new ListNode(2,new ListNode(1,new ListNode(2,null)))))));
    }
}
