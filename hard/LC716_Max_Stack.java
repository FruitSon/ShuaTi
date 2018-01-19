package hard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/*
 * Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5

Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.
 */

//Initial thought: List<List<Integer>> | same as the two stack solution
//- initialize a new list every time meet a new max value
//- the max value is stored in the list where idx = 0
//		- eg :push 4,1,8,3,5,4 will lead a list ((4,1),(8,3,5,4))
//- Analysis:
//	- Time:
//		- O(1) : push(), pop(), top(), peekMax()
//		- O(N) : popMax()
//		- worst case: the number were inserted in decreasing order (eg: 1000, 999, 998, ... , 1)
//	- Space: O(N)

//Optimized solution: Double Linked List + TreeMap [Accepted]

public class LC716_Max_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC716_Max_Stack s = new LC716_Max_Stack();
		//test case 1
//		s.push(5);
//		s.push(1);
//		s.push(5);
//		s.top();
//		s.popMax(); 
//		s.top(); 
//		s.peekMax(); 
//		s.pop(); 
//		s.top(); 
		
//TEST CASE 2
		s.push(4);
		s.push(1);
		s.push(8);
		s.push(3);
		s.push(5);
		s.push(4);
		s.top();
		s.peekMax(); //8
		s.popMax(); 
		s.peekMax(); //5
		s.top(); 
		s.peekMax(); //5
		s.pop(); //4
	}
	
	private LinkedList<LinkedList<Integer>> stack;
	private int max;
	public LC716_Max_Stack(){
		stack = new LinkedList<>();
		max = Integer.MIN_VALUE;
	}
	
	public void push(int x) {
		if(x >= max){
			max = x;
			stack.add(new LinkedList<Integer>());
		}
		stack.getLast().add(x);
	}
	
	public int pop() {
		int popedNum = stack.getLast().getLast();
		if(stack.getLast().size()==1){
			stack.removeLast();
			if(!stack.isEmpty())
				max = stack.getLast().getFirst();
			else 
				max = Integer.MIN_VALUE;
		}else{
			stack.getLast().removeLast();
		}
		System.out.println("pop:"+popedNum);
		return popedNum;
	}
	
	public int top(){
		System.out.println("top:"+stack.getLast().getLast());
		return stack.getLast().getLast();
	}
	
	public int peekMax(){
		System.out.println("peekMax:"+max);
		return max;
	}

	public int popMax() {
		int popedMax = stack.getLast().getFirst();
		if(stack.getLast().size()==1){
			stack.removeLast();
		}else{
			stack.getLast().removeFirst();
			List<Integer> tmp = stack.getLast();
			stack.removeLast();
			max = stack.getLast().getFirst();
			for(int num : tmp){
				push(num);
			}
			//stack.getLast().addAll(tmp);
		}		
		System.out.println("popMax:"+max);
		return popedMax;
	}
}
