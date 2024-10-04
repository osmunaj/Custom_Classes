public class Graph {
	private LinkedList[] edgesArray;

	private int verticies;
	private int edges;
	boolean undirected;
	
	public Graph(int v){
		this.edgesArray = new LinkedList[v];
		
		for(int i = 0; i < v; i++) {
			edgesArray[i] = new LinkedList();
		}
		
		this.verticies = v;
		this.edges = 0;
		this.undirected = true;
	}
	
	public int verticies() {return this.verticies;}
	public int edges() {return this.edges;}
	
	public void addEdge(int v, int w) {
		edgesArray[v].insert(w);
		System.out.println(v + " CURRENT EDGES: " + edgesArray[v]);
		if(undirected) edgesArray[w].insert(v);
	}
	
	public LinkedList getEdges(int v) {
		return edgesArray[v];
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < edgesArray.length; i++) {
			str += i + ":" + edgesArray[i] + "\n";
		}
		return str;
	}
	
	
}