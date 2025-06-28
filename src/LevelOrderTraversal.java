import Entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

class SolutionLOT {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        /*if(root == null) return result;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
           /* while(!queue.isEmpty())tList.add(queue.poll());
            result.add(tList.stream().map(n->n.val).collect(Collectors.toList()));
            for(TreeNode node : tList){
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }*/
            /*List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                if(queue.peek().left!=null)queue.offer(queue.peek().left);
                if(queue.peek().right!=null)queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            result.add(list);*/
        //}
        compute(root,0,result);
        return result;
    }
    private void compute(TreeNode node,int level,List<List<Integer>> result){
        if(node == null) return;
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        compute(node.left,level+1,result);
        compute(node.right,level+1,result);
    }
}
public class LevelOrderTraversal {
}
