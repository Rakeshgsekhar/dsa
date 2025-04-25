import Entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            TreeNode view = null;
            while(n-->0){
                view = q.poll();
                if(view.left != null) q.add(view.left);
                if(view.right != null) q.add(view.right);
            }
            list.add(view.val);
        }
        return list;
    }
}
