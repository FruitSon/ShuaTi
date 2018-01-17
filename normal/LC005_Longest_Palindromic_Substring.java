package normal;
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example:
Input: "cbbd"
Output: "bb"
*/

//substring.length() %2 == 0 || substring.length() %2 == 1
public class LC005_Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
		if(s==null || s.length()<=1) return s;
        
		char[] str = s.toCharArray();
		//start idx, length
        int[] res_idx = {0,0};
        for(int i = 0; i<str.length; i++){
            int[] tmp1 = PalindromicConstructor(str,i,i+1);
            int[] tmp2 = PalindromicConstructor(str,i-1,i+1);
            res_idx = tmp1[1]<tmp2[1]?
            		(tmp2[1]<=res_idx[1]?res_idx:tmp2)
            		:(tmp1[1]<=res_idx[1]?res_idx:tmp1);
        }
        return s.substring(res_idx[0],res_idx[0]+res_idx[1]+1);
    }

    private int[] PalindromicConstructor(char[] str, int i, int j){
        int delta = 0, l = i, r = j;
        while(i>=0 && j< str.length && str[i]==str[j]){
            delta++;
            i--;j++;
        }
        return new int[]{l+1-delta,r-l+delta*2-2};
    }
}
