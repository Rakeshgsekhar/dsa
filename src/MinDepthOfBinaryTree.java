import Entity.TreeNode;

class SolutionMDBT {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return computeMinDepth(root);
    }

    private int computeMinDepth(TreeNode node){
        if(node == null) return Integer.MAX_VALUE;
        if(isLeaf(node)) return 1;
        int left = computeMinDepth(node.left);
        int right = computeMinDepth(node.right);

        return 1+Math.min(left,right);
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right==null;
    }
}
public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode ip2 = new TreeNode(2,null,new TreeNode(3,null,new TreeNode(4,null,new TreeNode(5,null,new TreeNode(6)))));
        SolutionMDBT mdbt = new SolutionMDBT();
        System.out.println(mdbt.minDepth(root));
        System.out.println(mdbt.minDepth(ip2));
    }
}
