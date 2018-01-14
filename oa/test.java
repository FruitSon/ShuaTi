package oa;

import java.util.*;

public class test {
	public static void main(String[] args){
		List<String> test = new LinkedList<String>();
		test.add("1");
		test.add("2");
		test.add("3");
		test.add("4");
		test.add("5");
		test.subList(3, 4).clear();
		//for(String t:test) System.out.println(t);
		int[] a = {1,23,4,1};
		
		//to array
	    String[] my = test.toArray(new String[0]); 
	    String[] my2 = test.toArray(new String[test.size()]); 
	    //for(String m:my2) System.out.println(m+",");
	    	//String s = "BLUE IS A BIG KEY";
	    	String s = "   a   b ";
	        String[] words = s.trim().split("\\s+");
	    	System.out.println(words.length);
	    	for(String m:words) System.out.println(m);

	         StringBuilder sb = new StringBuilder();
	         
	         for(int i = 0, j = words.length-1; i<j; i++, j--){
	             String temp = words[i];
	             if(i!=j){
	             sb.insert(i,words[j]).insert(i+1," ");
	             }
	             sb.insert(j,words[i]).insert(j+1, " ");
	         }
	         sb.toString();	        
	         System.out.println(sb.toString()       );
	    
	    
	    
	    //to object array
	    Object[] objArray = test.toArray(); 

	    
	    //to arrayList
	    ArrayList<String> arrayList = new ArrayList<String>(test); 

	    //find index
	    test.indexOf("2"); 
	    
	    //contains element?
	    test.contains("2");
	    
	    //replace element
	    test.set(3, "Replaced");
	    
	    //链表多线程
	    //TO DO
	    
	    //优先级链表
	    //TO DO 
	    
	    //生成帮助类
	    //TO DO

	}
}
