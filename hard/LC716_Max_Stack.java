package hard;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import data_structure.DoublyLinkedList;
import data_structure.DoublyLinkedListNode;

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

//Initial solution: List<List<Integer>> | same as the two stack solution
//- initialize a new list every time meet a new max value
//- the max value is stored in the list where idx = 0
//		- eg :push 4,1,8,3,5,4 will lead a list ((4,1),(8,3,5,4))

//Optimized solution: Double Linked List + TreeMap [Accepted]

public class LC716_Max_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxStack1 s = new MaxStack1();
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
		System.out.println(s.peekMax()); //8
		s.popMax(); 
		System.out.println(s.peekMax()); //5
		s.top(); 
		System.out.println(s.peekMax()); //5
		System.out.println(s.pop()); //4
	}
}
//Method 1:
//List<List<Integer>> - same as the two stack solution
//- initialize a new list every time meet a new max value
//- the max value is stored in the list where idx = 0
//		- eg :push 4,1,8,3,5,4 will lead a list ((4,1),(8,3,5,4))
//- Analysis:
//	- Time:
//		- O(1) : push(), pop(), top(), peekMax()
//		- O(N) : popMax()
//		- worst case: the number were inserted in decreasing order (eg: 1000, 999, 998, ... , 1)
//	- Space: O(N)
class MaxStack1 {
	LinkedList<LinkedList<Integer>> stack;
	int max;
	public MaxStack1(){
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

//Method 2: DoublylinkedList (maintain the order of inserted value) + TreeMap (maintain the order of max value)
//use ddl for O(1) update and delete
//use the feature of TreeMap (store the entry by the value of its key) to peekMax in O(1) and popMax in O(1)
//Time: 
//	- O(logN): push(), pop(), peekMax(), popMax()
//  - O(1): peek()
//Space:
//	- O(N)
class MaxStack2 {
	TreeMap<Integer,LinkedList<DoublyLinkedListNode<Integer>>> map;
	DoublyLinkedList<Integer> list;
	
	public MaxStack2(){
		map = new TreeMap<>();
		list = new DoublyLinkedList<>();
	}
	
	public void push(int x){
		DoublyLinkedListNode<Integer> tmp = list.add(x);
		if(!map.containsKey(x)) map.put(x,new LinkedList<>());
		map.get(x).add(tmp);
	}
	
	public int pop(){
		DoublyLinkedListNode<Integer> top = list.getLast();
		map.get(top.getVal()).removeLast();
		if(map.get(top.getVal()).size()==0) map.remove(top.getVal());
		return top.getVal();
	}
	
	public int top(){
		return list.getLast().getVal();
	}
	
	public int peekMax(){
		return map.lastKey();
	}
	
	public int popMax(){
		int max = map.lastKey();
		list.remove(map.get(max).getLast());
		map.get(max).removeLast();
		if(map.get(max).size()==0) map.remove(max);
		return max;
	}
}