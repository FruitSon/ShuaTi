package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class solution {
public static void main(String[] args) {
//	        String[][] input = {{"job1","job2"},{"job1","job3"},{"job4","job3"},{"job1","job5"},{"job6","job1"}};
//	        String[][] input = {{"clean", "build"},{"metadata", "binary"},{"build", "link"},{"link", "binary"},
//	        {"clean", "metadata"},{"build", "resources"}};
	        String[][] input = {{"boil", "serve"},
	        		{"chop", "boil"},
	        		{"stir", "boil"},
	        		{"set table", "serve"}};
	        Arrays.sort(input,(o1,o2)->o1[0].compareTo(o2[0]));		
	        Map<String,Integer> degree = new HashMap<>();
	        Map<String,Integer> order = new TreeMap<>();
	        Map<String,List<String>> adj = new HashMap<>(); 
	        Set<String> source = new HashSet<>();
	        
	        for(String[] s:input){
	            if(!degree.containsKey(s[0])){ 
	                degree.put(s[0],0);
	                adj.put(s[0],new LinkedList<>());
	            }
	            adj.get(s[0]).add(s[1]);
	            if(!degree.containsKey(s[1])) {
	            	degree.put(s[1],1);
	                adj.put(s[1],new LinkedList<>());
	            }
	            else degree.put(s[1],degree.get(s[1])+1);
	        }
	        for(String[] s:input){
	            System.out.println(s[0]+","+s[1]);
	        }
	        for(String s:degree.keySet()){
	            System.out.println(s+","+degree.get(s));
	            if(degree.get(s)==0)source.add(s);
	        }

	        for(String s:source){
	            dfs(s,order,adj);
	        }
	        
	        // 升序比较器
	        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
	            @Override
	            public int compare(Entry<String, Integer> o1,
	                    Entry<String, Integer> o2) {
	                // TODO Auto-generated method stub
	                return -o1.getValue()+o2.getValue();
	            }
	        };

	        // map转换成list进行排序
	        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(order.entrySet());
	        Collections.sort(list,valueComparator);

	        // 默认情况下，TreeMap对key进行升序排序
	        System.out.println("------------map按照value升序排序--------------------");
	        for (Map.Entry<String, Integer> entry : list) {
	            System.out.println(entry.getKey() + ":" + entry.getValue());
	        }

	        return;
	    }
	   

    public static  void dfs(String s, Map<String,Integer> res, Map<String,List<String>> adj){
        System.out.println("---"+s);
        List<String> target = adj.get(s);
        if(target.size()==0){
            res.put(s,0);
            return;
        }
        int max = Integer.MIN_VALUE;
        for(String t:target){
             dfs(t,res,adj);
             max = Math.max(max, res.get(t));
        }
        res.put(s,max+1);
}
}
	
class adjNode {
	String val;
	adjNode next;
}

class Node{
	String val;  
	int degree;
	adjNode next;
	Node(){
	}
	
	Node(String val, int degree){
		this.degree = degree;
		this.val = val;
		this.next = null;
	}
}

enum Color{
	BLACK,WHITE,GREY
}

class Vertex<T>{
	public Color color;
	//int color;
	int distance;
	public Vertex<T> parent;
	public T value;
	public int discover,finish;
	public Set<Vertex<T>> adjVertices;
	
	public Vertex(T t){
		color = Color.WHITE;
		distance = Integer.MAX_VALUE;
		value = t;
		discover = 0;
		finish = 0;
		adjVertices = new LinkedHashSet<Vertex<T>>();
	}
	
	@Override
	public boolean equals(Object obj){
		if(this==obj) return true;
		if(obj==null) return false;
		if(getClass()!=obj.getClass()) return false;
		Vertex<?> other = (Vertex<?>) obj;
		if(value==null && other.value!=null) return false;
		if(value!=null) return value.equals(other.value);
		return false;
	}
}

abstract class Edge<T> {
	public T source,target;
	public Edge(T source, T target){
		this.source = source;
		this.target = target;
	}
	
	@Override
	public abstract boolean equals(Object obj);
}

class DirectedEdge<T> extends Edge<T>{

	public DirectedEdge(T source, T target){
		super(source, target);
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null) return false;
		if(getClass()!=obj.getClass()) return false;
		Edge<?> other = (Edge<?>) obj;
		return source.equals(other.source) && target.equals(other.target);
	}
}

abstract class Graph<T>{
	protected int[][] adjMatrix;
	protected int size = 0;
	public Set<Vertex<T>> vertices;
	public Set<Edge<T>> edges;
	private Stack<Vertex<T>> topoStack;
	
	public Graph(){
		adjMatrix = new int[size][size];
		vertices = new LinkedHashSet<Vertex<T>>();
		edges = new LinkedHashSet<Edge<T>>();
		topoStack = new Stack<Vertex<T>>();
	}
	
	public void addVertex(T t){
		Vertex<T> vertex = new Vertex<T>(t);
		if(vertices.contains(vertex)){
			throw new IllegalArgumentException("this node already existed in the graph");
		}
		size++;
		vertices.add(vertex);
		//adjustMatrix(t);
		return;
		//return this;
	}
	
	public abstract void addEdge(T t1, T t2);
	
	protected Vertex<T> isContainVertex(T t){
		for(Vertex<T> v:vertices){
			if(v.equals(t)) return v;
		}
		return null;
	}
	
	protected Edge<T> isContainEdge(T t1, T t2){
		for(Edge<T> e:edges){
			if(e.source.equals(t1) && e.source.equals(t2)) return e;
		}
		return null;
	}
	
//	public void printDFS(T t){
//		Vertex<T> 
//	}
	
}