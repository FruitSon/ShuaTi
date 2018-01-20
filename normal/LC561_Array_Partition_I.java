package normal;

import java.util.Arrays;

/*Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
*/

//in order to maximize the sum of min(ai,bi)
//just sort the array and return the sum of previous half of the array
//Time: O(nlogn)
//Space: O(1)

//rough proof
//https://discuss.leetcode.com/topic/87206/java-solution-sorting-and-rough-proof-of-algorithm
//	- Assume in each pair i, bi >= ai.
//	- Denote Sm = min(a1, b1) + min(a2, b2) + ... + min(an, bn) = a1 + a2 + ... + an
//	- Denote Sa = a1 + b1 + a2 + b2 + ... + an + bn. Sa is constant for a given input.
//	- Denote di = |ai - bi|. Given 1, di = bi - ai. Denote Sd = d1 + d2 + ... + dn.
//	So Sa = a1 + a1 + d1 + a2 + a2 + d2 + ... + an + an + dn = 2Sm + Sd => Sm = (Sa - Sd) / 2. 
//  To get the max Sm, given Sa is constant, we need to make Sd as small as possible.

public class LC561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i+= 2){
            sum += nums[i];
        }
        return sum;
    }
}
