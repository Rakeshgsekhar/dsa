import Entity.TreeNode;

class SolutionSTAAT {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if( valiadateSubTree(root,subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean valiadateSubTree(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        return true&&valiadateSubTree(root.left,subRoot.left)&&valiadateSubTree(root.right,subRoot.right);
    }
}
public class SubTreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4,new TreeNode(1,null,null),new TreeNode(2,null,null));
        TreeNode root = new TreeNode(3, new TreeNode(4,new TreeNode(1,null,null),new TreeNode(2,null,null)),new TreeNode(5,null,null));

        TreeNode node1 = new TreeNode(1);
        TreeNode root1 = new TreeNode(1,null,new TreeNode(1));

        SolutionSTAAT st = new SolutionSTAAT();
        System.out.println(st.isSubtree(root,node));
        System.out.println(st.isSubtree(root1,node1));
    }
}
