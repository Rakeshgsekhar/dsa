import Entity.ListNode;

class SolutionPLX {
    public ListNode partition(ListNode head, int x) {
       /* ListNode temp = head,leftPointer = null,rightHead = null,rightPointer = null;
//        int count = display(head);
        while(temp.next!=null){
            while (temp.next!=null && temp.val < x){
                leftPointer = temp;
                temp = temp.next;
            }
            if(leftPointer == null) leftPointer = temp;
            rightHead = temp;
            while(temp!=null && temp.val>=x){
                rightPointer = temp;
                temp = temp.next;
            }
            if(temp == null) break;
            leftPointer.next = temp;
            rightPointer.next = temp.next;
            temp.next = rightHead;
        }
        display(head);
        return head;*/
        ListNode ans = new ListNode();
        ListNode temp = ans;
        ListNode left = head;
        int xCounter = 0;
        while(left!=null){
            if(left.val<x){
                temp.next= new ListNode(left.val, null);
                temp = temp.next;
            }else if(left.val == x) xCounter++;
            left = left.next;
        }
        while(xCounter>0){
            temp.next = new ListNode(x,null);
            xCounter--;
            temp = temp.next;
        }
        ListNode right = head;
        while(right != null){
            if(right.val>x){
                temp.next= new ListNode(right.val, null);
                temp = temp.next;
            }
            right = right.next;
        }

        display(ans.next);
        return ans.next;
    }

    private void display(ListNode dis){
        ListNode temp = dis;
        while(temp!=null){
            System.out.print(temp.val);
            System.out.print("->");
            temp=temp.next;
        }
        return;
    }
}
public class PartitionListX {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2,null))))));
        //ListNode head = new ListNode(2,new ListNode(1,null));
        SolutionPLX plx = new SolutionPLX();
        plx.partition(head,2);
    }
}
