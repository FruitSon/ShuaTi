package normal;

import java.util.HashMap;
import java.util.Map;

/*
 In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
 */

// Method 1: dp
// *用bit来标记某个数字是否已经使用过
// *用Map来存储已经出现过的状态
// helper(int status, Map<Integer,Boolean> dp, int desiredTotal, int maxChoosableInteger)
// - status已经出现过？
// 	 - 已出现，return 从map里读取的结果
//   - 未出现，try every number less than maximum number, see if there exist one selection that ensure to win
//	 	- built mask 1<<i, mask & status -> 做一个第i位是1的mask，检查现在这个数是不是已经被使用过（被使用过的是1，未使用过是0）
//		- 使用过，continue
//		- 没有使用过，那么下面两种情况都可以认为当前方能赢
//			- 1. 当前数>=desiredTotal, i >= desiredTotal
//			- 2. 对手输 !helper(status|mask,dp,desiredTotal-i,maxChoosableInteger (因为对手也是采用相应的策略，所以可以调用同样的方程, 只是要求结果为false)
// - Time: O(2^n)  （backtracking的话O(n!), 要爆炸啊
public class LC464_Can_I_Win {
//	public static void main(String[] args){
//		int[][] f = new int[][]{{10,11},{10,40},{1,3}};
//		int[][] t = new int[][]{{4,6},{12,24},{10,19},{18,79},{11,25}};
//		int[][] te = new int[][]{{10,19}};
//
//		for(int[] testcase : f){
//			System.out.println(canIWin(testcase[0],testcase[1]));
//		}
//	}
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal)
		    return true;
	    if((maxChoosableInteger)*(maxChoosableInteger+1)/2<desiredTotal)//可选数之和小于目标则必定不可能成功 
		    return false;
        //(maxChoosableInteger+1)位0
        //除了首尾，每一位都表示某个数是否用过
	    int status = (1 << (maxChoosableInteger+1)) ;//初始状态为全1即全部数字都可用 
	    Map<Integer,Boolean> dp = new HashMap<>();
        return helper(status,dp,desiredTotal,maxChoosableInteger);
    }
    
    private boolean helper(int status, Map<Integer,Boolean> dp, int desiredTotal, int maxChoosableInteger){
        if(dp.containsKey(status)) return dp.get(status);
        for(int i = 1; i <= maxChoosableInteger; i++){
            int mask = (1<<i);
            //check if the number has already been used (used number are set to 1)            
            if((mask&status)!=0) continue;
            //>desriedTotal的数现在就可以选，直接选了就赢 || 对方没有赢
            if( i >= desiredTotal || !helper(status|mask,dp,desiredTotal-i,maxChoosableInteger) ){
				dp.put(status,true);
				return true;
			} 
        }
        dp.put(status,false);
        return false;
    }
}
