package oa;

import java.util.*;

public class IXLCirculatingDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(2));
	}

	public static String generate (int n){
		StringBuilder strbuilder = new StringBuilder();
		Map<Long,Integer> remainders = new HashMap<>();
		Long num = (long) 1;
		while(num!=0){
			if(!remainders.containsKey(num)){
				remainders.put(num,strbuilder.length());
				long temp = num * 10;
				strbuilder.append(temp/10);
				num = temp%n;
			}
			else{
				return strbuilder.toString().substring(remainders.get(num));
			}
		}
		return "0";
	}
}
