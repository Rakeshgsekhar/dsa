public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int buyPrice = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buyPrice = Math.max(buyPrice, sell - price);
            sell = Math.max(sell, buyPrice + price - fee);
        }
        return sell;
    }
}
