package normal;

/*
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
 */

/*
337	House Robber III    		
213	House Robber II
198	House Robber 
*/

//circular
//分别计算抢第二家到最后一家与抢第一家到倒数第二家的最大值，取两个值中更大的那个就是结果。  

public class LC213_House_Robber_II {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
         if(nums.length == 1) return nums[0];
     return Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1));

     }
     
     private int helper(int[] nums, int start, int end){
         int rob = 0,avoid = 0;
         for(int i = start; i <= end; i++){
             int tmp_avoid = avoid;
             avoid = Math.max(avoid,rob);
             rob = tmp_avoid + nums[i];
         }
         return Math.max(rob,avoid);
     }
}
