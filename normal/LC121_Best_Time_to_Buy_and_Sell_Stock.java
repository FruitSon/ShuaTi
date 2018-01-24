package normal;
/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/

/*Refer to
LC714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee
LC309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown
LC188_Best_Time_to_Buy_and_Sell_Stock_IV H
LC123_Best_Time_to_Buy_and_Sell_Stock_III H
LC122_Best_Time_to_Buy_and_Sell_Stock_II
LC121_Best_Time_to_Buy_and_Sell_Stock
*/

// At most one transaction. 
// If the transaction can't bring profit just do nothing

// Method 1: min & max array
// Time: O(n)
// Space: O(n)

// ✿ Method 2: dp. Record the minimal value and update profit every time
// Time: O(n)
// Space: O(1)
public class LC121_Best_Time_to_Buy_and_Sell_Stock {
    //Method 1: min & max array
     public int maxProfit1(int[] prices) {
         if(prices==null || prices.length < 2) return 0;
         int len = prices.length;
         int[] buy = new int[len], sell = new int[len];
         buy[0] = prices[0];
         for(int i = 1; i < len; i++)  buy[i] = Math.min(buy[i-1],prices[i]);
         sell[len-1] = prices[len-1];
         for(int i = len-2; i >= 0; i--) sell[i] = Math.max(sell[i+1],prices[i]);
         int res = 0;
         for(int i = 0; i < len-1; i++){
             res = Math.max(res, sell[i]-buy[i]);
         }
         return res;
     }
    
    //Method 2: one pass
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int res = 0, min = Integer.MAX_VALUE;
        int len = prices.length;
        
        for(int i = 0; i < len ; i++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        
        return res;
    }
}
