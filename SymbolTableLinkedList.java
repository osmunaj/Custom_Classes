import java.util.TreeMap;
import java.util.Map;


public class SymbolTableLinkedList <E1, E2>{
	
	LinkedList keys;
	LinkedList values;
	
	
	
	public SymbolTableLinkedList() {
		keys = new LinkedList();
		values = new LinkedList();
	}
	
	public int min() {
		int current = (int) keys.getCurData();
		int min = Integer.MAX_VALUE;
		
		while(keys.getNextNode() != null) {
			if(current < min) {
				min = current;
			}
			
		}
		return current;
	}
	
	public int max() {
		int current = (int) keys.getCurData();
		int max = Integer.MIN_VALUE;
		
		while(keys.getNextNode() != null) {
			if(current > max) {
				max = current;
			}
		}
		return current;
	}
	
	public void delete(E1 key) {
		E1 current = (E1) keys.getCurData();
		int currentIndex = 0;
		while(keys.getNextNode() != null) {
			if(current.equals(key)) {
				
				
				return;
			}
			currentIndex ++;
		}
	}
	
	public E2 get(E1 key) {
		
	}
	
	public void put(E1 key, E2 value) {
		
	}
	
	public String toString() {
		String fill = "";
		for(E1 key: treemap.keySet()) {
			fill += (key + ": " + treemap.get(key) + "\n");
		}
		return fill;
	}
	
	
	
}