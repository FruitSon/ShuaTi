package oa;

import java.util.LinkedList;
import java.util.List;

public class MessageList {
    public static void main(String[] args) {
    	List<msg> input = new LinkedList<>();
    	input.add(new msg(1,"A"));
    	input.add(new msg(2,"A"));
    	input.add(new msg("B"));
    	input.add(new msg("B"));
    	input.add(new msg(2,"C"));
    	input.add(new msg(1,"C"));
    	printValid(input);
    }
    
    public static void printValid(List<msg> input){
    	
    	helper(0, input, 1, 1, new LinkedList<msg>());
    }
    
    public static void helper(int idx, List<msg> input, int min_id, int max_id, List<msg> tmp){
    	if(tmp.size() == input.size()){
    		for(msg i : input){
    			System.out.print(i.type+i.id+" ");
    		}
    		return;
    	}
    	for(int i = idx ; i < input.size(); i++){
    		msg cur = input.get(i);

    		if(cur.type.equals("A")){
    			min_id = Math.min(cur.id,min_id);
        		tmp.add(cur);
    		}
    		else if(cur.type.equals("C")){
    			max_id = Math.max(max_id, cur.id);
        		tmp.add(cur);
    		}
    		else if(cur.type.equals("B")){


    			for(int k = min_id; k<=max_id; k++){
    	    	

    	    		tmp.add(new msg(k,"B"));
	    		}
    		}
			helper(i+1,input,min_id,max_id,tmp);
			if(cur.type.equals("B")) tmp.remove(tmp.size()-1);

    	}
    	return;
    }
    public static class msg{
    	public int id;
    	public String type;
    	public msg (int i, String t){
    		id = i;
    		type = t;
    	}
    	public msg (String t){
    		type = t;
    	}
    }

}
