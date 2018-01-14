package oa;

import java.util.Arrays;

public class AudibleBudgetShopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] budget = new int[]{5,50};
		int[][] num = new int[][]{new int[]{4,2},new int[]{20,19}};
		int[][] cost = new int[][]{new int[]{2,1},new int[]{24,20}};

		for(int i=0; i<budget.length; i++){
			System.out.println("notebook purchased:"+helper(budget[i],num[i],cost[i]));
		}

	}
	
	private static int helper(int bud, int[] num, int[] cost){
		int[] temp = new int[bud+1];
		int[][] store = new int[num.length][2];
		for(int i = 0; i <num.length; i++){
			store[i][0] = num[i];
			store[i][1] = cost[i];
		}
		Arrays.sort(store,(o1,o2)->o1[0]-o2[0]);

		
        for(int i = store[0][1]; i<bud+1;i++){
        	for(int j=0; j<store.length; j++){
        		if(store[j][1]>i) break;
        		if(temp[i-store[j][1]]+store[j][0]>temp[i]) 
        			temp[i] = temp[i-store[j][1]]+store[j][0];
        	}
        }
        System.out.println("____");
        for(int i:temp) System.out.print(i+" ");
        System.out.print("*"+temp[bud-1]);

        return temp[bud];
	}

}
