package normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
In this problem, a tree is an undirected graph that is connected and has no cycles.
The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), 
with one additional edge added. The added edge has two different vertices chosen from 1 to N, 
and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. 
Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. 
If there are multiple answers, return the answer that occurs last in the given 2D-array. 
The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
*/
public class LC684_Redundant_Connection {
	//https://www.youtube.com/watch?v=4hJ721ce010
	
	////Method 1: DFS 
	// -建图 Map<Integer, Set<>> save all connected node
	// -trace back to see if a cycle exists (dfs) 
	// 时间复杂度: O(n^2) n条边，做n次
	
	public int[] findRedundantConnection(int[][] edges) {
	  Map<Integer,Set<Integer>> graph = new HashMap<>();
	  for(int[] e : edges){
	     if(checkCircle(e[0], e[1] ,graph,-1)) return e;
	     updateNode(graph, e[0],e[1]);
	     updateNode(graph, e[1],e[0]);
	  }
	  return null;
	}
	
	private boolean checkCircle(int start, int tar, Map<Integer,Set<Integer>> graph, int pre){
	  if(!graph.containsKey(start)) return false;
	  if(graph.get(start).contains(tar)) return true;
	  Set<Integer> connected = graph.get(start);
	  for(int node : connected){
	      if(node == pre) continue;
	      if(checkCircle(node, tar, graph, start)) return true;
	  }
	  return false;
	}   
	
	private void updateNode(Map<Integer,Set<Integer>> graph, int start, int end){
	  if(!graph.containsKey(start)) graph.put(start,new HashSet<Integer>());
	  graph.get(start).add(end);
	  return;
	}

	//Method2: union find 
	//O(n)
	//direction ..其实并没有什么关系
	public int[] findRedundantConnection2(int[][] edges) {
	 int[] arr = new int[edges.length+1];
	 //initialize
	 for(int i = 0; i < arr.length; i++){
	     arr[i] = i;   
	 }
	 
	 for(int[] e:edges){
	     if(checkCycle(arr,e)) return e;
	     union(arr, e[0],e[1]);
	 }
	 return null;
	}
	
	private boolean checkCycle(int[] arr, int[] e){
	 return find(arr , e[1]) == find(arr , e[0]);
	}
	
	private int find(int[] arr, int i){
	 while(arr[i]!=i) i = arr[i];
	 return i;
	}
	
	private void union(int[] arr, int parent, int child){
	 if(find(arr,parent)==find(arr,child)) return;
	 else{
		 //optimization here: path compress
	     arr[find(arr,arr[child])]= find(arr,arr[parent]);
	 }
	 return;
	}
}
