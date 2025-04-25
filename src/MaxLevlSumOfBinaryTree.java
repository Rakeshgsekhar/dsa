import Entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLevlSumOfBinaryTree {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int minLevel = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        maxSum = root.val;

        q.add(root);
        while(!q.isEmpty()){
            minLevel++;
            int size = q.size();
            int currentSum = 0;
            for(int i = 0;i<size;i++){
                TreeNode current = q.poll();
                currentSum += current.val;
                if(current.left!=null){
                    q.add(current.left);
                }

                if(current.right!=null){
                    q.add(current.right);
                }

            }
            map.put(minLevel,currentSum);
            maxSum = maxSum<currentSum?currentSum:maxSum;
        }

        int level = Integer.MAX_VALUE;

        for(int key : map.keySet()){
            if(map.get(key) == maxSum){
                level = Math.min(level,key);
            }
        }
        return level;
    }

    public int maxLevelSum2(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int level = 1,minLevel = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){

            int size = q.size();
            int currentSum = 0;
            for(int i = 0;i<size;i++){
                TreeNode current = q.poll();
                if(current != null){
                    currentSum += current.val;
                    if(current.left!=null){
                        q.offer(current.left);
                    }

                    if(current.right!=null){
                        q.offer(current.right);
                    }
                }
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
    }
}
