class Solution {
    public int maxProfit(int[] prices) {
        int buy_price=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy_price){
                buy_price=prices[i];
            }
            int currentprofit=0;
            currentprofit=prices[i]-buy_price;
            maxProfit=Math.max(maxProfit,currentprofit);
        }
        return maxProfit;
    }
}
