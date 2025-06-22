import Entity.TreeNode;

class SolutionDiameter {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        computeDiameterDFS(root);
        return diameter;
    }

    private int computeDiameterDFS(TreeNode node){
        if(node == null) return 0;
        int left = computeDiameterDFS(node.left);
        int right = computeDiameterDFS(node.right);

        diameter = Math.max(diameter,left+right);
        return 1+Math.max(left,right);
    }
}
public class DiametreofBT {
}
