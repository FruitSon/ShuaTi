package hard;

import java.util.LinkedList;
import java.util.List;

public class lc126 {

	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = new LinkedList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		findLadders(beginWord,endWord,wordList);
	}
	
	    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        List<List<String>> res = new LinkedList<>();
	        List<String> tmp = new LinkedList<>();
	        int[] mark = new int[wordList.size()];
	        tmp.add(beginWord);
	        helper(wordList,mark,beginWord,endWord,tmp,res);
	        for(List<String> a : res){
	        	System.out.print("[");
	        	for(String str: a){
	        		System.out.print(str+", ");
	        	}	        	
	        	System.out.println("]");
	        }
	        return res;
	        

	    }
	    
	    public static void helper(List<String> wordlist, int[] mark, String curWord, String endWord, List<String> tmp,List<List<String>> res){
	        if(curWord.equals(endWord)){
	        	System.out.println(tmp.size());
	            if(res.size()==0){
	                res.add(new LinkedList<String>(tmp));
	                return;
	            }else{
	                int pre_size = res.get(0).size(),cur_size = tmp.size();
	                if(pre_size==cur_size){
	                    res.add(new LinkedList<String>(tmp));
	                }else if(pre_size<cur_size) return;
	                else{
	                    res.clear();
	                    res.add(new LinkedList<String>(tmp));
	                }
	            }
	        }
	        
	        for(int i = 0; i < mark.length; i++){
	            if(mark[i] ==1 ) continue;
	            String word = wordlist.get(i);
	            if(check(curWord,word)){
	                mark[i] = 1;
	                tmp.add(word);
	                helper(wordlist,mark,word,endWord,tmp,res);
	                tmp.remove(tmp.size()-1);
	                mark[i] = 0;
	            }
	        }
	    }
	    
	    public static boolean check(String a, String b){
	        int cnt = 0;
	        for(int i = 0; i < a.length(); i++){
	            if(a.charAt(i)!=b.charAt(i)) cnt++;
	        }
	        return cnt == 1;
	    }

}
