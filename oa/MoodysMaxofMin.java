package oa;

import java.util.PriorityQueue;
import java.util.Queue;

public class MoodysMaxofMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,50,10,70,30};
		helper(arr);
	}
	
	public static void helper(int[] arr){

		int[] helper = new int[arr.length+1];
		
		for(int i = 0; i<arr.length; i++){
			int left = i - 1, right = i+1;
			while(left > -1){
				if(arr[left]<arr[i]) break;
				left--;
			}
			while(right<arr.length){
				if(arr[right]<arr[i]) break;
				right++;
			}
			helper[right-left-1] = Math.max(helper[right-left-1], arr[i]);
		}		

		for(int i = helper.length-2; i>0; i--){
			helper[i] = Math.max(helper[i+1], helper[i]);
		}
		for(int i = 1; i< helper.length ; i++) 	
			System.out.println(helper[i]);

		
		
		return;
	}

}
