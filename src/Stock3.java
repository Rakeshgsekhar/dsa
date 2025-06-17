import java.util.Arrays;

class SolutionStock3 {
    public int maxProfit(int[] prices) {
       /* int[][][]dp = new int[prices.length][2][3];
        //for(int row[] : dp) Arrays.fill(row,-1);
        return computeStock(0,2,1,prices,dp);*/
        int n = prices.length;
        int[][][]dp = new int[prices.length+1][2][3];
        int[][]buyStocks = new int[2][3];
        int[][] sellStock = new int[2][3];
        /*for(int i = 0;i<=n;i++){
            for(int j = 0;j<2;j++){
                dp[i][j][0] = 0;
            }
        }

        for(int i = 0;i<2;i++){
            for(int j = 0;j<3;j++){
                dp[n][i][j] = 0;
            }
        }*/
        for(int j = 0;j<2;j++){
           buyStocks[j][0] = 0;
           sellStock[j][0] = 0;
        }
        for(int day = n-1;day>=0;day--){
            for(int buy = 0;buy<=1;buy++){
                for(int cap = 1;cap<=2;cap++){
                    if(buy == 1){
                        int buyStock = -prices[day]+buyStocks[0][cap];//,prices,dp);
                        int dontBuy = 0+buyStocks[1][cap];//,prices,dp);
                        buyStocks[buy][cap] = Math.max(buyStock,dontBuy);
                    }else if(buy == 0){
                        int sell = prices[day]+sellStock[1][cap-1];//;,cap-1,1,prices,dp);
                        int dontSell = 0+sellStock[0][cap];//cap,0,prices,dp);
                        sellStock[buy][cap]=Math.max(sell,dontSell);
                    }
                }
            }
            buyStocks = sellStock;
        }
      //  return dp[0][1][2];
        return buyStocks[1][2];
    }

    private int computeStock(int day,int cap, int buy,int[]prices,int dp[][][]){
        if(cap == 0) return 0;
        if(day == prices.length) return 0;
        if(dp[day][buy][cap]!=0) return dp[day][buy][cap];
        int profit = 0;
        if(buy == 1){
            int buyStock = -prices[day]+computeStock(day+1,cap,0,prices,dp);
            int dontBuy = 0+computeStock(day+1,cap,buy,prices,dp);
            profit += Math.max(buyStock,dontBuy);
        }else if(buy == 0){
            int sell = prices[day]+computeStock(day+1,cap-1,1,prices,dp);
            int dontSell = 0+computeStock(day+1,cap,0,prices,dp);
            profit+=Math.max(sell,dontSell);
        }

        return dp[day][buy][cap] = profit;
    }
}
public class Stock3 {

    public static void main(String[] args) {
        SolutionStock3 stock3 = new SolutionStock3();
        System.out.println(stock3.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
