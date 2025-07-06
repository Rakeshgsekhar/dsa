import Entity.ListNode;
import Entity.TreeNode;

class SolutionBTL {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head);
    }

    private TreeNode buildTree(ListNode head){
        if(head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head,fast=head,prev = null;
        while(fast !=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        if(prev!=null)prev.next = null;
        //else return null;
        node.left = buildTree(head);
        node.right = buildTree(slow.next);
        return node;
    }
}
public class BTFromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10,new ListNode(-3,new ListNode(0,new ListNode(5,new ListNode(9,null)))));
        SolutionBTL bt = new SolutionBTL();
        TreeNode root = bt.sortedListToBST(head);
        System.out.println(root.val);
    }
}
