package normal;

/*Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:
Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

Example 2:
Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */

//Method 1: w swap, ensure the value filled from i to j is i to j.
//Method 2: w/o swap, check the max value within the current range and decide whether to extend current range
//Method 3: w/o index, optimized method 2
//Method 1: find all slots we can make it a cut
//Time: O(N)

//Testcase
// [4,3,2,1,0]
// [1,5,2,3,7,0,4,6]
// [1,2,3,0]
// [0,1,2]
// [4,3,2,1,0]
// [1,0,2,3,4]
// [2,6,1,3,0,5,4]
public class LC769_Max_Chunks_To_Make_Sorted {
	//Method 1: w swap, ensure the value filled from i to j is i to j.
	//Method 1: with swap
	public int maxChunksToSorted1 (int[] arr) {
        int cnt = 0;
        int[] idx = new int[arr.length];
        // rule: arr[i] = i
	    for(int i = 0; i < arr.length; i ++){
	        idx[arr[i]] = i;
	    }
	    for(int i = 0; i < arr.length; i++){
	        if(arr[i]!=i)
	            i = findRange(idx, arr, i) ;
	        cnt ++;
	    }
	    return cnt;
	}

	//return the end index of a valid chunk
	private int findRange(int[] idx, int[] arr, int start){
	    int max = -1;
	    int i = start;
	    while(arr[i]!= i){
	        int val = arr[i];
	        swap(arr, i, idx[i]);
	        swap(idx, val, i);
	        i = val;
	        max = Math.max(val, max);
	    }
	    
	    //check if the values between idx = startIdx | endIdx is expected;
	    for(int j = start; j <= max; j++){
	        if(arr[j]!=j) 
	            max = Math.max(findRange(idx, arr, j),max);
	    }
	        
	    return max;
	}

	//swap the element in an arr
	private void swap(int[] arr, int i, int j){
	    int tmp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = tmp;
	    return;
	}
	
	
	//Method 2: no swap, find max(idx) recursively
    public int maxChunksToSorted2(int[] arr) {
        if(arr.length <= 1) return arr.length;
        
        int len = arr.length, cnt = 0;
        int[] idx = new int[len];
        for(int i = 0; i < arr.length; i ++) idx[arr[i]] = i;
        
        //loop over the array. and there are two situation:
        //1. arr[i] > i, we try to find a valid chunk to cover arr[i]
        //2. arr[i] == i, this element is already on its expected position and can be regarded as a single chunk
        for(int i = 0; i < len ; i++){
            if(arr[i] > i){
                i = Math.max(maxInRange(i,idx[i],arr),idx[i]);
                cnt ++;
            }else if(arr[i]==i) cnt ++;
        }
        return cnt;
    }
    
    // find the end index of a valid chunk
    // 1.for arr[i], the expected value is i. According to the helper array idx, the current index of i is idx[i]
    //	 (idx[i] is bigger than i if i haven't been grouped into a existed chunk)
    // 2.now all elements between i and idx[i] should be grouped into a chunk. 
    // 3.We then check if the current chunk [i, idx[i]] need to be extended.
    // - if every element in the current chunk is less than idx[i], it indicates we can get a array from i to idx[i] after sorting
    // - if there is any element bigger than idx[i], it indicates means we need to further extend this chunk. Say the maximum value between [i,idx[i]] is M, the extended chunk should be [i,M]
    // 4.Repeat step 3 until we find the chunk is valid and doesn't need extension. And return the end index of this chunk.
    private int maxInRange(int start, int end, int[] arr){
        int max = -1;
        for(int i = start; i <= end; i ++) max = Math.max(arr[i],max);
        return max <= end ? max : Math.max(max, maxInRange(end,max,arr));
    }
    
    //Method 3: optimized method 2
	public int maxChunksToSorted3(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		int count = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			if (max == i) {
				count++;
			}
		}
	  return count;
	}  
	
	//Method 4: find all slots we can make it a cut
    public int maxChunksToSorted4(int[] arr) {
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
