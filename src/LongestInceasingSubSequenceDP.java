import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionLISD {
    public int lengthOfLIS(int[] nums) {
        int maxLen = Integer.MIN_VALUE;
        /*for(int i = 0;i<nums.length;i++){
            List<Integer> list = new ArrayList<>();
            int len = compute(i,nums,list);
            maxLen = Math.max(maxLen,len);
       /* }*/
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++)
            Arrays.fill(dp[i],-1);
        int len = compute(0,-1,nums,dp);
        maxLen = Math.max(maxLen,len);
        return maxLen;
    }

    private int compute(int index,int prev, int[]nums,int[][] dp){
        if(index == nums.length)return 0;
        if(dp[index][prev+1]!=-1) return dp[index][prev+1];

        int len = 0;
        len = 0+compute(index+1,prev,nums,dp);
        if(prev == -1 || nums[index]>nums[prev]){
            len = Math.max(len,1+compute(index+1,index,nums,dp));
        }
        return dp[index][prev+1] = len;
    }
}
public class LongestInceasingSubSequenceDP {
    public static void main(String[] args) {
        SolutionLISD lis = new SolutionLISD();

       // System.out.println( lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println( lis.lengthOfLIS(new int[]{0,1,0,3,2,3}));
      //  System.out.println(lis.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
