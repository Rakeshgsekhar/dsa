import Entity.TreeNode;
import java.util.*;

class SolutionBurnTree {
    static TreeNode[] valMap = new TreeNode[100000];
    public static int minTime(TreeNode root, int target) {
        // code here
       /* TreeNode[] parent = new TreeNode[100000];
        boolean[] visited = new boolean[100000];
        int totalTime = 0;
        findParentDFS(root,null,parent);
        totalTime = burnTree(valMap[target],totalTime,visited,parent);
        return totalTime;*/
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode[] actualTarget = new TreeNode[1];  // Holder for the reference of target node in the tree

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val == target) {
                actualTarget[0] = curr;
            }
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.add(curr.right);
            }
        }

        queue.add(actualTarget[0]);
        visited.add(actualTarget[0]);

        int time = -1;  // we increment at each level

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Check left
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                    visited.add(curr.left);
                }

                // Check right
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                    visited.add(curr.right);
                }

                // Check parent
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
            }
        }

        return time;

    }

    private static void findParentDFS(TreeNode node,TreeNode par,TreeNode[] parent){
        if(node == null) return;
        valMap[node.val] = node;
        parent[node.val] = par;
        findParentDFS(node.left,node,parent);
        findParentDFS(node.right,node,parent);
    }
    private static int burnTree(TreeNode target, int sec,boolean[] visited,TreeNode[] parent){
        if(target == null) return -1;
        if(visited[target.val]) return -1;
        visited[target.val] = true;
        int parentTime = burnTree(parent[target.val],sec+1,visited,parent);
        int leftChildTime = 0,righChildTime =0;
        if(target.left != null && !visited[target.left.val])leftChildTime = burnTree(target.left,sec+1,visited,parent);
        if(target.right !=null &&!visited[target.right.val])righChildTime = burnTree(target.right,sec+1,visited,parent);
        return 0;
    }
}
public class BuriningTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
       // SolutionBurnTree bt = new SolutionBurnTree();
        System.out.println(SolutionBurnTree.minTime(root,2));
    }
}
