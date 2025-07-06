import java.util.Arrays;

class SolutionFROG {
    public int frogJump(int[] heights) {

        int n = heights.length;
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        int energy = jump(n-1,heights,dp);
        return energy;
    }

    private int jump(int n,int[]heights,int[]dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int jumpOne = jump(n-1,heights,dp)+ Math.abs(heights[n-1]-heights[n]);
        int jumpTwo = Integer.MAX_VALUE;
        if(n>1)
            jumpTwo = jump(n-2,heights,dp)+ Math.abs(heights[n-2]-heights[n]);
        return dp[n] = Math.min(jumpOne,jumpTwo);
    }

    private int jump2(int n,int[]heights,int[]dp,int k){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int mSteps = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++){
            int steps = jump2(n-i,heights,dp,k)+Math.abs(heights[n]-heights[n-i]);
            mSteps = Math.min(mSteps,steps);
        }
        return dp[n] = mSteps;
    }
}
public class FromJump {
    public static void main(String[] args) {
        SolutionFROG s = new SolutionFROG();
        int[]heights = new int[]{2, 1, 3, 5, 4};
        int[] heights1 = new int[]{7, 5, 1, 2, 6};
        System.out.println(s.frogJump(heights));
        System.out.println(s.frogJump(heights1));
    }
}
