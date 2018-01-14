package oa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IMCElevator {

	//? worst case:
	//time: O(N*logN + M)
	//space: O(N+M)
	public static void main(String[] args) {
		//A-weight; B-level; par-M-level,X-limit of people,Y-limit of total weight
		List<int[]> A = new LinkedList<>();
		List<int[]> B = new LinkedList<>();
		List<int[]> par = new LinkedList<>();

		A.add(new int[]{60,80,40});
		B.add(new int[]{2,3,5});
		par.add(new int[]{5,2,200});

		A.add(new int[]{40,40,100,80,20});
		B.add(new int[]{3,3,2,2,3});
		par.add(new int[]{3,5,200});
		
		A.add(new int[]{40});
		B.add(new int[]{3});
		par.add(new int[]{3,5,200});

		for(int i = 0; i<A.size(); i++){
			int res = helper(A.get(i),B.get(i),par.get(i)[0],par.get(i)[1],par.get(i)[2]);
			System.out.format("test case %d is %d. \n",i,res);
		}
	}
	
	public static int helper(int[] A, int[] B, int M, int X, int Y){
		if(A==null || B==null || A.length==0 || B.length==0 || X==0 || Y==0) return -1;
		int cnt = 0, len = A.length, pt = 0;
		while(pt<len){
			int w = 0, pc = 0;
			Set<Integer> level_cnt = new HashSet<>();
			while(pt<A.length && w+A[pt]<=Y && pc+1<=X){
				pc++;w+= A[pt];
				level_cnt.add(B[pt]);
				pt++;
			}
			cnt += (1+level_cnt.size());
		}
		return cnt;
	}

}
