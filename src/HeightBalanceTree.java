import Entity.TreeNode;

class SolutionHBT {
    boolean isBalanced=true;
    public boolean isBalanced(TreeNode root) {
        /*if(root == null) return true;
        if(isLeafNode(root)) return true;
        int hbt = compute(root);
        return isBalanced;*/
        if(root == null) return true;
        int maxDepth = 0;
        int leftDepth = dfs(root.left,1);
        int rightDepth = dfs(root.right,1);
        maxDepth = Math.abs(leftDepth-rightDepth);
        return maxDepth<=1;
    }

    public int dfs(TreeNode node,int count){
        if(node == null) return count;
        return Math.max(dfs(node.left,count+1),dfs(node.right,count+1));

    }
    private int compute(TreeNode node){
        if(node == null) return 0;
        int leftHeight = compute(node.left);
        int rightHeight = compute(node.right);
        if(Math.abs(leftHeight-rightHeight)>1){
            isBalanced=false;
        }

        return Math.max(Math.abs(leftHeight-rightHeight)+1,Math.max(leftHeight,rightHeight));
    }
    private boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }
}
public class HeightBalanceTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null)));
//        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4),new TreeNode(4)),new TreeNode(3)),new TreeNode(2));
        SolutionHBT hbt = new SolutionHBT();
        System.out.println(hbt.isBalanced(root));
    }
}
