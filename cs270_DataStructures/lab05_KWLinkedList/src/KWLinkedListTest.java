import static org.junit.Assert.*;

import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

public class KWLinkedListTest {
	KWLinkedList<String> list;
	ListIterator<String> iter;
	@Before
	public void setup(){
		list=new KWLinkedList<String>();
		iter=list.listIterator(0);
		iter.add("aaa");
		iter.add("bbb");
		iter.add("ccc");
		iter.add("ddd");
	}
	

	@Test
	public void testRemoveInt() {
		for(int i=0;i<4;i++){
			iter.previous();
		}
		
		iter.remove();
		assertEquals(3,list.size());
		assertEquals(0,iter.nextIndex());
		assertEquals("bbb",list.get(0));
		assertEquals("ddd",list.get(2));
	}
	
	@Test
	public void testSet(){
		iter.previous();
		iter.set("sss");
		assertEquals(4,list.size());
		assertEquals(3,iter.nextIndex());
		assertEquals("aaa",list.get(0));
		assertEquals("sss",list.get(3));
		
	}

	@Test
	public void testLastIndexOfObject() {
		iter.add("aaa");
		iter.add("bbbbbb");
		assertEquals(4,list.lastIndexOf("aaa"));
	}

	@Test
	public void testIndexOfObject() {
		iter.add("aaa");
		assertEquals(0,list.indexOf("aaa"));
	}

}
