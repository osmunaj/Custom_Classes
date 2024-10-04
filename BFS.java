public class BFS{
	private Graph g;
	private Dictionary dictionary;
	
	private LinkedList<Integer> queue;
	private boolean[] visited;
	
	public int[] distanceTo;
	public String[] pathTo;
	
	
	private String[] routes;
	
	//LinkedList<Value> visited = new LinkedList<Value>();
	public BFS(Graph g, Dictionary d) {
		this.dictionary = d;
		this.g = g;
		this.queue = new LinkedList<Integer>();
		this.visited = new boolean[g.verticies()];
		this.distanceTo = new int[g.verticies()];
		
		
		this.pathTo = new String[g.verticies()];
		for(int i = 0; i < pathTo.length; i++) {
			pathTo[i] = "";
		}
	}
	
	public void printGraph() {
		System.out.println(g);
	}
	
	
	
	public void search(int value, int maxDepth) {
		queue.insertLast(value);
		visited[value] = true;
		distanceTo[value] = 0;
		
		while(!queue.isEmpty()) { 
			int temp = queue.delete();
			
			pathTo[temp] += dictionary.getValue(temp);		
			LinkedList edges = g.getEdges(temp);
			edges.goToHead();
			
			do {
				// For each unvisited neighbor
				int current = (int) edges.getCurData();
				if(!visited[current]) {
					// Add to queue, update paths n stuff
					pathTo[current] += pathTo[temp] + "-";
					distanceTo[current] = distanceTo[temp] + 1;		
					queue.insertLast(current);
					visited[current] = true;
				}
			}while(edges.next() != null);

		}
	}
	
	public String getPathTo(int value) {
		return pathTo[value];
	}
	
	public int getDistanceTo(int value) {
		return distanceTo[value];
	}
	

	
}
