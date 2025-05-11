import java.util.Arrays;

class SolutionNad {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return maxSum(n-1,nums,dp);
    }

    private int maxSum(int n,int[]nums,int[]dp){
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int pick = maxSum(n-2,nums,dp)+nums[n];
        int notPick = maxSum(n-1,nums,dp);

        return dp[n] = Math.max(pick,notPick);

    }

    public int nonAdjacentTabulation(int[]nums){
        int n = nums.length;
        int[]dp = new int[n+1];

        dp[0] = nums[0];

        for(int i =1;i<n;i++){
            int pick = nums[i];
            if(i>1)
                pick+=dp[i-2];
            int notPick = dp[i-1];

            dp[i] = Math.max(pick,notPick);
        }
        return dp[n-1];

    }
}
public class MaxSumNonAdjexcent {

    public static void main(String[] args) {
        SolutionNad s = new SolutionNad();
        int[]nums = new int[]{1,2,4};
        System.out.println(s.nonAdjacent(nums));
        System.out.println(s.nonAdjacentTabulation(nums));
    }
}
