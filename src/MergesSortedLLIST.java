import Entity.ListNode;

class SolutionMLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return list1;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = new ListNode();
        ListNode temp = head;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp = new ListNode(list1.val,null);
                list1 = list1.next;
            }else{
                temp = new ListNode(list2.val,null);
                list2 = list2.next;
            }
            temp = temp.next;
        }

        while(list1!=null ){
            temp = new ListNode(list1.val,null);
            list1 = list1.next;
            temp = temp.next;
        }

        while(list2!=null ){
            temp = new ListNode(list2.val,null);
            list2 = list2.next;
            temp = temp.next;
        }



        return head;
    }
}
public class MergesSortedLLIST {
}
