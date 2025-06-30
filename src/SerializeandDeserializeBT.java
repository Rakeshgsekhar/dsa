import Entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /**
         * 1. if root is null return "[]"
         * 2. if any child is null it should reprasemt the same. [1,null,3,4,5]
         */

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                result.append(node.val);
                result.append(",");
            }
            else {
                   result.append("null");
                   result.append(",");
            }

            if(node!=null)queue.offer(node.left);
            if(node!=null)queue.offer(node.right);

        }
      //  result.replace(result.length()-1,result.length(),"]");
        return result.toString();

    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(depth(root.left),depth(root.right));
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len = data.length();
        int start = 1;
        int end = len-2;
        Queue<String> queue = new LinkedList<>();
        String[] st = data.substring(start,end+1).split(",");
        for(String str : st){
            queue.offer(str);
        }
        return construct(queue);
    }

    private TreeNode construct(Queue<String> queue){
      String val = queue.poll();
      if(val.equals("null")) return null;
      TreeNode node = new TreeNode(Integer.parseInt(val));
      node.left =  construct(queue);
      node.right = construct(queue);
      return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
public class SerializeandDeserializeBT {
    public static void main(String[] args) {
        Codec codex = new Codec();
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3,new TreeNode(4),new TreeNode(5)));
        String serialized = codex.serialize(root);
        TreeNode node = codex.deserialize(serialized);

        System.out.println(node.val);
    }
}
