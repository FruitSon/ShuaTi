package normal;
/*Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
*/

// Method 1: recursion
// Time: O(n)

// Method 2: iteration
// Time: O(n)
// Space: O(1)

public class LC255_Verify_Preorder_Sequence_in_Binary_Search_Tree {
	
	//recursion: 161ms
	public boolean verifyPreorder1(int[] arr){
		return verifyHelper(arr, 0, arr.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean verifyHelper(int[] arr, int start, int end, int min, int max){
		if(start > end) return true;
		else if(start == end) return arr[start] > min && arr[start] < max;
        else{
            int root_val = arr[start];
            if(root_val > max || root_val<min) return false;

            int right_start = start;
            for(; right_start <= end; right_start++){
                if(arr[right_start] > root_val) break;
            }

            boolean checkleft = verifyHelper(arr,start+1,right_start-1,min,root_val);
            if(!checkleft) return false;
            return verifyHelper(arr,right_start,end,root_val,max);			
        }
    }
	
    
    //another version: recursion 511ms
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private boolean helper(int[] nums, int start, int end){
        if(start >= end) return true;
        int root = nums[start];
        int i;
        for( i = start + 1; i <= end; i ++){
            if(nums[i] > root)
                break;
        }
        //worst: 递增序列
        for(int j = i; j <= end; j ++)
            if(nums[j] < root)
                return false;
        return helper(nums, start + 1, i - 1) && helper(nums, i, end);
    }

    //iteration 3ms
    public boolean verifyPreorder3(int[] arr){
        int root = Integer.MIN_VALUE;
        int idx = -1;
        for(int i : arr){
            if(i < root) return false;
            while(idx >= 0 && root > arr[idx]){
                root = arr[idx--];
            }
            arr[++idx] = i;
        }
        return true;
    }
}
