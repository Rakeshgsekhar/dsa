import Entity.TreeNode;

import java.util.*;
import java.util.stream.Stream;

class SolutionHR3 {
    public int rob(TreeNode root) {
        Map<TreeNode,Map<Boolean,Integer>> dp = new HashMap<>();
        return compute(root,true,dp);
    }

    private int compute(TreeNode node,boolean shouldRobe,Map<TreeNode,Map<Boolean,Integer>> dp){
        if(node == null) return 0;
        if(dp.containsKey(node) && dp.get(node).containsKey(shouldRobe)) return dp.get(node).get(shouldRobe);
        int robbed = 0;
        if(shouldRobe)
            robbed += node.val;
        robbed += compute(node.left,false,dp)+compute(node.right,false,dp);
        int notrobbed = compute(node.left,true,dp)+compute(node.right,true,dp);

        int total = Math.max(robbed,notrobbed);
        Map<Boolean,Integer> mp = dp.getOrDefault(node,new HashMap<>());
        mp.put(shouldRobe,total);
        dp.put(node,mp);
        return total;
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int[][] lisans = new int[n/2][3];
        int nk = 0;
        for (int i = 0; i < nums.length; i += 3) {
            if ( nums[i + 2] - nums[i] > k) {
                return new int[n/2][3];
            }
            lisans[nk++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            ans.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
        }


//        ans.stream().mapToInt();
        return lisans;
    }
}
public class HouseRobber3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(2,null,new TreeNode(3,null,null)),new TreeNode(3,null,new TreeNode(1,null,null)));
        SolutionHR3 hr3 = new SolutionHR3();
        System.out.println(hr3.rob(root));
        List<List<Integer>> ans  = new ArrayList<>();


    }
}
