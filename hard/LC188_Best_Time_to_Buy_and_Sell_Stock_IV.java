package hard;

/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

/*Refer to
LC714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee
LC309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown
LC188_Best_Time_to_Buy_and_Sell_Stock_IV H
LC123_Best_Time_to_Buy_and_Sell_Stock_III H
LC122_Best_Time_to_Buy_and_Sell_Stock_II
LC121_Best_Time_to_Buy_and_Sell_Stock
*/

// k transactions

// Method 1: state machine (dp)
// * when k >= len/2 => you can make as many transaction as you need. So the problem transformed into LC 122.
// Time: O(KN) (->O(N))
// Space: O(N)
public class LC188_Best_Time_to_Buy_and_Sell_Stock_IV {
    
    public int maxProfit(int k, int[] prices) {
         if(prices==null || prices.length < 2 || k==0) return 0;
        int len = prices.length;
        
        // when k >= len/2 => you can make as many transaction as you need
        if (k >=  len/2) {
		    int maxPro = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
	    }
        
        int[] profits = new int[Math.min(k*2,prices.length/2*2)];
        int state_cnt = profits.length;
        for(int i = 0; i < state_cnt ; i+=2){
            profits[i] = -prices[0];
        }
                 
        for(int i = 1 ;i < len; i ++){
            for(int j = state_cnt-1; j >= 1; j=j-2){
                profits[j] = Math.max(profits[j],profits[j-1]+prices[i]);
            }
            for(int j = state_cnt-2; j >= 1; j=j-2){
                profits[j] = Math.max(profits[j],profits[j-1]-prices[i]);
            }
            profits[0] = Math.max(profits[0],-prices[i]);
        }
        return profits[profits.length - 1];
    }
}
