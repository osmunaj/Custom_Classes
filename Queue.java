public class Queue <E>{
	
	private LinkedList<E> data;
	private int size;
	
	
	public Queue() {
		this.data = new LinkedList<E>();
		this.size = 0;
	}
	
	public void enqueue(E e) {
		this.data.insertLast(e);
		this.size++;
	}
	
	public E dequeue() {
		if(this.size != 0) {
			E removed = this.data.delete();
			this.data.delete();
			this.size--;
			return removed;
		}else {
			return null;
		}
		
	}
	
	
}
