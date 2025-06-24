import Entity.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class SolutionCBTIP {
   /* public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inordermap = new HashMap<>();
        for(int i = 0;i<inorder.length;i++) inordermap.put(inorder[i],i);
        Stack<Integer> postOrderStack = new Stack<>();
        for(int post : postorder) postOrderStack.push(post);
        return build(inordermap,postorder,inorder,postOrderStack);
    }

    private TreeNode build(Map<Integer,Integer> inordermap,int[] postorder,int [] inorder,Stack<Integer> postOrderStack){
        if(inorder.length>0){
            int root = postOrderStack.pop();
            int index = findIndex(inorder,root);
            TreeNode node = new TreeNode(root);
            node.right = build(inordermap,postorder, Arrays.copyOfRange(inorder,index+1,inorder.length),postOrderStack);
            node.left = build(inordermap,postorder,Arrays.copyOfRange(inorder,0,index),postOrderStack);

            return node;
        }
        return null;
    }

    private int findIndex(int [] inorder,int val){
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == val) return i;
        }
        return -1;
    }*/
   int postIdx, inIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*Stack<Integer> postOrderStack = new Stack<>();
        for(int post : postorder) postOrderStack.push(post);
        return build(postorder,inorder,postOrderStack);*/
        postIdx = inorder.length - 1;
        inIdx = inorder.length - 1;
        return buildBT(inorder, postorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] postorder,int [] inorder,Stack<Integer> postOrderStack){
        if(inorder.length>0){
            int root = postOrderStack.pop();
            int index = findIndex(inorder,root);
            TreeNode node = new TreeNode(root);
            node.right = build(postorder, Arrays.copyOfRange(inorder,index+1,inorder.length),postOrderStack);
            node.left = build(postorder,Arrays.copyOfRange(inorder,0,index),postOrderStack);

            return node;
        }
        return null;
    }

    private int findIndex(int [] inorder,int val){
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == val) return i;
        }
        return -1;
    }

    private TreeNode buildBT(int[] inorder, int[] postorder, int stop) {
        if (postIdx < 0) return null;
        if (inorder[inIdx] == stop) {
            inIdx--;
            return null;
        }

        TreeNode node = new TreeNode(postorder[postIdx--]);
        node.right = buildBT(inorder, postorder, node.val);
        node.left = buildBT(inorder, postorder, stop);
        return node;
    }
}
public class ConstructBTFromInOrderPostZOrder {
    public static void main(String[] args) {
        SolutionCBTIP cb = new SolutionCBTIP();
        TreeNode root = cb.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
        System.out.println(root.val);
    }
}
