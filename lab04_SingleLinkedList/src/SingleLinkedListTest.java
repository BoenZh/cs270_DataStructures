import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {
	SingleLinkedList<String> item1, item2,item3,item4;

	@Before
	public void setUp() throws Exception {
		item1 = new SingleLinkedList<String>();
		item2 = new SingleLinkedList<String>();
		item3 = new SingleLinkedList<String>();
		item4 = new SingleLinkedList<String>();
		item2.add("aaa");
		item2.add("bbb");
		item2.add("ccc");
		item2.add("ccc");
		item3.add("abc");
		
		
	}

	@Test (expected= IndexOutOfBoundsException.class)
	public void testRemoveInt() {
		item1.remove(1);
		assertEquals("bbb",item2.remove(1));
		assertEquals("abc",item3.remove(3));
	}
	
	@Test 
	public void testRemoveE() {
		assertTrue(item2.remove("bbb"));
		assertFalse(item1.remove("bcde"));
		
	}
	
	@Test
	public void testIndex(){
		assertEquals(0,item2.indexOf("aaa"));
		assertEquals(-1,item3.indexOf("bcde"));
	
	}

	@Test
	public void testLastIndex(){
		assertEquals(3,item2.lastIndexOf("ccc"));
	}
	
	@Test
	public void testIsEmpty(){
		assertTrue(item1.isEmpty());
		assertFalse(item2.isEmpty());
		
	}
	
	@Test
	public void testClear(){
		item2.clear();
		assertTrue(item2.isEmpty());
	}
	@Test
	public void contain(){
		assertTrue(item2.contains("ccc"));
		assertFalse(item1.contains("ccc"));
	}
	
	@Test
	public void add2(){
		item2.add2(1, "abcde");
		item4.add2(0, "abcde");
		assertTrue(item2.contains("abcde"));
		assertEquals(0,item4.indexOf("abcde"));
		assertEquals(1,item2.indexOf("abcde"));
		
	}

}
