package normal;

/*Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
*/

/*Refer to
LC714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee
LC309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown
LC188_Best_Time_to_Buy_and_Sell_Stock_IV H
LC123_Best_Time_to_Buy_and_Sell_Stock_III H
LC122_Best_Time_to_Buy_and_Sell_Stock_II
LC121_Best_Time_to_Buy_and_Sell_Stock
*/

// many transactions
// transaction fee for each transaction

//✿ Method 1: state machine. refer to 309 
//hold[i] = max(sell[i-1]-prices[i],hold[i-1])
//sell[i] = max(hold[i-1]+prices[i]-fee,sell[i-1])
//Time: O(N)
//Space: O(N) -> O(1) 滚动数组降维

public class LC714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
	//Method 1: state machine
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length < 2) return 0;
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        sell[0] = 0;

        for(int i = 1; i < len; i++){
            buy[i] = Math.max(sell[i-1]- prices[i], buy[i-1]);
            sell[i] = Math.max(buy[i-1]+prices[i]-fee, sell[i-1]);
        }
        return  sell[len-1];
    }
}
