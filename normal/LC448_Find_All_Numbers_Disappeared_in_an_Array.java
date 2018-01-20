package normal;

import java.util.LinkedList;
import java.util.List;

/* Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/

// Method 1: 挖坑填坑 swap
// nums[i]应该放的number的value = i+1 (i = 0, 1, ... arr.length - 1)
// 如果idx = i 和 idx = nums[i]-1两个位置上的数值都不对 -> swap:保证至少一个number是在它应该在的位置上
// one more pass to generate the expected result
// * 有点像first missing number
// Time: O(n)
// Space: O(1)

//Method 2: Set
// Time: O(n)
//Space: O(n)
public class LC448_Find_All_Numbers_Disappeared_in_an_Array {
	//Method 1: swap
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i]!=i+1 && nums[nums[i]-1] != nums[i]){
                swap(nums, i, nums[i]-1);
                i--;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=i+1) res.add(i+1);
        }
        return res;
    }
    
    private void swap(int[] nums, int i, int j){
         int tmp = nums[j];
         nums[j] = nums[i];
         nums[i] = tmp;
    }
}
