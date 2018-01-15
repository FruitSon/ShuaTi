package hard;

/*
In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */

//一共三种情况:
//无duplicated parent -> Redundant_Connection
//有duplicated parent -> 有环: 删除构成环的edge;无环：删除latter edge

//union find
public class LC685_Redundant_Connection_II {
	//Method 1: (see modified version below)
	//Time:O(nlg*n) ~ O(n)
	//Space:O(n)
	//-one pass, try to find the edges point to the same node (if exist), and define them as candidate edges (can1, can2)
	//-one pass, try to union the node (skip the candidate edge)
	//	- if exist cycle, return the last edge forms the cycle
	//-check if can1 will form the cycle
	//	- if can1 will form the cycle, return can1
	//	- if can1 won't form the cycle, return can2 
	//		- can2 is in the cycle 
	//		- can2 isn't in the cycle but is the latter one leads the conflict
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] arr = initialize(edges.length);
        int[] indegree = new int[edges.length+1];
        int[] can1 = {0,0}, can2 = {0,0};
        
        for(int[] e : edges){            
            if(indegree[e[1]]!=0){
            	//if one node has two parent
            	//the edge deleted must be one of the edge whose destination is this node
                can1 = new int[]{indegree[e[1]],e[1]};
                can2 = new int[]{e[0],e[1]};
                break;
            }else{
            	//record the parent of current node
                indegree[e[1]] = e[0];
            }            
        }
        
        //把除了candidate的edge都union起来
        for(int[] e : edges){
            if(sameParent(arr, e[0],e[1])){
               //*没有degree==2的边，存在环
               return e;
            }else{
            	//*可以用更改原数组来mark
                if((e[0]==can1[0] && e[1]==can1[1])||(e[0]==can2[0] && e[1]==can2[1])){
                    continue;
                }
                union(arr,e[0],e[1]);
            }
        }
        
        //*有degree==2的node，can1在环内                                    
        if(sameParent(arr,can1[0],can1[1])) return can1;
        //*有degree==2的node
        //*-如果有环，can1不在环内，can2必在环内，return can2
        //*-如果没有环，can1不在环内，can2在can1后出现，return can2
        return can2;
    }
    
    //Method 2: (modified)
    //无duplicated parent -> Redundant_Connection
  	//有duplicated parent -> 有环: 删除构成环的edge;无环：删除latter edge
  	//https://www.youtube.com/watch?v=lnmJT5b4NlM
    public int[] findRedundantDirectedConnection2(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        
        //find the node who has duplicated parent
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                //mark to delete the latter edge
                edges[i][1] = 0;
                break;
            }
        }
        
        //initialize array for union operation
        parent = initialize(edges.length);
        
        //如果can1=={-1，-1}，说明不存在duplicated parent的node， 即为I
        //如果can1!={-1, -1}, 即使是加入{a,b}之后形成的环，也要删除环内的candidate边
        //eg.{{2,1},{3,1},{4,2},{1,4}}
    	//虽然是加入{1,4}时候形成的环，但是一个node最多只能有一个parent，所以要删除环内的candidate{2,1}
        for (int i = 0; i < edges.length; i++) {
        	//if the edge is the latter one , skip
        	//如果不skip 还要额外记录can1是不是已经被加入 ，can2是不是已经被加入
            if (edges[i][1] == 0) {
                continue;
            }
            if(find(parent,edges[i][1])==find(parent,edges[i][0])){
            	return (can1[0]==-1)?edges[i]:can1;
            }
            union(parent, edges[i][0], edges[i][1]);
        }
        return can2;
    }
    
    //union find methods
    private int[] initialize(int n){
        int[] arr = new int[n+1];
        for(int i = 0; i < n+1; i++)
            arr[i] = i;
        return arr;
    }
    
    private boolean sameParent(int[] arr, int i, int j){
        return find(arr,i)==find(arr,j);
    }
    
    private int find(int[] arr, int i){
        while(arr[i]!=i) i=arr[i];
        return i;
    }
    
    private void union(int[] arr, int parent, int child){
        if(find(arr,parent)==find(arr,child)) return;
        arr[find(arr,arr[child])]= find(arr,arr[parent]);
    }
    
}
