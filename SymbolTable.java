import java.util.TreeMap;
import java.util.Map;


public class SymbolTable <E1, E2>{
	
	private Map<E1, E2> treemap;
	
	public SymbolTable() {
		treemap = new TreeMap<>();
	}
	
	public E1 min() {
		return ((TreeMap<E1, E2>) treemap).firstKey();
	}
	
	public E1 max() {
		return ((TreeMap<E1, E2>) treemap).lastKey();
	}
	
	public void delete(E1 key) {
		treemap.remove(key);
	}
	
	public E2 get(E1 key) {
		return treemap.get(key);
	}
	
	public void put(E1 key, E2 value) {
		treemap.put(key, value);
	}
	
	public String toString() {
		String fill = "";
		for(E1 key: treemap.keySet()) {
			fill += (key + ": " + treemap.get(key) + "\n");
		}
		return fill;
	}
	
	
	
}
