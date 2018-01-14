package oa;

import java.util.Deque;
import java.util.LinkedList;

public class AudiblePrefixToPostfix {

	public static void main(String[] args) {
		System.out.println(prefixToPostfix("*34"));
		System.out.println(prefixToPostfix("+1*23"));
		System.out.println(prefixToPostfix("+12"));
		System.out.println(prefixToPostfix("+1**23/14"));

	}
	
	public static String prefixToPostfix(String prefix) {
		if (prefix == null || prefix.length() == 0) return "";
		Deque<String> stack = new LinkedList<>();
		//Stack<String> stack = new Stack<String>();
		char[] input = prefix.toCharArray();
		for(int i=input.length-1; i>=0;i--){
			String postfix;
			if(isOperator(input[i])){
//				String t1 = stack.pop();
//				String t2 = stack.pop();
				String t1 = stack.pop();
				String t2 = stack.pop();
				postfix = t1+t2+input[i];
				stack.push(postfix);
			}else{
				stack.push(input[i]+"");
			}
		}
		return stack.pop();
	}
	
	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') return true;
		return false;
	}

}
