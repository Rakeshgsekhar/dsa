import Entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class PairN{
    TreeNode node;
    boolean leftSet;

    public PairN(TreeNode node, boolean leftSet) {
        this.node = node;
        this.leftSet = leftSet;
    }
}
class SolutionCCBT{
    public boolean isCompleteTree(TreeNode root) {
        if(isLeaf(root)) return true;
        Deque<PairN> treeNodeDeque = new ArrayDeque<>();
        if(root.left == null) return false;
//        treeNodeDeque.offer(new PairN(root,true));
    /*    treeNodeDeque.offer(new PairN(root.left,true));
        if(root.right != null)treeNodeDeque.offer(new PairN(root.right,false));
        int leftNodes = 0;
        int rightNodes = 0;
        while(!treeNodeDeque.isEmpty()){
            int size = treeNodeDeque.size();
            for(int i = 0;i<size;i++) {
                PairN n = treeNodeDeque.pop();
                TreeNode node = n.node;
                if(!isLeaf(node) && node.left == null) return false;
                if(!isLeaf(node) && n.leftSet && node.right == null) return false;
                else if(node.left != null) {
                    if(n.leftSet) leftNodes++;
                    else rightNodes++;
                    treeNodeDeque.offer(new PairN(node.left, n.leftSet));
                }
                if(node.right != null) {
                    if(n.leftSet) leftNodes++;
                    else rightNodes++;
                    treeNodeDeque.offer(new PairN(node.right, n.leftSet));
                }
            }
        }
        if(rightNodes>leftNodes) return false;
        return true;*/

        /*Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(queue.peek() !=null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while(!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }
        return queue.isEmpty();*/
        int nodes = countNode(root);
        return compute(root,1,nodes);
    }


    private int countNode(TreeNode node){
        if(node == null) return 0;
        return 1+countNode(node.left)+countNode(node.right);
    }

    private boolean compute(TreeNode node, int index,int nodes){
        if(node == null) return true;
        if(index>nodes) return false;
        return compute(node.left,2*index,nodes) && compute(node.right,2*index+1,nodes);
    }

    private boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }
}
public class CheckCompletnessOfBT {
    public static void main(String[] args) {
        SolutionCCBT ccbt = new SolutionCCBT();
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));
        System.out.println(ccbt.isCompleteTree(root));

        TreeNode ip2 = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,null,new TreeNode(7)));
        System.out.println(ccbt.isCompleteTree(ip2));
    }
}
