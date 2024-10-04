//MinPQ class came from Algorithms - 4th Edition by Robert Sedgewick & Kevin Wayne

public class MinPQ <Data extends Comparable<Data>>{
	private Data[] pq;			
	private int N = 0;
	public MinPQ(int maxN) {
		pq = (Data[]) new Comparable[maxN + 1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void insert(Data v) {
		pq[++N] = v;
		swim(N);
	}
	
	public Data delMin() {
		Data min = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);
		return min;
	}
	
	private void swim(int k){				// Implemented swim method
		while (k > 1 && less(k/2, k)){
			exch(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k){				// Implemented sink method
		while (2*k <= N){
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	private boolean less(int i, int j){ 
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j){
		 Data t = pq[i]; 
		 pq[i] = pq[j];
		 pq[j] = t;
	}
	
	public String toString() {
		String output = "";
			
		for(Data d: this.pq) {
			if(d != null) {
				output += d + "";
			}
			
		}
		return output;
	}
	
	public void sort() {
		
		for(int k = N/2; k >= 1; k--) {
			sink(N);
		}
		
		while(N > 1) {
			exch(1, N--);
			sink(1);
		}
		
	}
	
}
