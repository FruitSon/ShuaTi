package normal;

import java.util.LinkedList;
import java.util.List;

public class ttt {
//	7-0 (- 7)-1-5-0
//	4-6-2
	public static void main(String[] args){
		
		System.out.println(bs(new int[]{1},1));
	}
	
	public static int bs(int[] arr, int tar){
		int low = 0, high = arr.length-1;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(tar > arr[mid]) low = mid + 1;
			else if(tar < arr[mid]) high = mid - 1;
			else return mid;
		}
		return -1;
	}
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //build graph
        int[][] graph = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            //avoid duplicated edge
            if(graph[edge[1]][edge[0]] ==0 )
                indegree[edge[0]] ++;
            graph[edge[1]][edge[0]] = 1;
        }
        
        // 0 - unvisited; 1 - visiting; 2 - visited
        int[] visited = new int[numCourses];
        List<Integer> toBeVisit = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0) toBeVisit.add(i);
        }
        if(toBeVisit.size()==0) return false;
        for(int i : toBeVisit){
          if(!dfs(graph, visited, i)) return false;
        }
        return true;
    }
    
    private static boolean dfs(int[][] graph, int[] visited, int idx){
        if(visited[idx] == 1) return false;
        if(visited[idx] == 2) return true;
        visited[idx] = 1;
        
        for(int j = 0; j < graph.length ; j ++){
            if(graph[idx][j] == 1){
                if(!dfs(graph,visited,j)) return false;
            }
        }
        visited[idx] = 2;
        return true;
    }    
}
