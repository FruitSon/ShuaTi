package normal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class card{
    int i, j;
    boolean ii, jj;
    public card(int i1 , int j1){
        i = i1;
        j = j1;
        ii = false;
        jj = false;
    }
    
    public boolean isSame(card c){
        return (c.i==i && c.j==j) || (c.i==j && c.j==i);
    }
    
    public boolean halfSame(int num){
        if(i==num && !ii) ii = true;
        else if(j==num && !jj) jj = true;
        else return false;
        return true;
    }
}


public class ForUsAll_Domino_Game {
	    
public static void main(String[] args) {
	        int[] arr = new int[]{1,2,3,1,2,4,5,3,1,2,4,6};
	        System.out.println(helper(arr));
	        System.out.println("Hello World!");
	    }
	    
	    public static boolean helper(int[] arr){
	        List<card> cards = initializeCards(arr);
	        if(cards.size()<1) return false;
	        Set<card> candidates = findTopCandidate(cards);
	        for(card top : candidates){
	        	int a1 = top.i, a2 = top.j;
	        	//6种
	        	List<card> combines = new LinkedList<>();
	        	
	        }
	        return true;
	    }
	    
	    private static List<card> initializeCards(int[] arr){
	        List<card> res = new LinkedList<>();
	        for(int i = 0; i < arr.length; i+=2){
	            res.add(new card(arr[i],arr[i+1]));
	        }
	        return res;
	    }
	    
	    private static Set<card> findTopCandidate(List<card> cards){
	    	List<card> orig = cards;
	    	boolean[] marked = new boolean[6];
	    	for(int i = 0; i < orig.size(); i++){
	    		for(int j = i+1; j < orig.size(); j++){
	    			if(marked[j]) continue;
	    			if(orig.get(i).isSame(orig.get(j)) && !marked[j]){
	    				res.add(orig.get(i));
	    				marked[j] = true;
	    			}
	    			marked[i] = true;
	    		}
	    	}
	    	return res;
	    }
	
}
