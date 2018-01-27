package normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
*/

/*
556	Next Greater Element III 
503	Next Greater Element II
496	Next Greater Element I 
*/

// ✿ Method 1 
// use map to keep <value, index> pairs in nums1 
// loop over num2
// - use stack to keep the numbers which haven't find their greater value. 
// - when the nums2[i] > stack.peek(), the nextGreaterValue of stack.peek() is nums2[i]. 
// - set greaterValue by the index and remove this value from stack
// Time: O(m) (each value will be pushed into/poped from stack at most once
// Space: O(max(m,n))

// Method 2: Brute force
// map + loop
// use map to keep store <value, index> pairs in nums2
// for each num in nums1, try to find nextGreaterValue starting from the index of num in nums2
// Time: O(n^2)
// Space: O(n)
public class LC496_Next_Greater_Element_I {
    
    // O(N): 
    // use stack to keep the numbers existed in nums1. 
    // loop over num2, when the nums2[i] > stack.peek(), the nextGreaterValue of stack.peek() is nums2[i]
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> buffer = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        Map<Integer, Integer> map = new HashMap<>();
        initialize(nums1,map);
        
        for(int i = 0 ; i < nums2.length ; i ++){
            while(!buffer.empty() && buffer.peek()<nums2[i]){
                if(map.containsKey(buffer.peek())) res[map.get(buffer.peek())] = nums2[i];
                buffer.pop();
            }
            if(map.containsKey(nums2[i])) buffer.push(nums2[i]);
        }
        return res;
    }
    
	//Method 2: Brute force
    // map + loop, O(n^2)
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        initialize(nums2,map);
        
        for(int i = 0; i < nums1.length; i++){
            int idx = map.get(nums1[i]);
            
            res[i] = findNext(nums2, nums1[i], idx);
        }
        return res;
    }
    
    private void initialize(int[] num, Map<Integer,Integer> map){
        for(int i = 0 ; i < num.length; i++){
            map.put(num[i],i);
        }
        return;
    }
    
    private int findNext(int[] arr, int val, int idx){
        int i = idx;
        while(i < arr.length){
            if(arr[i]>val) return arr[i];
            i++;
        }
        return -1;
    }
}
