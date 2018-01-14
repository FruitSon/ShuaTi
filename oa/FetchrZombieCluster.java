package oa;

import java.util.HashSet;
import java.util.Set;

public class FetchrZombieCluster {
//input String[], 0 -not know, 1-know
	public static void main(String[] args) {
		String[][] test = {
				{"111","111","111"},
				{"11000","11000","00100","00011","00011"},
				{"100011","010011","001000","000100","110010","110001"},
				{"11","11"},
				{"100","010","001"},
				{},
				{"1110","1100","1010","0001"},
				{"1110","1101","1010","0101"}};
		for(String[] testcase : test){
			System.out.println("new test case");
			System.out.println(helper(testcase));
		}
		return;
	}
	
	public static int helper(String[] input){
		int res = 0;
		if(input==null||input.length==0||input[0].length()==0){
			return res;
		}
		int n = input.length;
		int[][] rel = new int[n][n];
		for(int i = 0; i< n; i++){
			for(int j = 0; j<n; j++){
				rel[i][j] = Integer.parseInt(input[i].charAt(j)+"");
			}
		}

		int[] idx = new int[n];
		for(int i = 0; i<n; i++) idx[i] = i;
		
		for(int i =0; i<n; i++){
			for(int j = 0; j<n; j++){
				if(rel[i][j]==1) idx[j] = idx[i];
			}
		}
		
		Set<Integer> temp = new HashSet<>();
		for(int i : idx){
			temp.add(i);
		}
		return temp.size();
	}
	
	public static void dfshelper(int[][] rel, int i, int j){
		if(i<0 || j<0 || i>rel.length-1 || j>rel.length-1 || rel[i][j]==0){
			return;
		}
		rel[i][j] = 0;
		dfshelper(rel,i-1,j);
		dfshelper(rel,i+1,j);
		dfshelper(rel,i,j-1);
		dfshelper(rel,i,j+1);
	}
	
	
}
