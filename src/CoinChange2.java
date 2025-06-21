import java.util.*;

class SolutionCC2 {
    public int change(int amount, int[] coins) {
        /*if(amount == 0) return 1;
        List<String>memo = new ArrayList<>();
        compute(coins,amount,new ArrayList<>(),memo);
        int combinations = memo.size();
        return combinations;*/
        if(amount==0){
            return 1;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        for(int [] arr: dp){Arrays.fill(arr,-1);}
        return compute(amount,coins,coins.length-1,dp);
    }

    private int compute(int amount, int[] coins, int idx,int[][]dp){
        if(idx == 0){
            if(amount == 0 || amount%coins[idx] == 0){
                return 1;
            }
            return 0;
        }

        if(dp[idx+1][amount] != -1) return dp[idx+1][amount];

        int notPick = compute(amount,coins,idx-1,dp);
        int pick = 0;
        if(coins[idx]<=amount){
            pick = compute(amount-coins[idx],coins,idx,dp);
        }
        return dp[idx+1][amount] = pick+notPick;
    }
}
public class CoinChange2 {
    public static void main(String[] args) {
        SolutionCC2 ccs = new SolutionCC2();
        ccs.change(5,new int[]{1,2,5});
    }
}
