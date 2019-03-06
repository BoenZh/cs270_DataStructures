/**
 * Name: zhang boen
  Assignment: Lab 07
  Title: mazeSlover
  Course: CSCI 270
  Lab Section: 01
  Semester: Fall, 2016
  Instructor: Dr. Blaha
  Date: 11/7/2016
  Sources consulted: none
  Program description: solve maze
  Known Bugs: none
  Creativity: none
 */

import java.util.NoSuchElementException;

/**
 * 
 */

/**
 * @author zhangbb
 *
 */
public class SLLQueue<E> implements PureQueue<E> {
	
	 private static class Node<E> {

	        /** The data value. */
	        private E data;
	        /** The link */
	        private Node<E> next = null;

	        /**
	         * Construct a node with the given data value and link
	         * @param data - The data value 
	         * @param next - The link
	         */
	        public Node(E data, Node<E> next) {
	            this.data = data;
	            this.next = next;
	        }

	        /**
	         * Construct a node with the given data value
	         * @param data - The data value 
	         */
	        public Node(E data) {
	            this(data, null);
	        }
	    }
	    /*</listing>*/
	    // Data fields
	    /** A reference to the head of the list */
	    private Node<E> front = null;
	    private Node<E> rear = null;
	    /** The size of the list */
	    private int size = 0;
	    
	
	
	

	    /**
		 * Determines the number of elements in this PureQueue object.
		 *
		 * @return the number of elements in this PureQueue object.
		 *
		 */
	@Override
	public int size() {
		
		return size;
	}

	/**
	 * Determines if this PureQueue object has no elements.
	 *
	 * @return true - if this PureQueue object has no elements; otherwise,
	 *                return false.
	 *
	 */
	@Override
	public boolean isEmpty() {
		if(size==0)
			return true;
		else
			return false;
	}
	
	
	/**
	 * Inserts the specified element into this queue.
	 * @param o the element to insert.
	 * @return <tt>true</tt> if it was possible to add the element to
	 * this queue, else <tt>false</tt>
	 */
	@Override
	public boolean offer(E o) {
		if(size==0){
			rear=new Node<E>(o);
			front=rear;
		}
		else{
			rear.next=new Node<E>(o);
			rear=rear.next;
		}
		size++;
		
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or <tt>null</tt>
	 * if this queue is empty.
	 *
	 * @return the head of this queue, or <tt>null</tt> if this
	 *		   queue is empty.
	 */
	@Override
	public E poll() {
		if(size==0)
			return null;
		E item=front.data;
		if(size==1){
			this.clear();
		}
		else{
			
		
		front=front.next;
		size--;
		
		}
		return item;
	}

	/**
	 * Retrieves and removes the head of this queue.  This method
	 * differs from the <tt>poll</tt> method in that it throws an
	 * exception if this queue is empty.
	 *
	 * @return the head of this queue.
	 * @throws NoSuchElementException if this queue is empty.
	 */
	@Override
	public E remove() throws  NoSuchElementException {
		if(size==0)
			throw new NoSuchElementException();
		E item=front.data;
		if(size==1){
			this.clear();
		}
		else{
			
		
		front=front.next;
		size--;
		
		}
		return item;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue,
	 * returning <tt>null</tt> if this queue is empty.
	 *
	 * @return the head of this queue, or <tt>null</tt> if this queue
	 * is empty.
	 */
	@Override
	public E peek() {
		if(size==0){
			return null;
		}
		E item=front.data;
		
		
		return item;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue.	This method
	 * differs from the <tt>peek</tt> method only in that it throws an
	 * exception if this queue is empty.
	 *
	 * @return the head of this queue.
	 * @throws NoSuchElementException if this queue is empty.
	 */
	@Override
	public E element() throws NoSuchElementException {
		if(size==0)
			throw new NoSuchElementException();
		
		E item=front.data;
		
		return item;
	}
	
	/**
	 * remove all element from the queue
	 */
	public void clear(){
		rear.data=null;
		front=rear;
		size=0;
	}
	
	
	/**
	 * return sth
	 */
	public String toString(){
		
		
		String result="[";
		Node<E> temp=front;
		for(int i=0;i<size-1;i++){
			result+=temp.data+", ";
			temp=temp.next;
		}
		result+=temp.data+"]";
		
		return result;
	}
	

}
