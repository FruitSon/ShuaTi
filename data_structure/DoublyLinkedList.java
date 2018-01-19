package data_structure;

public class DoublyLinkedList<T> {
	private DoublyLinkedListNode<T> head, tail;
	public DoublyLinkedList(){
		head = new DoublyLinkedListNode<T>(null);
		tail = new DoublyLinkedListNode<T>(null);
		head.next = tail;
		tail.pre = head;
	}
	
	public DoublyLinkedListNode<T> add(T val) {
		DoublyLinkedListNode<T> node = new DoublyLinkedListNode<T>(val);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        return node;
    }

    public T removeLast() {
    	// x-node-tail
    	if(tail.pre==head) return null;
    	DoublyLinkedListNode<T> lastNode = tail.pre;
    	tail.pre = lastNode.pre;
    	lastNode.pre.next = tail;
        return lastNode.val;
    }
    
    public T remove(DoublyLinkedListNode<T> node) {
    	node.next.pre = node.pre;
    	node.pre.next = node.next;
    	return node.val;
    }

    public T getLastVal() {
        return tail.pre.val;
    }
}
