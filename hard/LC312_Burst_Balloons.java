package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

   nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

public class LC312_Burst_Balloons {

	public static void main(String[] args){
		System.out.println(maxCoins(new Integer[]{Integer.MAX_VALUE,2,2,2,2,Integer.MAX_VALUE}));
	}
    public static int maxCoins(Integer[] nums) {
        int min = Integer.MAX_VALUE;
        // max , nums, max
        int len = nums.length;
        List<Integer> l  = new LinkedList<>();
        l.add(Integer.MAX_VALUE);
        for(int i : nums) l.add(i);
        l.add(Integer.MAX_VALUE);
        
        int sum = 0;
        int i = 2;
        while(l.size()!=2 ){
            int pre = l.get(i-1), cur = l.get(i), next = l.get(i+1);
            if(cur<=pre && cur <= next ){
            	System.out.println(pre+","+cur+","+next);
                sum += pre * cur * next;
                l.remove(i);
                i = 2;
            }else{
                i++;
            }
            if(i == l.size()){
            	sum += (l.get(1) * l.get(2));
            	l.remove(1);
            	i = 1;
            }

        }
        return sum;
    }
	
}
