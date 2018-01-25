package hard;

/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

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

// two transactions

// Method 1: state machine (dp)
// Have 4 states: hold1, release1, hold2, release2. (update in reverse order as it rely on previous states)
// release2 = Math.max(hold2+prices[i],pre_release2);
// hold2 = Math.max(pre_release1-prices[i],pre_hold2);
// release1 = Math.max(pre_hold1+prices[i],pre_release1);
// hold1 = Math.max(-prices[i],pre_hold1);
// Time: O(N)
// Space: O(N) -> O(1)
public class LC123_Best_Time_to_Buy_and_Sell_Stock_III {
    
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int len = prices.length;
        //profit[0]:buy1,profit[1]:sell1,profit[2]:buy2,profit[3]:sell2
        int[][] profit = new int[4][len];
        
        profit[0][0] = -prices[0];
        profit[2][0] = -prices[0];
        profit[1][0] = 0;
        profit[3][0] = 0;
            
        for(int i = 1; i < len; i ++){
            profit[0][i] = Math.max(-prices[i],profit[0][i-1]);
            profit[1][i] = Math.max(profit[0][i-1]+prices[i],profit[1][i-1]);
            profit[2][i] = Math.max(profit[1][i-1]-prices[i],profit[2][i-1]);
            profit[3][i] = Math.max(profit[2][i-1]+prices[i],profit[3][i-1]);
        }
        return profit[3][len-1];
    }  
}
