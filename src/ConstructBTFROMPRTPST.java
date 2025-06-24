import Entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class SolutionCBTPRPS {
    int index = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return computeBT(preorder,postorder,0,postorder.length-1);
    }

    private TreeNode computeBT(int[] preOrder,int[] postOrder,int preorderIndex,int postorderIndex){
        if(index>= preOrder.length || preorderIndex>postorderIndex)
            return null;

        TreeNode root = new TreeNode(preOrder[index++]);
        if(preorderIndex == postorderIndex) return root;
        int i = 0;
        for(i = preorderIndex;i<=postorderIndex;i++){
            if(postOrder[i] == preOrder[index]) break;
        }
        if(preorderIndex<-postorderIndex){
            root.left = computeBT(preOrder,postOrder,preorderIndex,i);
            root.right = computeBT(preOrder,postOrder,i+1,postorderIndex-1);
        }
        return root;
    }
}
public class ConstructBTFROMPRTPST {
}
