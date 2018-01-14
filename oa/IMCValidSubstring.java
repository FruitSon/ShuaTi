package oa;
import java.util.*;

public class IMCValidSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> input = new LinkedList<>();
		input.add("12mOa0Bbsda");
		input.add("AAAA");
		input.add("1112232");
		input.add("12a23Wa2");
		input.add("a0Ba");
		input.add("a0bb");
		
		for(String str:input){
			int res = helper(str);
			System.out.format("the vaild length of %s is %d \n",str,res);
		}
	}
	
	public static int helper(String str){
		int res = -1;
		if(str==null || str.length()==0) return res;
		int pt1 = 0, pt2 = 1, len = str.length();
		char[] s = str.toCharArray();
		while(pt2<len){
			while(pt1<len && Character.isDigit(s[pt1])) pt1++;
			pt2 = pt1;
			boolean check = false;
			while(pt2<len && !Character.isDigit(s[pt2])){
				if(!check && Character.isUpperCase(s[pt2])) check = true;
				pt2++; 
			}
			if(check) res = Math.max(pt2-pt1, res);
			pt1 = pt2+1;
		}
		return res;
	}

}
