import Entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SolutionPS2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        compute(root,targetSum,path,paths);
        return paths;
    }
    private void compute(TreeNode node,int target, List<Integer> path,List<List<Integer>> paths){
        if(node == null) return;
        path.add(node.val);
        if(isLeaf(node)){
            if(target- node.val == 0){
                paths.add(new ArrayList<>(path));
            }
        }
        if(node.left!=null) compute(node.left, target - node.val, path, paths);
        if(node.right!=null) compute(node.right,target-node.val,path,paths);
        path.remove(path.size()-1);
    }
    private boolean isLeaf(TreeNode node){
        return node.left==null && node.right == null;
    }
}
public class PathSUm2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null),new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
        SolutionPS2 ps2 = new SolutionPS2();
        ps2.pathSum(root,22);
    }
}
