public class Stack <E>{
	
	private LinkedList<E> data;
	private int size;
	
	
	public Stack() {
		this.data = new LinkedList<E>();
		this.size = 0;
	}
	
	public void push(E e) {
		this.data.insert(e);
		this.size++;
	}
	
	public E pop() {
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
