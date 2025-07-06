import Entity.TreeNode;

import java.util.Arrays;

class SolutionPBST {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        //return compute(preorder);
        return compute(preorder,Integer.MAX_VALUE);
    }


    private TreeNode compute(int[]preorder,int limit){
        if(index>=preorder.length || preorder[index]>limit ) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = compute(preorder,root.val);
        root.right = compute(preorder,limit);
        return root;

    }
    private TreeNode compute(int[] preorder){
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int leftIndex = findLeftIndex(preorder);
        int rightIndex = findRightIndex(preorder);
        if(leftIndex == Integer.MAX_VALUE) root.left=null;
        else root.left = compute(Arrays.copyOfRange(preorder,leftIndex,rightIndex==Integer.MAX_VALUE?preorder.length:rightIndex));
        if(rightIndex == Integer.MAX_VALUE) root.right=null;
        else root.right = compute(Arrays.copyOfRange(preorder,rightIndex,preorder.length));
        return root;
    }



    private int findLeftIndex(int[]preorder){
        int val = preorder[0];
        int index = Integer.MAX_VALUE;
        for(int i=1;i<preorder.length;i++){
            if(preorder[i]<val){
                index = i;
                break;
            }
        }
        return index;
    }
    private int findRightIndex(int[]preorder){
        int val = preorder[0];
        int index = Integer.MAX_VALUE;
        for(int i=1;i<preorder.length;i++){
            if(preorder[i]>val){
                index = i;
                break;
            }
        }
        return index;
    }

}
public class BSTFROMPREORDER {
    public static void main(String[] args) {
        int[]preorder = new int[]{8,5,1,7,10,12};
        SolutionPBST pbst = new SolutionPBST();
        TreeNode root = pbst.bstFromPreorder(preorder);
        System.out.println(root.val);
    }
}
