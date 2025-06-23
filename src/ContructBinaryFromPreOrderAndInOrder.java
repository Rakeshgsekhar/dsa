import Entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SolutionCBTPI {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<Integer> preOrderQueue = new ArrayDeque<>();
        for(int n : preorder) preOrderQueue.offer(n);
        return buildTree(preOrderQueue,inorder);
    }

    private TreeNode buildTree(Deque<Integer> preOrderQueue,int[] inorder){
        if(inorder.length>0){
            int root  = preOrderQueue.poll();
            int rootIndex = findRootIndex(inorder,root);
            TreeNode node = new TreeNode(root);
            node.left = buildTree(preOrderQueue, Arrays.copyOfRange(inorder,0,rootIndex));
            node.right=buildTree(preOrderQueue,Arrays.copyOfRange(inorder,rootIndex+1,inorder.length));
            return node;
        }
        return null;
    }

    private int findRootIndex(int[] inOrder,int root){
        for(int i = 0;i<inOrder.length;i++){
            if(inOrder[i] == root) return i;
        }
        return -1;
    }
}
public class ContructBinaryFromPreOrderAndInOrder {
}
