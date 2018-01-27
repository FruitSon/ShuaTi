package normal;

import java.util.Arrays;

/*
Given a circular array (the next element of the last element is the first element of the array), 
print the Next Greater Number for every element. 
The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.

Note: The length of given array won't exceed 10000.
 */

/*
556	Next Greater Element III 
503	Next Greater Element II
496	Next Greater Element I 
*/

// Method 1: copy the array 
// - join 2 arrays(faster) or simply arr[j%len]
// - arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
// Time: O(n^2)
// Space: O(n)

// ✿ Method 2: stack (implemented by array)
// - use array (len' = 2len) to store the index
// Time: O(n^2)
// Space: O(n)
public class LC503_Next_Greater_Element_II {
	// Method 1: brute force 
	public int[] nextGreaterElements1(int[] nums) {
	        int len = nums.length;
	        int[] res = new int[len];
	        Arrays.fill(res,-1);
	        int[] join = new int[len*2];
	        System.arraycopy(nums, 0, join, 0, len);
	        System.arraycopy(nums, 0, join, len, len);
	        
	        for(int i = 0; i < len; i++){
	            for(int j = i; j < i + len; j++){
	                if(join[j] > join[i]){
	                    res[i] = join[j];
	                    break;
	                }
	            }
	        }
	        return res; 
	    }
	    
	    // Method 2: stack
	    public int[] nextGreaterElements2(int[] nums) {
	        //use stack to record index
	        int[] stack = new int[2 * nums.length];
	        int[] res = new int[nums.length];
	        int top = -1;
	        Arrays.fill(res, -1);
	        for (int i = 0; i < nums.length * 2; i++) {
	            int idx = i % nums.length;
	            while (top >= 0 && nums[stack[top]] < nums[idx])
	                res[stack[top--]] = nums[idx];
	            stack[++top] = idx;
	        }
	        return res;
	    }
}
