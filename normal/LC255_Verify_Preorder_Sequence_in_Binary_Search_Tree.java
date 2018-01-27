package normal;
/*Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
*/

public class LC255_Verify_Preorder_Sequence_in_Binary_Search_Tree {
	
	public static void main (String args[]){
		System.out.println(verifyPreorder(new int[]{1,2}));
	}
	public static boolean verifyPreorder(int[] arr){
		return verifyHelper(arr, 0, arr.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean verifyHelper(int[] arr, int start, int end, int min, int max){
		if(start > end) return true;
		if(start == end) return arr[start] > min && arr[start] < max;
		int root_val = arr[start];
		int right_start = findBreakPoint(arr, start + 1, end, root_val);
		if(root_val > max || root_val<min) return false;
//		boolean checkleft = verifyHelper(arr,start+1,right_start-1,min,root_val);
//		boolean checkright = verifyHelper(arr,right_start,end,root_val,max);

		return verifyHelper(arr,start+1,right_start-1,min,root_val) && verifyHelper(arr,right_start,end,root_val,max);
			
		}
	
	
	private static int findBreakPoint(int[] arr, int start, int end, int root_val){
		for(int i = start; i <= end; i++){
			if(arr[i] > root_val) return i;
		}
		return arr.length;
	}
}
