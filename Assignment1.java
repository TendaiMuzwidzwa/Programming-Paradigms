/*
Assignment1 (2014) Programming Paradigms

Student Name:Tendai Muzwidzwa

Student Number:2833471

*/
import java.util.*;
class QueueTest{
	public static void main(String args[]){
	//AddAll method
		
		Queue<Integer> q1 = new Queue<>();
		for(int j = 0; j < 15; j++) q1.join(j);
		System.out.println(q1);
		q1.join(2);
		q1.join(13);
		q1.join(9);
		q1.join(4);
		q1.join(7);
		System.out.print(q1);

		Queue<Integer> q2 = new Queue<>();
		q2.join(5); q2.join(14); q2.join(6); 
		System.out.println(q2);
		q2.addAll(q1);
		System.out.print(q2);
		
		Queue<Integer> q3 = new Queue<>();
		System.out.println(q3);
		q3.addAll(q2);
		System.out.println(q3);
		
	//=========================================
	//RemoveAll
	///	q3.removeAllTo(q2);
	//	System.out.println(q3);

		


		//Head
		System.out.print(q1.head());

	//=========================================
	}
}

class Queue<E> implements Iterable<E>{
	private E[] queue;
	private int size = 0;
	private static final int DEFAULT_SIZE = 10;

	@SuppressWarnings("unchecked")
	public Queue(){
		queue = (E[]) new Object[DEFAULT_SIZE];
	}
	void join(E x){
		if(x != null){
			ensureCapacity();
			queue[size++] = x;
		}
	}
	E leave(){
		if(size == 0){
			return null;
		}
		else{	
			queue.removeAll(head());
	
		}
	}
	public E head(){
		if(size != 0){
			return queue[0];		
		}
		else{
			return null;
		}
	}
	boolean isEmpty(){return size == 0;}
	int size(){return size;}
	private void ensureCapacity(){
		if(size == queue.length)
			queue = Arrays.copyOf(queue,2*size+1);
	}
	//Use this method to shuffle elements one position left in leave method above
	private void shuffle(){
		for(int j = 0; j < size;j++) queue[j] = queue[j+1];
		queue[size] = null;  //eliminate obsolete reference
		size--;
	}

	//Method addAll below works for adding elements from one queue to current one
	public void addAll(Queue<? extends E> queue){
		for(E x:queue) this.join(x);
		

	}
	public void addAll(Iterable<? extends E>queue){
		for(E x:queue) this.join(x);

	}
/*	public void removeAllTo(Collection<? super E> queue){
		for(E x:this) queue.shuffle(x);
	}*/
	public String toString(){
		if(size == 0) return "[]";
  	String s = "[";
  	for(int j = 0; j < size-1; j++)
  		s = s + queue[j]+", ";
  	s = s + queue[size-1]+"]";
  	return s;
	}
	public boolean equals(Object ob){
		if(!(ob instanceof Queue)) return false;
		Queue<?>queue = (Queue<?>)ob;
		if(this.size() != queue.size) return false;
		Iterator it = queue.iterator();
		for( E x: this){
			if(!x.equals(it.next())) return false;
		}
		return true;

	}
	public Iterator<E> iterator(){
		return new QueueIterator<E>(queue, size);
	}
	//static Queue methods
	public static <T> void copy(Queue<? super T> dst, Queue<? extends T> src){
		for(T x : src) dst.join(x);
	}
	private static class QueueIterator<E> implements Iterator<E>{
		private E[] st;
		private int index = 0;
		private int size;
		QueueIterator(E[] st1, int s){ st = st1; size = s;}
		public boolean hasNext(){ return index < size;}
		public E next(){
			if(index == size) throw new NoSuchElementException();
			E el = (E)st[index++];
			return el;
		}
		public void remove(){}
	}
}