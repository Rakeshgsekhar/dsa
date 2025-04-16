import Entity.ListNode;

import java.util.PriorityQueue;

public class MergeKList {
   public  ListNode mergeList(ListNode l1, ListNode l2){
       if(l1 == null) return l2;
       if(l2 == null) return l1;

       if(l1.val<l2.val){
           l1.next = mergeList(l1.next,l2);
           return l1;
       }else{
           l2.next = mergeList(l1,l2.next);
           return l2;
       }
   }

   public ListNode divide(ListNode[] list,int left,int right){
       if(left == right) return list[left];

       int mid = (right-left) /2;
       ListNode l1 = divide(list,left,mid);
       ListNode l2 = divide(list,mid+1,right);
       return mergeList(l1,l2);
   }
    public ListNode mergeKLists(ListNode[] lists) {
        /*
        ListNode result = new ListNode();
        PriorityQueue<Integer> minHead = new PriorityQueue<>();
        for(ListNode l : lists){
            while(l!=null){
                minHead.offer(l.val);
            }
        }
        ListNode head = new ListNode(0,result);
        while(!minHead.isEmpty()){
            ListNode nextNode = new ListNode(minHead.poll(),null);
            result.next = nextNode;
            result = result.next;
        }
        return head;
        */
        if(lists.length == 0) return  null;
        return divide(lists,0, lists.length-1);
    }
}
