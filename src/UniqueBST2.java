import Entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionUBST2 {
    public List<TreeNode> generateTrees(int n) {
      //  Map<Pair<Integer, Integer>, List<TreeNode>> dp = new HashMap<>();
        List<TreeNode> trees = generateTrees(1,n);
        return trees;
    }
    private List<TreeNode> generateTrees(int low,int high){
        List<TreeNode> tree  = new ArrayList<>();
        if(low>high){
            tree.add(null);
            return tree;
        }

       // if(dp.containsKey(new Pair(low,high))) return dp.get(new Pair(low,high));
        for(int i = low;i<=high;i++){
            List<TreeNode> leftSubTree = generateTrees(low,i-1);
            List<TreeNode> rightSubTree = generateTrees(i+1,high);

            for(TreeNode left:leftSubTree){
                for(TreeNode right:rightSubTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;

                    tree.add(root);
                }
            }
        }
       // dp.put(new Pair<Integer,Integer>(low, high), tree);
        return tree;
    }
}
public class UniqueBST2 {
}
