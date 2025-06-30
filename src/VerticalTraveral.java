import Entity.TreeNode;

import java.util.*;

class PairVT{
    int col;
    int cell;
    TreeNode node;

    public PairVT(int cell, TreeNode node, int col) {
        this.cell = cell;
        this.node = node;
        this.col = col;
    }
}
class SolutionVT {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<PairVT> queue = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.offer(new PairVT(0,root,0));
        while (!queue.isEmpty()){
            PairVT pair = queue.poll();
            TreeNode node = pair.node;
            int col = pair.col;
            int cell = pair.cell;
            System.out.println(col);
            System.out.println(node.val);
            if(!map.containsKey(cell))  map.put(cell, new TreeMap<>());
            if(!map.get(cell).containsKey(col)) map.get(cell).put(col,new PriorityQueue<>());
            map.get(cell).get(col).offer(node.val);
            if(pair.node.left!=null){
                queue.offer(new PairVT(cell-1,node.left,pair.col+1));
            }
            if(pair.node.right!=null){
                queue.offer(new PairVT(cell+1,node.right,pair.col+1));
            }
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> mp : map.values()){
           res.add(new ArrayList<>());
           for(PriorityQueue<Integer> pq:mp.values()){
               while(!pq.isEmpty()){
                   res.get(res.size()-1).add(pq.poll());
               }
           }
        }
        return res;
    }
}
public class VerticalTraveral {
    public static void main(String[] args) {
        SolutionVT vt = new SolutionVT();
        TreeNode root = new TreeNode(3,new TreeNode(1,new TreeNode(5),new TreeNode(2)),new TreeNode(4,new TreeNode(2),new TreeNode(6)));
        List<List<Integer>> res = vt.verticalTraversal(root);

        System.out.println(res);
    }
}
