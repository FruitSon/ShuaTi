package oa;

import java.util.ArrayList;
import java.util.List;

public class IXLFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = {1,2,13,15,17};
		for(int i:res){
			System.out.println("upper bound:"+i+" find value:"+findValue(i));
		}
	}
	
	public static int findValue(int value){
		List<Integer> nums = new ArrayList<>();
		int i = 1, j = 1;
		nums.add(i);
		while(j<=value){
			nums.add(j);
			int temp = i;
			i = j;
			j = temp+i;
		}
		return nums.get((int)(Math.random()*nums.size()));
	}
}
