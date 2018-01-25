package normal;

/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:
prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
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
// cannot buy stock the next day you sell the stock (cooldown day = 1)

// https://www.youtube.com/watch?v=oL6mRyTn56M

// Method 1:
// Store the profits in  if the operation on day i is sell. 
// Time: O(N^2)
// Space: O(N)

// ✿ Method 2: state machine. there are three states : hold,rest,sold, track the maximum profits by update the max profits of different operations on day i.
// hold[i] = max(sell[i-2]-prices[i],hold[i-1])
// sell[i] = max(hold[i-1]+prices[i],sell[i-1])
// Time: O(N)
// Space: O(N) -> O(1) 滚动数组降维

public class LC309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
  //Method 1: 传统dp
  public int maxProfit1(int[] prices) {
      if(prices == null || prices.length < 2) return 0;
      int cooldown = 1, len = prices.length;
      int[] profits = new int[len+cooldown+1];
      for(int i = 1; i < len ; i++){
          int tmp = 0;
          for(int j = 0; j < i ; j ++){
              tmp = Math.max(profits[j] + prices[i] - prices[j] , tmp );
          }           
          tmp = Math.max(tmp, profits[i+1]);
          profits[i+cooldown+1] = tmp;
      }
      return profits[len+1];
  }
  
  //Method 2: state machin
  public int maxProfit2(int[] prices) {
     if(prices == null || prices.length < 2) return 0;
     int len = prices.length;
     int[] buy = new int[len];
     int[] sell = new int[len];
     buy[0] = -prices[0];
     sell[0] = 0;

     for(int i = 1; i < len; i++){
         buy[i] = Math.max((i>=2?sell[i-2]:0)-prices[i], buy[i-1]);
         sell[i] = Math.max(buy[i-1]+prices[i], sell[i-1]);
     }
     return  sell[len-1];
  }
  
  //Method 3: state machine, 滚动数组
  public int maxProfit3(int[] prices) {
      int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
      for (int price : prices) {
          prev_buy = buy;
          buy = Math.max(prev_sell - price, prev_buy);
          prev_sell = sell;
          sell = Math.max(prev_buy + price, prev_sell);
      }
      return sell;
  }
  
}
