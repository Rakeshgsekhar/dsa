import Entity.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

class PairNode{
    TreeNode node;
    int token;

    public PairNode(TreeNode node, int token) {
        this.node = node;
        this.token = token;
    }
}


class SolutionPreInPostOrderStack{
    public void allTraversal(TreeNode root){
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        Stack<PairNode> stack = new Stack<>();
        stack.push(new PairNode(root,1));
        while(!stack.isEmpty()){
            PairNode pn = stack.peek();
            if(pn.token == 1){//preOrder
                stack.peek().token++;
                preOrder.add(pn.node.val);
                if(pn.node.left!=null){
                    stack.push(new PairNode(pn.node.left,1));
                }
            }else if(pn.token == 2){ //InOrder
                stack.peek().token++;
                inOrder.add(pn.node.val);
                if(pn.node.right!=null){
                    stack.push(new PairNode(pn.node.right,1));
                }
            }else{//PostOrder
                postOrder.add(pn.node.val);
                stack.pop();
            }
        }

        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }
}
public class PreOrderPostInStack {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4,null,null),new TreeNode(5,null,null)),new TreeNode(3,new TreeNode(6,null,null),
                new TreeNode(7,null,null)));

        SolutionPreInPostOrderStack pipstack = new SolutionPreInPostOrderStack();
        pipstack.allTraversal(root);

    }
}
