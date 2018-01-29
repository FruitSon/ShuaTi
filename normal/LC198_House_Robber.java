package normal;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.
 
 */

/*
337	House Robber III    		
213	House Robber II
198	House Robber 
*/

// state machine
// - rob[i] = Math.max(rob[i-2], not_rob[i-1]) + nums[i] = not_rob[i-1] + nums[i]
// - not_rob[i] = Math.max(rob[i-1],not_rob[i-1])

// Method 1: w array
// - Time : O(n)
// - Space : O(n)

//Method 2/3: w/o array
//- Time : O(n)
//- Space : O(1)
public class LC198_House_Robber {
	// Method 1
    public int rob1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] rob = new int[nums.length];
        int[] avoid = new int[nums.length];
        rob[0] = nums[0];
        avoid[0] = 0;
        for(int i = 1; i < nums.length; i++){
            //对房子i
            //rob: rob(i-2) + nums[i]
            rob[i] = Math.max(i>1?rob[i-2]:0 + nums[i],avoid[i-1]+nums[i]);
            avoid[i] = Math.max(avoid[i-1],rob[i-1]);
        }
        return Math.max(rob[nums.length-1],avoid[nums.length-1]);
    }
    
	// Method 2
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int pre_rob = -1;
        int rob = nums[0],avoid = 0;
        for(int i = 1; i < nums.length; i++){
            //rob: rob[i-2] + nums[i] = avoid[i-1] + nums[i]
            int tmp_avoid = avoid, tmp_rob = rob;
            avoid = Math.max(avoid,rob);
            rob = Math.max(i>1?pre_rob:0,tmp_avoid) + nums[i];
            rob = tmp_avoid + nums[i];
            pre_rob = tmp_rob;
        }
        return Math.max(rob,avoid);
    }
    
	// Method 3
    public int rob3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int rob = nums[0],avoid = 0;
        for(int i = 1; i < nums.length; i++){
            int tmp_avoid = avoid;
            avoid = Math.max(avoid,rob);
            rob = tmp_avoid + nums[i];
        }
        return Math.max(rob,avoid);
    }
}
