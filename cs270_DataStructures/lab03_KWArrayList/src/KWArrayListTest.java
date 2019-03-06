import static org.junit.Assert.*;

import org.junit.Test;

public class KWArrayListTest {

	

	@Test
	public void testClear() {
	KWArrayList<String> myList=new KWArrayList();
	myList.add("m");
	myList.add("lol");
	myList.add("gogo");
	assertEquals(3,myList.size());
	myList.clear();
	assertEquals(0,myList.size());
	
		
	}

	
		
	

	@Test
	public void testAddIntE() {
		KWArrayList<String> myList=new KWArrayList();
		myList.add("m");
		myList.add("lol");
		myList.add("gogo");
		assertEquals(3,myList.size());
		myList.add(0,"first");
		assertEquals(4,myList.size());
		assertEquals("first",myList.get(0));
	}

	@Test
	public void testIndexOf() {
		KWArrayList<String> myList=new KWArrayList();
		myList.add("m");
		myList.add("lol");
		myList.add("gogo");
		myList.add("lol");
		myList.add("lol");
		assertEquals(5,myList.size());
		assertEquals(1,myList.indexOf("lol"));
	}

	@Test
	public void testLastIndexOf() {
		KWArrayList<String> myList=new KWArrayList();
		myList.add("m");
		myList.add("lol");
		myList.add("gogo");
		myList.add("gogo");
		myList.add("gogo");
		assertEquals(4,myList.lastIndexOf("gogo"));
	}

	@Test
	public void testRemoveE() {
		KWArrayList<String> myList=new KWArrayList();
		myList.add("m");
		myList.add("lol");
		myList.add("gogo");
		assertEquals(true,myList.remove("lol"));
		assertEquals("gogo",myList.get(1));
		assertEquals(2,myList.size());
		
		
	}
	@Test
	public void testContain(){
		KWArrayList<String> myList=new KWArrayList();
		myList.add("m");
		myList.add("lol");
		myList.add("gogo");
		
		assertEquals(true,myList.contains("lol"));
	}

}
