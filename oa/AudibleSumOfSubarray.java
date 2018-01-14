package oa;

import java.util.LinkedList;
import java.util.List;

public class AudibleSumOfSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int[]> input = new LinkedList<>();
		input.add(new int[]{1,2,3,4});
		for(int[] i:input){
			System.out.println(helper(i));
		}
	}
	
	private static long helper(int[] arr){
		long res = 0;
		if(arr==null || arr.length==0) return res;
		//1,12,123,1234,2,23,234,3,34,4
		//1=4,2=3+3=6,3=6,4=4
		//1,2,3,4,5
		//1,12,123,1234,12345,2,23,234,2345,3,34,345,4,45,6
		//1=5,2=4+4=8,3=3+3+3=9,4=2+2+2=6,5=5
		int len = arr.length;
		//a[0] = len, a[1] = len-1+len-1,a[2] = len-2+len-2+len-2....a[i] = (len-i)(i+1)
		for(int i = 0; i<len; i++){
			res += arr[i]*(len-i)*(i+1);
		}
		
		return res;
	}

}
