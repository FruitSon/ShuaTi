package normal;

import java.util.LinkedList;
import java.util.List;
/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

//all operation should run in constant time
//as stack following the FILO rules
//the min value of element e, can either be the value of elements before that element or exactly e
//pop() won't influence the minimal value when previous node come to the top of the stack
//-> store the min value while adding a new element
//	* use 2 stack
//  * construct a helper class

public class LC155_Min_Stack {
    private List<node> stack;
    private int min_val;
    
    //helper class
    public static class node{
        private int val, min;
        node(int val, int min){
            this.val = val;
            this.min = min;
        }
        
        public int getPreMin(){
            return min;
        }
        
        public int getVal(){
            return val;
        }
    }
    
    public LC155_Min_Stack() {
        stack = new LinkedList<>();
        min_val = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        stack.add(new node(x,min_val));
        min_val = Math.min(min_val,x);
    }
    
    public void pop() {
       if(stack.size()==0) return ;
        min_val = stack.get(stack.size()-1).getPreMin();
        stack.remove(stack.size()-1);
    }
    
    public int top() {
    	if(stack.size()==0) return Integer.MIN_VALUE;
        return stack.get(stack.size()-1).getVal();
    }
    
    public int getMin() {
        return min_val;
    }
}
