import java.util.Arrays;

class SolutionCCH {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        /*if(amount == 0) return 0;
         dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = compute(coins,amount,0);
        return ans == Integer.MAX_VALUE ? -1:ans;*/

        if(amount == 0) return 0;
        dp = new int[amount+1];
        Arrays.fill(dp,amount + 1);

        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(i-coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }
    private int compute(int[] coins,int amount,int num){

        if(amount == 0){
            return 0;
        }
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount] != -1) return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for(int i = 0;i<coins.length;i++){
            int ans = compute(coins,amount-coins[i],num+1);
            if(ans != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins,ans+1);
            }
        }
        return dp[amount]=minCoins;
    }
}
public class CoinChange {
    public static void main(String[] args) {
        SolutionCCH cch = new SolutionCCH();
        System.out.println(cch.coinChange(new int[]{1,2,5},11));
        System.out.println(cch.coinChange(new int[]{2},3));
    }
}
