package normal;

import java.util.Comparator;
import java.util.PriorityQueue;

/*Contest 01/20/18*/
/*Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
*/

//Stupid solution .... 
//refer to 
//	https://leetcode.com/contest/weekly-contest-68/ranking/ 
public class LC767_Reorganize_String {
	//java 的tuple？
    public String reorganizeString(String S) {
        if(S.length() <= 1) return S;
        
        //count the frequency of each char
        char[] str = S.toCharArray();
        int[] cnt = new int[26];
        for(char ch : str) cnt[ch-'a']++;
        
        //initialize pq
        PriorityQueue<Counter> pq = new PriorityQueue<Counter>(new Comparator<Counter>(){
            public int compare(Counter a, Counter b){
                return -a.cnt + b.cnt;
            }
        });
 
        for(int i = 0 ; i < 26; i++){
        	if(cnt[i]!=0) pq.add(new Counter((char)('a'+i),cnt[i]));
        }
        
        //check if it is valid and generate corresponding string
        if(CheckVaild(pq, S.length())) 
            return buildVaildString(pq, S.length());
        return "";
    }
    
    private boolean CheckVaild(PriorityQueue<Counter> pq, int len){
        return 2*pq.peek().cnt <= len+ 1;
    }
    
    private String buildVaildString(PriorityQueue<Counter> pq, int len){
        if( pq.size()==0) return "";
        if(pq.size()==1) return pq.poll().ch+"";

        Counter first = pq.poll();
        Counter second = pq.poll();
        String part = "";
        int repeat = 0;
        if(pq.size()==0) {
            repeat = second.cnt;
            part = generatePair(first.ch,second.ch,second.cnt);
            //handle 奇数情况
            if(first.cnt!=repeat){
                first.cnt -= repeat;
                pq.add(first);
            }
        }else{
            repeat = Math.min (Math.min(first.cnt,second.cnt), (len - 2 * pq.peek().cnt + 1 )/2);
            first.cnt -= repeat;
            second.cnt -= repeat;
            part = generatePair(first.ch,second.ch,repeat);
            //update pq
            if(first.cnt>0) pq.add(first);
            if(second.cnt>0) pq.add(second); 
        }
        // System.out.println("("+first.ch+","+first.cnt+"),("+second.ch+","+second.cnt+"),"+repeat);  
        return part + buildVaildString(pq,len - repeat * 2);        
    }
    
    private String generatePair(char c1, char c2, int re){
    	StringBuilder sb = new StringBuilder();
        for(int i = 0; i < re; i ++){
            sb.append(c1);
            sb.append(c2);
        }
        return sb.toString();
    }  
    
    //helper class
	class Counter {
		char ch;
		int cnt = 0;
		public Counter(){}
		public Counter(char ch, int cnt){
			this.ch = ch;
			this.cnt = cnt;
	    }
	}
}
