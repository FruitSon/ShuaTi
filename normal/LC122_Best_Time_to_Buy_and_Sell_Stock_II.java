package normal;
/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/

/*Refer to
LC714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee
LC309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown
LC188_Best_Time_to_Buy_and_Sell_Stock_IV H
LC123_Best_Time_to_Buy_and_Sell_Stock_III H
LC122_Best_Time_to_Buy_and_Sell_Stock_II
LC121_Best_Time_to_Buy_and_Sell_Stock
*/

// Many transactions
// Sell before buy

// Method 1: Find all monotonous ascending subarray (find peak)
// Time: O(n)
// Space: O(1)

// ✿ Method 2: Simply accumulating every single ascending section
// Time: O(n)
// Space: O(1)

public class LC122_Best_Time_to_Buy_and_Sell_Stock_II {
    // Method 1: Find all monotonous ascending subarray (find peak)
     public int maxProfit1(int[] prices) {
         if(prices == null || prices.length < 2) return 0;
         int res = 0, min = 0x80000000, len = prices.length;
         
         for(int i = 0; i < len ; i++){
             min = prices[i];
             while(i+1 < len && prices[i]<prices[i+1]) i++;
             res += (prices[i] - min);
         }
         return res;  
     }
    
    // Method 2: Simply accumulating every single ascending section
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int res = 0, len = prices.length;
        
        for(int i = 0; i < len-1; i++)
            if(prices[i]<prices[i+1]) res+= prices[i+1]-prices[i];
        
        return res;
    }
}
