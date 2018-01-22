package hard;
/*This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily distinct, the input array could be up to length 2000, and the elements could be up to 10**8.

Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:
Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.

Example 2:
Input: arr = [2,1,3,4,4]
Output: 4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 2000].
arr[i] will be an integer in range [0, 10**8].
*/

// ***Method 1: (~sliding window)
// Consider the definition of a chunk. A cut can be made when all element left to the element A is less than all element right to element A
// So use two iteration to find the max / min value of each position
// One iteration to find the number of cut can be made (return cnt + 1 as there is still 1 chunk even no cut is made)
// Time: O(n)

//*the method for Max_Chunks_To_Make_Sorted can not be directly used here 
//as it isn't a strict permutation when the array contains duplicates 

//also refer to 239	Sliding Window Maximum ,123 Best Time to Buy and Sell Stock III
public class LC768_Max_Chunks_To_Make_Sorted_II {	
	//Method 1: find all slots we can make it a cut
    public int maxChunksToSorted(int[] arr) {
    	if(arr==null) return 0;
    	int len = arr.length;
    	int[] leftMax = new int[len], rightMin = new int[len];
    	
    	leftMax[0] = arr[0];
    	for(int i = 1; i < len; i++)
    		leftMax[i] = Math.max(arr[i], leftMax[i-1]);
    	
    	rightMin[len-1] = arr[len-1];
    	for(int i = len-2; i >= 0; i--)
    		rightMin[i] = Math.min(arr[i], rightMin[i+1]);
    	
    	int cnt = 0;
    	for(int i = 0; i < len-1; i++){
    		if(leftMax[i] <= rightMin[i+1]) cnt++;
    	}
    	return cnt + 1;
    }
}
