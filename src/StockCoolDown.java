import java.util.Arrays;

class SolutionCD {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        for(int[] row:dp) Arrays.fill(row,-1);
        return computeStock(0,1,prices,dp);
    }
    private int computeStock(int day,int transaction,int[] prices,int[][]dp){
        if(day == prices.length) return 0;
        if(dp[day][transaction] != -1) return dp[day][transaction];
        int profit = 0;
        if(transaction ==1){ //buy
            int buy = -prices[day]+computeStock(day+1,2,prices,dp);
            int dontBuy = computeStock(day+1,1,prices,dp);
            profit = Math.max(buy,dontBuy);
        }else if(transaction == 2){//sell
            int sell = prices[day]+computeStock(day+1,0,prices,dp);
            int dontSell = computeStock(day+1,2,prices,dp);
            profit = Math.max(sell,dontSell);
        }else{//cooldown
            profit = computeStock(day+1,1,prices,dp);
        }
        return dp[day][transaction] = profit;
    }

}
public class StockCoolDown {
    public static void main(String[] args) {
        SolutionCD cd = new SolutionCD();
        System.out.println(cd.maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(cd.maxProfit(new int[]{1}));
    }
}
