public class BinarySearchTree <Key extends Comparable<Key>, Value>{
	public class Node{
		private Key key;	// Key
		private Value value;	// Value
		private Node leftBranch;	// links to left branch
		private Node rightBranch;	// links to right branch
		private int numberOfNodes;	// number of nodes in subtree rooted here
		
		public Node(Key key, Value value, int n) {
			this.key = key;
			this.value = value;
			this.numberOfNodes = n;
			this.leftBranch = null;
			this.rightBranch = null;
		}
	}
	
	private Node root; // Root of Binary Search Tree
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if(x == null) {
			return 0;	//Returns zero if the current node is null
		}else {
			return x.numberOfNodes; // Returns the number of Nodes each subtree has to find total
		}
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	private Value get(Node current, Key key) {  
		if(current == null){	
			return null;	// if the current node is empty, return null
		}
		int compare = key.compareTo(current.key);	//Compare the key of the searched node to the current node
		if(compare < 0) {
			return get(current.leftBranch, key);	//If its less than the current, go left
		}
		else if(compare > 0) {
			return get(current.rightBranch, key);	//If its greater than the current, go right
		}
		else {
			return current.value;	// If it's equal to the current 
		}
	}
	
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	
	private Node put(Node current, Key key, Value value) {
		if(current == null) {
			return new Node(key, value, 1);	// If the current position is empty, add a new Node there with the given key and values
		}
		int compare = key.compareTo(current.key);	// Compare the new key to the current key
		if(compare < 0) {
			current.leftBranch = put(current.leftBranch, key, value);	//If its less than the current, go left
		}
		else if(compare > 0) {
			current.rightBranch = put(current.rightBranch, key, value);	//If its greater than the current, go rightS
		}
		else {
			current.value = value;	// if the keys are equal, set the current value to the new value
		}
		current.numberOfNodes = size(current.leftBranch) + size(current.rightBranch) + 1;	//Update size of the subtrees
		return current;	//Return the current node
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	
	private void inOrder(Node current) {
		if(current == null) {
			return;
		}
		inOrder(current.leftBranch);
		System.out.print(current.key + " ");
		inOrder(current.rightBranch);
	}
	
	
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node current) {
		if(current == null) {
			return; 								//Ends the recursive function if the current node is empty
		}
		System.out.print(current.key + " ");		//Prints current branch
		preOrder(current.leftBranch);				//Traverses the Left Tree
		preOrder(current.rightBranch);				//Traverses the right Tree
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node current) {
		if(current == null) {
			return; 								//Ends the recursive function if the current node is empty
		}
		preOrder(current.leftBranch);				//Traverses the Left Tree
		preOrder(current.rightBranch);				//Traverses the Right Tree
		System.out.print(current.key + " ");		//Prints current branch
	}
		
	
	
	public void levelOrder() {
		levelOrder(root);
	}
	
	private void levelOrder(Node current) {
		if(current == null) {
			return;
		}
		
		if(current.leftBranch != null && current.rightBranch != null) {
			System.out.print(current.key + " ");
			System.out.print(current.leftBranch.key + " ");
			System.out.print(current.rightBranch.key + " ");
			levelOrder(current.leftBranch);
			levelOrder(current.rightBranch);
		} 
		
		else if(current.leftBranch == null && current.rightBranch == null) {
			System.out.print(current.key + " ");
		}
		
		else if(current.leftBranch != null) {
			levelOrder(current.leftBranch);
		}
		
		else {
			levelOrder(current.rightBranch);
		}
	}
	
	
	
	
}


