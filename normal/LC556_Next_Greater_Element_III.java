package normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21

Example 2:
Input: 21
Output: -1
*/

/*
556	Next Greater Element III 
503	Next Greater Element II
496	Next Greater Element I 
*/

// corner case: nextGreaterElement不在Integer范围内
// 1999999999
// Exception in thread "main" java.lang.NumberFormatException: For input string: "9199999999"

public class LC556_Next_Greater_Element_III {
    //比这一位大的最小值
    //sort 剩余的数字  
    public int nextGreaterElement(int n) {

        char[] num = String.valueOf(n).toCharArray();
        int[] idx = new int[10]; //map
        Arrays.fill(idx,-1);

        for(int i = num.length-1; i >=0 ; i --){

            int digit = num[i]-'0';
            for(int j = digit + 1; j < 10; j ++){
                if(idx[j]!=-1){
                    swap(num, idx[j], i);
                    Arrays.sort(num,i+1,num.length);
                    try{
                        return Integer.valueOf(new String(num));
                    }
                    catch(Exception e){
                        return -1;
                    }    
                }
            }   
            if(idx[digit]==-1) idx[digit]=i;
        }
        return -1;
    }
    
    private void swap(char[] num, int i, int j){
        char tmp = num[j];
        num[j] = num[i];
		num[i] = tmp;
    }
}
