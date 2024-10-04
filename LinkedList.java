import java.util.Iterator;

public class LinkedList<E>{
	private Node<E> head;  
    private Node<E> current;
    private int size;

    private static class Node<E> {   //Node Class, taken from Algorithms
        private E item;
        private Node<E> next;

        public Node(E item) {
            this.item = item;
            this.next = null;
        }
        
        public Class getType() {
        	return item.getClass();
        }
        
        public String toString() {
        	return item.toString();
        }
    }
    
    private class LinkedListIterator implements Iterator<E>{
    	private Node<E> current = head;
    	
    	public boolean hasNext() {
    		return current != null;
    	}
    	
    	public E next() {
    		if(this.current.next == null || this.current == null) return null;
        	this.current = this.current.next;
        	return this.current.item;
    	}
    }
    
    public Iterator<E> iterator(){
    	return new LinkedListIterator();
    }
    
    public LinkedList() { //Linked List Constructor
        head = null;
        current = head;
        this.size = 0;
    }
    
    public boolean hasNext() {
    	return this.current.next != null;
    }
    
    public E next() {
    	if(this.current.next == null || this.current == null) return null;
    	this.current = this.current.next;
    	return this.current.item;
    }
    
    public boolean contains(E item) {
    	goToHead();
    	if(isEmpty()) return false;
    	do {
    	if(this.current.equals(item)) return true;
    	
    	}while(this.next() != null);
    	goToHead();
    	return false;
    }
    
    public E getHead() {   //Returns the current head
    	if(head == null) {
    		return null;
    	}
    	return this.head.item;
    }

    public E getCurData() { // Returns the current item
        if (current == null) return null;
        return current.item;
    }
    
    
    public Node<E> atEndOfList() {		//Finds the value at the end of the list by iterating through each list item
    	while(current.next != null) {
    		current = current.next;
    	}
    	return this.current;
    }
    
    public void goToHead() {			//Sets current node to the Head
    	this.current = this.head;
    }
        

    public boolean nextData() {	
        if (current != null) {
            current = current.next;
        }
        return (current != null); 				// false means no next data to move to
        									// in other words, at end of list
    }

    public boolean isEmpty() {				//Returns true if the list is empty
        return head == null;
    }

    public void insert(E item) {			//Inserts new item into List
    	size++;
    	Node<E> oldHead = this.head;
    	this.head = new Node<E>(item);
    	head.next = oldHead;
    	current = head;
    }
    
    public void insertLast(E item) {
    	size++;
    	Node end = atEndOfList();
    	end.next = new Node<E>(item);
    }
    
    public int length() {
    	return this.size;
    }
    
    public E delete() {
    	E removed = null;
    	if(this.head == null) return removed;
    	removed = this.head.item;
    	if(this.head.next == null) {		//Condition for if the head is the only value, so that the code doesn't try and grab the next value from a null
    		this.head = null;
    	}else {
    		Node<E> temp = this.head.next;
        	this.head = temp;
    	}
    	size--;
    	return removed;
    }
    
    public Class getListDataType() {		//Get List Data Type
    	return current.getType();
    }
    
    public Node<E> getCurrentNode() {
    	return this.current;
    }
    
    public Node<E> getNextNode() {
    	return getCurrentNode().next;
    }
    
    public String toString() {
    	String s = ""; 			//Empty String
    	goToHead();						//Go to head
    	while(current != null) {			//Iterate through each node, adding each one to the string
    		s += this.current.toString();
    		s += " ";
    		current = current.next;
    	}
    	goToHead();
    	return s;
    }
    
}
