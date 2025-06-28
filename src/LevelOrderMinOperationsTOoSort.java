import Entity.TreeNode;

import java.util.*;

class SolutionMOPT {
    public int minimumOperations(TreeNode root) {
        int operations = 0;
        if(root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
           /* while(!queue.isEmpty())tList.add(queue.poll());
            result.add(tList.stream().map(n->n.val).collect(Collectors.toList()));
            for(TreeNode node : tList){
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }*/
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                if(queue.peek().left!=null)queue.offer(queue.peek().left);
                if(queue.peek().right!=null)queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            operations+=getMinOP(list);
        }

        return operations;
    }
    private int getMinOP(List<Integer> list){
        if(list.size() == 1) return 0;
        int ct = 0;
        List<Integer> temp = new ArrayList<>(list);
        temp.sort((a,b)->a-b);
        for(int i = 0;i< temp.size();i++){
            if(temp.get(i) != list.get(i)) ct++;
        }
        return ct%2 == 0 ? ct/2:ct/2+1;
    }

}
public class LevelOrderMinOperationsTOoSort {
}
