import Entity.ListNode;
import Entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SolutionBBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder= new ArrayList<>();
        buildInorder(root,inorder);
        return balanceBST(inorder,0,inorder.size()-1);
    }
    private TreeNode balanceBST(List<Integer>inorder,int start,int end){
        if(start>end) return null;

        int mid = start+(end-start)/2 ;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = balanceBST(inorder,0,mid-1);
        root.right = balanceBST(inorder,mid+1,end);
        return root;
    }

    private void buildInorder(TreeNode root,List<Integer>inorder){
        if(root == null) return;
        if(root.left!=null) buildInorder(root.left,inorder);
        inorder.add(root.val);
        if(root.right!=null) buildInorder(root.right,inorder);
    }
}
public class BalanceBST {
}
