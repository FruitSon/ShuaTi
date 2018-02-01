package normal;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */

public class LC152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = nums[0], max = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmp = min; //min值被改变
            //min/max在 nums[i], min * nums[i], max * nums[i]里取
            min = Math.min(min * nums[i], Math.min(nums[i],max*nums[i]));
            max = Math.max(max * nums[i], Math.max(nums[i],tmp*nums[i]));
            res = Math.max(res,max);
        }
        return res;
    }
}
