package normal;
import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

//排序 + two pointer
//Time: O(N^2)
//Space: O(1)
public class LC016_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	int sum = Integer.MAX_VALUE, delta = Integer.MAX_VALUE;
    	for(int i = 0; i < nums.length; i++){
    		for(int pt1 = i + 1, pt2 = nums.length-1; pt1 < pt2;){
    			int tmp = nums[i] + nums[pt1] + nums[pt2];
    			if(Math.abs(tmp-target) < delta){
    				sum = tmp;
    				delta = Math.abs(tmp-target);
    			}
    			if(tmp < target) pt1++;
    			else if(tmp > target) pt2--;
    			else return target;
    		}
    	}
    	return sum;
    }
}
