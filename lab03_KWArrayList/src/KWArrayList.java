/*
 *  Name: Zhang boen
  Assignment: Lab 3
  Title: SWArrayList
  Course: CSCI 270
  Lab Section: 01
  Semester: Fall, 2016
  Instructor: Dr. Blaha
  Date: 10/3/2016
  Sources consulted: none
  Program description: it do an arrayList
  Known Bugs: none
  Creativity: none
 */


import java.util.Arrays;
import java.util.AbstractList;



/**
 * This class implements some of the methods of the Java
 *  ArrayList class.
 *  @author Koffman, Wolfgang, &DB
 */
public class KWArrayList<E>       
{
	// Data Fields

	/** The default initial capacity */
	private static final int INITIAL_CAPACITY = 10;
	/** The underlying data array */
	private E[] theData;
	/** The current size */
	private int size = 0;
	/** The current capacity */
	private int capacity = 0;

	/**
	 * Construct an empty KWArrayList with the default
	 * initial capacity
	 */
	public KWArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}


	/**
	 * Appends the specified element to the end of this list.
	 * @param anEntry - element to be appended to this list
	 */
	public boolean add(E anEntry) {
		if (size == capacity) {
			reallocate();
		}
		theData[size] = anEntry;
		size++;
		return true;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts 
	 * any subsequent elements to the left (subtracts one from their indices).
	 * @param index - The index of the entry to be removed
	 * @return the element that was removed from the list
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for (int i = index + 1; i < size; i++) {
			theData[i - 1] = theData[i];
		}
		size--;
		return returnValue;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index - The index of the item returned
	 * @return the element at the specified position in this list
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}


	/**
	 * Get the current size of the array
	 * @return The current size of the array
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns a string representation of this collection. The string 
	 * representation consists of a list of the collection's elements 
	 * order, enclosed in square brackets ("[]"). Adjacent elements 
	 * are separated by the characters ", "  (comma and space).  
	 * This is the string representation returned by Java's ArrayList	 
	 * @return a string representation of the collection
	 */ 
	public String toString(){
		StringBuilder s = new StringBuilder("[");
		for (int i=0; i<size-1; i++){
			s.append(theData[i]+", ");
		}
		if (size>0)
			s.append(theData[size-1]);
		s.append("]");
		return s.toString();
	}

	/**
	 * Allocate a new array to hold the directory
	 */
	private void reallocate() {
		capacity = 2 * capacity;
		theData = Arrays.copyOf(theData, capacity);
	}



	/**************************************************************/
	/**************Implement The Following Methods ****************/
	/**************************************************************/

	/**
	 * Construct an empty KWArrayList with a specified initial capacity
	 * @param capacity The initial capacity
	 */
	public KWArrayList(int capacity) {
		this.capacity=capacity;

	}


	/**
	 * Removes all of the elements from this list (optional operation). 
	 * The list will be empty after this call returns.
	 */
	public void clear() {
		for(int i=0;i<size;i++){
			theData[i]=null;
			
		}
		size=0;

	}


	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 * @param index - The index of the item to replace
	 * @param newValue - The new value to store at this position
	 * @return the element previously at the specified position
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E set(int index, E newValue) {
		E result=null;
		if(index<0||index>=size)
			throw new ArrayIndexOutOfBoundsException();
		else{
			result=this.get(index);
			theData[index]=newValue;
			return result;
		}

		
	}


	/**
	 * Inserts the specified element at the specified position in 
	 * this list. Shifts the element currently at that position 
	 * (if any) and any subsequent elements to the right 
	 * (adds one to their indices).
	 * @param index -  index at which the specified element is to 
	 *                 be inserted
	 * @param theValue - The value to be inserted
	 * @throws ArrayIndexOUtOfBoundsException if index is
	 *         less than zero or greater than size
	 */
	public boolean add(int index, E anEntry) {
		
		
		if(index<0||index>=size)
			throw new ArrayIndexOutOfBoundsException();
		if(size==capacity)
			reallocate();
		else{
			
			
			for(int i=size;i>index;i--){
			theData[i]=theData[i-1];
			}	
			theData[index]=anEntry;
			size++;
		}

		return true;
	} 
	
	


	/**
	 * Returns the index of the first occurrence of the specified element 
	 * in this list, or -1 if this list does not contain the element.  
	 * @param element to search for
	 * @return the index of the first occurrence of the specified element 
	 *       in this list, or -1 if this list does not contain the element
	 */
	public int indexOf(E item) {
		int result=-1;
		
		/*for(int i=size-1;i>-1;i--){
			if(item.equals(theData[i]))
				result=i;
		}
		*/
		
		boolean cheack=false;
		int count=0;
		while(cheack==false && count<size){
			if(item.equals(theData[count])){
				result=count;
				cheack=true;
			}
			count++;
			
		}

		return result;
	}


	/**
	 * Returns true if this list contains the specified element.
	 * @param item - element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(E item) {	
		boolean cheack=false;
		int count=0;
		while(cheack==false || count<size){
			if(item.equals(theData[count]))
				cheack=true;
			count++;
			
		}
		
		
		
		
		return  cheack;
	}


	/**
	 * Returns true if this list contains no elements and false otherwise.
	 * @return true if this list contains no elements and false otherwise.
	 */
	public boolean isEmpty() {	
		if(size==0)
			return true;
		else
			return false;
	}


	/**
	 * Returns the index of the last occurrence of the specified 
	 * element in this list, or -1 if this list does not contain the 
	 * element.  
	 * @param item element to search for
	 * @return the index of the last occurrence of the specified element in 
	 * 		this list, or -1 if this list does not contain the element
	 */
	public int lastIndexOf(E item) {	
		int result=-1;
		for(int i=0;i<size;i++){
			if(item.equals(theData[i]))
				result=i;
		}
		
		
		
		return result;
	}

	/**
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present. If the list does not contain the element, it is unchanged.
	 * @param item - element to be removed from this list, if present
	 * @return true if item is found and removed; otherwise, return false.
	 */
	public boolean remove(E item) {    	 
		boolean cheack=false;
		int count=0;
		
		while(cheack==false || count<size){
			if(item.equals(theData[count])){
				for(int i=count+1;i<size;i++){
					theData[i-1]=theData[i];
				}
				size--;
				cheack=true;
			}
			count++;
		}
		
		
		
		return cheack;
	}
	
	/**
	 * If you are one of the first 3 people to email me "I read the lab"
	 * before 9:00 AM Tuesday, I will give you 5 in-class bonus points.
	 *
	 */


}

