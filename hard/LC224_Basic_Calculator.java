package hard;

import java.util.Stack;

/*Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
*/

// Method 1: stack
// - handle the situation when the index reaches end (' '/')')
// - push the sign before '(' into the stack. when finish calculation in (), add it back.
// - add 0 on the bottom of stack, when '(' appeared
// - initialize sign as '+' at first, when '(' appeared 
public class LC224_Basic_Calculator {
	public static void main(String[] args){
		//System.out.println(calculate("1 + 1"));
//		System.out.println(calculate(" (1-2) "));
		System.out.println(calculate(" (1-2)+3-(2-5)"));

	}
	
	public static int calculate(String s) {
        Stack<Integer> cache = new Stack<>();
        char[] str = s.toCharArray();
        int num = 0;
        char sign = '+';
        cache.push(0);
        for(int i = 0; i < str.length; i++){
        	System.out.println(str[i]);

            if(Character.isDigit(str[i])){
                num = num * 10 + str[i] - '0';
            }
            if((!Character.isDigit(str[i]) && str[i]!=' ') || i == str.length -1) {
                if(str[i] == '('){
                    cache.push(sign=='+'?1:-1);
                    cache.push(0);

                    num = 0;
                    sign = '+';
                } else if(str[i] == ')'){
                    // () * （）前的符号 + 
                	int tn = cache.pop() + (sign == '+'?1:-1)  * num;
                	int ts = cache.pop();
                    cache.push(tn * ts +cache.pop());
                    sign = '+';
                    num = 0;

                } else if( sign == '+'){
                    cache.push(cache.pop() + num);
                    num = 0;
                    sign = str[i];
                } else if( sign == '-'){
                    cache.push(cache.pop() - num);
                    num = 0;
                    sign = str[i];
                }
            }
        }
        return cache.pop();
    }
}
