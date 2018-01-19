package data_structure;

public class DoublyLinkedListNode<T> {
	DoublyLinkedListNode<T> pre, next;
	T val;
	
	public DoublyLinkedListNode() {
		this.pre = null;
		this.next = null;
		this.val = null;
	}	
	public DoublyLinkedListNode (T val){
		this.val = val;
		this.pre = null;
		this.next = null;
	}
	
	public T getVal(){
		return val;
	}
}
