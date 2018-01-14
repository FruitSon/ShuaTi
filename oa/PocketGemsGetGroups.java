package oa;

import java.util.Arrays;

public class PocketGemsGetGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] temp = new int[2][2];

		String[] operation = new String[]{"Friend","Friend","Total"};
		int[] std1 = new int[]{4,2,2};
		int[] std2 = new int[]{1,4,3};
		
		int cnt = 5;
		int[] init = new int[cnt+1];
		int[] size = new int[cnt+1];
		for(int j =0 ; j<cnt+1; j++) init[j] = j;
		Arrays.fill(size, 1);
		
		for(int i = 0; i<operation.length;i++){
			int res = 1;
			//initialize
			
			if(operation[i]=="Total") res = total(init,size,std1[i],std2[i]);
			else if(operation[i]=="Friend") res = friend(init, size, std1[i],std2[i]);
			for(int k:init) System.out.print(k+" ");
			System.out.format("the result of \"%s\" student %d and %d is %d.\n",
					operation[i],std1[i],std2[i],res);
		}
	}
	
	private static int friend(int[] status, int[] cnt, int a, int b){
		int i = find(status,a);
		int j = find(status,b);
		if(i==j) return 0;
		else{	
			if(cnt[a]<cnt[b]) {
				status[a] = j;
				cnt[b] = cnt[a] + cnt[b];
			}else{
				status[b] = i;
				cnt[a] = cnt[a] + cnt[b];
			}
		}
		return 0;
	}
	
	private static int total(int[] status, int[] cnt, int a, int b){
		int res = 0;
		int i = find(status,a);
		int j = find(status,b);
		if(i==j) return cnt[i];
		return cnt[i]+cnt[j];
	}
	
	private static int find(int[] status, int a){
		while(status[a]!=a){
			status[a] = status[status[a]];
			a = status[a];
		}
		return a;
	}

}
