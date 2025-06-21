import Entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionBTMPS {
    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int[] res = {root.val};
        compute(root,map,res);
        return res[0];//
    }
    private int compute(TreeNode node,Map<TreeNode, Integer> map,int[] res){
         /*if(node == null) return 0;
        if(map.containsKey(node)) return map.get(node);
        if()
        int valLeft = (node.left!=null? node.left.val : 0);
        int valRight = (node.right!=null? node.right.val : 0);
        int currentSum = node.val +valLeft +valRight;
        int leftSum = compute(node.left,map);
        int rightSum = compute(node.right,map);

        int max = Math.max(currentSum,Math.max(leftSum,rightSum));
        map.put(node,max);
        return max;*/
        if(node == null) return 0;
        //if(map.containsKey(node)) return map.get(node);
        int currentSum = 0;
        /*if(node.left != null && node.right!=null) {
             currentSum = node.val + node.right.val + node.left.val;
        }else{
            if(node.right == null && node.left!=null){
                currentSum = Math.max(node.val, node.left.val);
            }else if(node.left == null  && node.right!=null){
                currentSum = Math.max(node.val, node.right.val);
            }else{
                currentSum = node.val;
            }
        }*/
        int leftSum = Math.max(0,compute(node.left,map,res));
        int rightSum = Math.max(0,compute(node.right,map,res));
        res[0] = Math.max(res[0],leftSum+rightSum+node.val);
        int max = Math.max(leftSum,rightSum)+node.val;
        //map.put(node,max);
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
