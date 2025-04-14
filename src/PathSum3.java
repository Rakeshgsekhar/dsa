import Entity.TreeNode;

public class PathSum3 {
    int total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        helper(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return total;
    }
    void helper(TreeNode root,int sum, long curr){
        if(root == null) return ;
        curr+=root.val;
        if(curr==sum) total++;
        helper(root.left,sum,curr);
        helper(root.right,sum,curr);
    }
}
