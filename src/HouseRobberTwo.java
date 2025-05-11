import java.util.Arrays;

class SolutionHRT {
    public int houseRobber(int[] money) {
        int n = money.length;
        if(n==1) return money[0];
        int fromZer0 = solve(money,0,n-2);
        int fromOne = solve(money,1,n-1);

        return Math.max(fromOne,fromZer0);
    }

    private int solve(int[] nums,int start,int end){
        int n = end+1;
        int[] temp = new int[n];
        for(int i = start;i<=end;i++){
            temp[i] = nums[i];
        }
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
//        return maxSum(n-1,temp,dp);
        return maxSumTab(temp);
    }

    private int maxSum(int n,int[]nums,int[]dp){
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n];

        int pick = maxSum(n-2,nums,dp)+nums[n];
        int notPicl = maxSum(n-1,nums,dp);

        return dp[n] = Math.max(pick,notPicl);
    }

    private int maxSumTab(int[]nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1;i<n;i++){
            int pick = nums[i];
            if(i>1)
                pick+=dp[i-2];
            int notPick = dp[i-1];

            dp[i] = Math.max(pick,notPick);
        }
        return dp[n-1];
    }
}
public class HouseRobberTwo {
    public static void main(String[] args) {
        SolutionHRT s = new SolutionHRT();
        int[] money = new int[]{2,1,4,9};
        int[] money2 = new int[]{1, 5, 2, 1, 6};
        System.out.println(s.houseRobber(money));
        System.out.println(s.houseRobber(money2));
    }
}
