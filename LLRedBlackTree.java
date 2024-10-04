
//LLRedBlackTree taken from Algorithms: 4th Edition
 
public class LLRedBlackTree<Key extends Comparable<Key>, Value>{
	private Node root;
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		Key key;			//Key
		Value val;			//associated data
		Node left, right; 	//subtrees
		boolean color; 		//Color of link
		
		Node(Key key, Value val, boolean color){
			this.key = key;
			this.val = val;
			this.color = color;
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
			return get(current.left, key);	//If its less than the current, go left
		}
		else if(compare > 0) {
			return get(current.right, key);	//If its greater than the current, go right
		}
		else {
			return current.val;	// If it's equal to the current 
		}
	}
	
	private boolean isRed(Node x) {
		if(x == null) return false;
		return x.color == RED;
	}
	
	public String getColor(Key key) {
		if(getColor(root, key).color){
			return "Red";
		}
		return "black";
	}
	
	public Node getColor(Node current, Key key) {
		if(current == null){	
			return null;	// if the current node is empty, return null
		}
		int compare = key.compareTo(current.key);	//Compare the key of the searched node to the current node
		if(compare < 0) {
			return getColor(current.left, key);	//If its less than the current, go left
		}
		else if(compare > 0) {
			return getColor(current.right, key);	//If its greater than the current, go right
		}
		else {
			return current;	// If it's equal to the current 
		}
	}
	
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.color = h.color;
		h.color = RED;
		
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public void put(Key key, Value val) {	//Search for key. Update value if found, grow table if new
		root = put(root, key, val);
		root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val) {	
		if(h == null) { //Do standard insert, with red link to parent
			return new Node(key, val, RED);
		}
		int cmp = key.compareTo(h.key);
		if(cmp < 0) {
			h.left = put(h.left, key, val);
		}
		else if(cmp > 0) {
			h.right = put(h.right, key, val);
		}
		else {
			h.val = val;
		}
		
		if(isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);
		}
		if(isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		if(isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		return h;
		
	}
	
	
	
}
