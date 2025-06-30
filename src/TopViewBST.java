import Entity.TreeNode;

import java.util.*;

class PairTP{
    int cell;
    TreeNode node;

    public PairTP(int cell, TreeNode node) {
        this.cell = cell;
        this.node = node;
    }
}
class SolutionTView {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public  List<List<Integer>> topView(TreeNode root) {
        // code here
            ArrayList<Integer> topV = new ArrayList<>();
           /* compute(root.left,0,topV,true);
            topV.add(root.val);
            compute(root.right,0,topV,false);
            return topV;*/
        List<List<Integer>> res = new ArrayList<>();
        Queue<PairTP> queue = new LinkedList<>();
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        queue.offer(new PairTP(0,root));
        while (!queue.isEmpty()){
            PairTP pair = queue.poll();
            if(!map.containsKey(pair.cell)){
                map.put(pair.cell, new ArrayList<>());
            }
            map.get(pair.cell).add(pair.node.val);
            if(pair.node.left!=null){
                queue.offer(new PairTP(pair.cell-1,pair.node.left));
            }
            if(pair.node.right!=null){
                queue.offer(new PairTP(pair.cell+1,pair.node.right));
            }
        }

        for(Map.Entry<Integer,List<Integer>> mp : map.entrySet()){
            List<Integer> ls = mp.getValue();
            Collections.sort(ls);
            res.add(ls);
        }
        return res;
    }

    private void compute(TreeNode root, int level,ArrayList<Integer>topV,boolean isLeft){
        if(root == null) return;
        if(isLeft)compute(root.left,level+1,topV,true);
        topV.add(root.val);
        if(!isLeft)compute(root.right,level+1,topV,false);
    }
}
public class TopViewBST {
    public static void main(String[] args) {
        SolutionTView tv = new SolutionTView();
        TreeNode root = new TreeNode(10,new TreeNode(20,new TreeNode(40),new TreeNode(60)),new TreeNode(30,new TreeNode(90),new TreeNode(100)));
        List<List<Integer>> res = tv.topView(root);
        System.out.println(res);
    }
}
