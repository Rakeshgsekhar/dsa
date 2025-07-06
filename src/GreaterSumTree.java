import Entity.TreeNode;
import com.sun.source.tree.Tree;

class SolutionGST {
    private int sum =0;
    public TreeNode bstToGst(TreeNode root) {
        int[]val = new int[]{0};
        return computeGST(root,val);
        //return root;
    }

    private TreeNode computeGST(TreeNode root,int[] val){
       if(root!=null) {
           computeGST(root.right, val);
           val[0] += root.val;
           root.val = val[0];
           computeGST(root.left, val);
       }
        return root;
    }


    private TreeNode compute(TreeNode node){
        if(node !=null){
            compute(node.right);
            sum+=node.val;
            node.val = sum;
            compute(node.left);
        }
        return node;
    }
}
public class GreaterSumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(1,new TreeNode(0),new TreeNode(2,null,new TreeNode(3))),new TreeNode(6,new TreeNode(5),new TreeNode(7,null,new TreeNode(8))));
        SolutionGST gst = new SolutionGST();
        TreeNode node = gst.bstToGst(root);
        System.out.println(node.val);
    }
}
