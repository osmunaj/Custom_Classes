
public class SCHashTable<Key, Value> {
    private static final int INIT_CAPACITY = 5;
    
    private LinkedList[] data;
    private int m;                                // array size
    
    
    // Key is hashcode
    
    // Value is Order which it came in 
    
    // Hash value: which array it's in
    
    private static class Node<Key, Value> {
    	private Key key;
    	private Value value;
    	
    	public Node(Key k, Value v) {
    		this.key = k;
    		this.value = v;
    	}
    	
    	public String toString() {
    		return key + ":" + value;
    	}
    }
    
    public SCHashTable() {		// Constructor, if no argument is given, uses default array size of 5
    	this(INIT_CAPACITY);
    }
    
    public SCHashTable(int m) {
    	this.m = m;
    	data = new LinkedList[m];								// Creates new array of linked lists, initializes each list in each array slot
    	for(int i = 0; i < m; i++) data[i] = new LinkedList();
    }
    
    
    public void put(Key key, Value value) {			// Finds the index (which array the key should be in) by hashing it, and creating
    	int index = hash(key);					// a node with the hashed key and value
    	Node n = new Node(hash(key), value);
    	data[index%5].insert(n);
    }
    
    public Value get(Key key) {				
    	int index = (Integer) key%m; 
    	LinkedList l = data[index];
    	
    	do {
    		String tempArr[] = l.getCurData().toString().split(":");		// Itterate through linked list, check if key is equal to 
    		if(key.equals(tempArr[0])) {									// Current, if so, return the Value. Otherwise return null
    			return (Value) tempArr[1];
    		}
    	}while(l.nextData());
    	
    	return null;
    	
    }
    
    public int hash(Key key) {				// Takes the char, turns it into an int using ascii, subtracts 64 to get position in the alphabet,
    	String s = (String) key;			// multiplies it by 11
    	return (((int) (s.charAt(0) - 64)) * 11);
    }
    
    public char unHash(Key i) {				// Does the opposite of hash() to get the char value of an integer
    	return (char) (((int) i / 11) + 64);
    }
    
    public String toString() {			
    	String s = "";
    	for(int i = 0; i < m; i++) {
    		String[] tempArr = data[i].toString().split(" ");		// Go through each array slot
    		for(String tempStr: tempArr) {
    			String[] tempArr2 = tempStr.split(":");				// Turn linked list to string, make formatting nicer
    			s += unHash((Key) Integer.valueOf(tempArr2[0])) + "\t" + tempArr2[1] + "\t" + "Hash: " + i + "\n";
    		}
    	}
    	return s;
    }

}