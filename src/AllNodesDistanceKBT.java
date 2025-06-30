import Entity.TreeNode;

import java.util.*;

class SolutionANDK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        /**
         * Since from the example I need to travel back to root from target, using BT approach is not feassible one.
         * Another option I have here is to convert the tree into graph reprasentaion where each change and parent if present as adjecent nodes. there by we acn traverse in all direction, pluse where travesing through the adjencency list, keep track of k. when k==0 we found node k distance from target.
         */

        List<Integer> result = new ArrayList<>(); // Store result k distance node values
        Map<Integer,TreeNode> parent = new HashMap<>(); //track parent
        Queue<TreeNode> queue = new LinkedList<>(); // traverse the BT

        queue.offer(root);
        /**
         * Building the map similar to adjeceny matrix reprasentation of Graph
         */
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode top = queue.poll();
                if(top.left!=null){
                    parent.put(top.left.val,top);
                    queue.offer(top.left);
                }
                if(top.right!=null){
                    parent.put(top.right.val,top);
                    queue.offer(top.right);
                }
            }
        }

        Map<Integer,Integer> visited = new HashMap<>();
        queue.offer(target);
        while(k>0 && !queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode top = queue.poll();
                visited.put(top.val, 1);
                if(top.left!=null && !visited.containsKey(top.left.val)){
                    queue.offer(top.left);
                }
                if(top.right!=null && !visited.containsKey(top.right.val)){
                    queue.offer(top.right);
                }

                if(parent.containsKey(top.val) && !visited.containsKey(parent.get(top.val).val)){
                    queue.offer(parent.get(top.val));
                }
            }
            k--;
        }
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
}
public class AllNodesDistanceKBT {
}
