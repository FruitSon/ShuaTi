package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map.Entry;

public class IntuitPrecursor {

    public static void main(String[] args) {
        String[][] input = {{"boil", "serve"},{"chop", "boil"},{"stir", "boil"},{"set table", "serve"}};
        Map<String,Integer> degree = new HashMap<>();
        Map<String,List<String>> adj = new HashMap<>();
        Set<String> origin = new HashSet<>();
        Map<String,Integer> res = new HashMap<>();
                    
        // build adj list
        for(String[] str:input){
            if(!degree.containsKey(str[1])){
                degree.put(str[1],0);
                adj.put(str[1],new LinkedList<String>());
            }
            if(!degree.containsKey(str[0])){
                degree.put(str[0],0);
                adj.put(str[0],new LinkedList<String>());
            }
            degree.put(str[1],degree.get(str[1])+1);
            adj.get(str[0]).add(str[1]);
        }
                    
        for(String key:degree.keySet())
            if(degree.get(key)==0) origin.add(key);
        
        for(String key:origin){
            dfs(key, res,degree,adj, input.length);
        }
        
        for(String key:res.keySet()){
            System.out.println(key+":"+res.get(key));
        }
        
        List[] m= new List[input.length+1];

        for(String key:res.keySet()){
            int d = res.get(key);
            if(m[input.length+1-d]==null) m[input.length+1-d]= new LinkedList<String>();
            m[input.length+1-d].add(key);
        }
        
        List<List<String>> output = new LinkedList<>();
        for(List l:m){
            if(l!=null) output.add(l);
        }
        
        for(List<String> l:output){
            for(String s:l) System.out.print(s+"->");
            System.out.println("");
        }

    }

    public static void dfs(String s, Map<String,Integer> res, Map<String,Integer> degree, Map<String,List<String>> adj, int height){
        
        res.put(s,Math.min(height,res.getOrDefault(s,Integer.MAX_VALUE)));
        List<String> tar = adj.get(s);
        for(String str:tar){
            dfs(str, res, degree, adj, height-1);
        }
        
    }


}
