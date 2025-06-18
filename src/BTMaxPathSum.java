import Entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionBTMPS {
    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        TreeNode node = root;
//        toArrayHelp(node, result);
        //return result;
        return compute(root,map);
    }
    private void toArrayHelp(TreeNode ref, ArrayList<Integer> result) {
        if (ref == null) {
            result.add(0);
            return;
        }
        toArrayHelp(ref.left, result);
        result.add(ref.val);

        toArrayHelp(ref.right, result);
    }

    private int compute(TreeNode node,Map<TreeNode, Integer> map){
        if(node == null) return 0;
        if(map.containsKey(node)) return map.get(node);
        int currentSum = 0;
        if(node.left != null && node.right!=null) {
             currentSum = node.val + node.right.val + node.left.val;
        }else{
            if(node.right == null && node.left!=null){
                currentSum = Math.max(node.val, node.left.val);
            }else if(node.left == null  && node.right!=null){
                currentSum = Math.max(node.val, node.right.val);
            }else{
                currentSum = node.val;
            }
        }
        int leftSum = compute(node.left,map);
        int rightSum = compute(node.right,map);
        System.out.println(currentSum+leftSum+rightSum);
        int max = Math.max(currentSum,Math.max(leftSum,rightSum));
        map.put(node,max);
        return max;

    }
}
public class BTMaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null)));
        SolutionBTMPS btmps = new SolutionBTMPS();
        System.out.println(btmps.maxPathSum(root));
    }
}
