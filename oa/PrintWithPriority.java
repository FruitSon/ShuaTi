package oa;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public abstract class PrintWithPriority {
    public static void main(String[] args) {



        PriorityQueue<skill> res = new PriorityQueue<skill>(new Comparator<skill>(){
        	@Override
        	public int compare(skill a, skill b){
        		return -a.priority+b.priority;
        	}
        });
        
        

        printTop(4);
//        
//            new Comparator<skill>(){
//             public void compare(skill a, skill b) {
//                return a.priority - b.priority;
//            }
//        });

    }
    
    public static PriorityQueue<skill> res = new PriorityQueue<skill>(new Comparator<skill>(){
    	@Override
    	public int compare(skill a, skill b){
    		return -a.priority+b.priority;
    	}
    });


    
    public static void printTop(int line){
    	int line_cnt = 0;
        res.add(new skill("a","math",10));
        res.add(new skill("b","chinese",11));
        res.add(new skill("c","math",12));
        res.add(new skill("d","math",13));
        res.add(new skill("e","chinese",15));
        res.add(new skill("f","math",14));
    	LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
    	PriorityQueue<skill> pqCopy = new PriorityQueue<skill>(res);
    	System.out.println(pqCopy.isEmpty());
    	while(line_cnt < line && !pqCopy.isEmpty()){
    		skill cur = pqCopy.poll();
    		if(!map.containsKey(cur.subject)){
    			map.put(cur.subject, new LinkedList<>());
    			line_cnt++;
    		}
    		map.get(cur.subject).add(cur.name);
    		line_cnt ++;
    	}
    	
    	for(Entry<String, List<String>> entry : map.entrySet()){
			System.out.println(entry.getKey());
    		for(String name : entry.getValue()){
    			System.out.println(name);
    		}
    	}
    }
    
    public static class skill{
	    String name;
	    String subject;
	    int priority;
    
	    public skill(String n, String sub, int p){
	        name = n;
	        subject = sub;
	        priority = p;
	    }
    }
}
