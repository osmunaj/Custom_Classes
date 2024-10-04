
public class GenericGraph <Key extends Comparable<Key>, Value>{
	
	public class Vertex <Key extends Comparable<Key>, Value> {
		Key key;
		Value value;
		LinkedList neighbours;
		
		public Vertex(Key k, Value v) {
			this.key = k;
			this.value = v;
			neighbours = new LinkedList();
		}
		
		public void addEdge(Vertex n) {
			this.neighbours.insert(n);
		}
		public String toString() {
			return (String) this.value; 
		}
		public Value getValue() {
			return this.value;
		}
		public boolean equals(Vertex v) {
			return v.value.equals(this.value);
		}
	}
	
	private Vertex[] edgesArray;
	
	private final int verticies;
	private int edges;
	
	public LinkedList getEdges(Value value) {
		Vertex vVertex = null;
		for(Vertex v: edgesArray) {
			if(v.value.equals(value)) {
				vVertex = v;
				break;
			}
		}
		if(vVertex == null) {
			System.out.println("No vertex found - attempted: " + value);
			return null;
		}
		vVertex.neighbours.goToHead();
		return vVertex.neighbours;
	}
	
	public LinkedList getEdgesValues(Value value) {
		LinkedList vertexList = getEdges(value);
		LinkedList valueList = new LinkedList();
		vertexList.goToHead();
		do {
			valueList.insert(((Vertex) vertexList.getCurData()).getValue());
		}while(vertexList.next() != null);
		
		//if(valueList.isEmpty()) System.out.println("SHE EMPTY FUCK");
		return valueList;
	}
	
	public GenericGraph(int v) {
		this.edgesArray = new Vertex[v];
		this.verticies = v;
		this.edges = 0;
	}
	
	public int verticies() {return this.verticies;}
	public int edges() {return this.edges;}
	
	
	public void addEdge(Value v, Value w) {
		Vertex vVertex = null;
		Vertex wVertex = null;
		
		for(int i = 0; i < verticies; i++) {
			if(edgesArray[i] == null) {
				if(vVertex == null && wVertex == null) {
					vVertex = new Vertex(i, v);
					edgesArray[i] = vVertex;
					wVertex = new Vertex(i + 1, w);
					edgesArray[i+1] = wVertex;
				}
				if(vVertex == null) {
					vVertex = new Vertex(i, v);
					edgesArray[i] = vVertex;
				}
				if(wVertex == null) {
					wVertex = new Vertex(i, w);
					edgesArray[i] = wVertex;
				}
				break;
			}
			if(edgesArray[i].value.equals(v)) vVertex = edgesArray[i];
			if(edgesArray[i].value.equals(w)) wVertex = edgesArray[i];
		}
		vVertex.addEdge(wVertex);
		this.edges++;	
	}
	
	public String toString() {
		String print = "";
		for(Vertex v: edgesArray) {
			print += v.value;
			print += ": ";
			print += v.neighbours.toString() + "\n";
			v.neighbours.goToHead();
			//print += v.value + ": " + v.edges.toString() + "\n";
		}
		return print;
	}
	
}
