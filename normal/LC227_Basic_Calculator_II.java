package normal;
/*Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

import java.util.Stack;

// Method 1: stack.
public class LC227_Basic_Calculator_II {
	public int calculate(String s) {
        int num = 0, res = 0;
        char sign = '+';
        char[] str = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < str.length ;i ++){
            if(Character.isDigit(str[i])){
                num = num  * 10 + str[i] - '0';
            }
            if( (!Character.isDigit(str[i]) && str[i] != ' ') || i == str.length - 1){
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = str[i];
            }
        }
        for(int i : stack) res += i;
        return res;
    }
}
