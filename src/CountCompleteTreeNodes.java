import Entity.TreeNode;

class SolutionCCTN {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height = computeHeight(root);
        int nodes = 0;
        /**
         * Node at last level
         */
        while(root != null){
            if(computeHeight(root.right) == height-1){
                nodes+=1<<height;
                root = root.right; //left subtree deeper than right subtree.
            }else{
                nodes+=1<< height-1;
                root = root.left; //vice versa of above
            }
            height--;
        }
        return nodes;
    }

    /**
     * Complexity : O(log n)
     * @param node
     * @return
     */
    private int computeHeight(TreeNode node){
        if(node == null) return -1;
        return 1+computeHeight(node.left);
    }
}
public class CountCompleteTreeNodes {
}
