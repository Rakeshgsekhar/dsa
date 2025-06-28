import Entity.TreeNode;

class SolutionBSTI {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode temp = root;
        TreeNode prev = root;
        while(temp!=null){
            prev = temp;
            if(val<temp.val) temp = temp.left;
            else temp = temp.right;
        }
        if(val<prev.val) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);

        return root;
    }
}
public class BSTInseretion {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
        SolutionBSTI bsti = new SolutionBSTI();
        TreeNode inserted = bsti.insertIntoBST(root,5);
    }
}
