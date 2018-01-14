package normal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

*/

public class LC763_Partition_Labels {
	//Method 1:
	//one pass, record the idx of startpoint and endpoint
	//one more pass to generate the res
	//time: O(n)
    public List<Integer> partitionLabels(String S) {
        char[] str = S.toCharArray();
        List<Integer> res = new LinkedList<>();
        if(S==null || S.length()==1) return res;
        
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start,-1);
        Arrays.fill(end,-1);

        for(int i = 0 ; i < str.length; i++){
        	if(start[str[i]-'a']==-1) start[str[i]-'a']= i;
        	end[str[i]-'a'] = i;
        }
    
        for(int i = 0; i < str.length ; i++){
        	int begin = start[str[i]-'a'];
        	int tmp_end = end[str[i]-'a'];
        	while(i < tmp_end){
        		i ++;
        		tmp_end = Math.max(tmp_end, end[str[i]-'a']);
        	}
        	res.add(i-begin+1);
        }
        return res;
    }   
}
