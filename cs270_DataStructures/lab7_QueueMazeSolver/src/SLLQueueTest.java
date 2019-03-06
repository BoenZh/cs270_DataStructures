import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SLLQueueTest {
	SLLQueue<String> names4=null;

	@Before
	public void setUp() throws Exception {
		names4=new SLLQueue<String>();
		names4.offer("hal");
	}

	@Test
	public void testSize() {
		assertEquals(1,names4.size());
		names4.poll();
		assertEquals(0,names4.size());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,names4.isEmpty());
	}

	@Test
	public void testOffer() {
		names4.offer("aaa");
		assertEquals(2,names4.size());
	}

	@Test
	public void testPoll() {
		assertEquals("hal",names4.poll());
	}

	@Test
	public void testRemove() {
		assertEquals("hal",names4.remove());
	}

	@Test
	public void testPeek() {
		assertEquals("hal",names4.peek());
	}

	@Test
	public void testElement() {
		assertEquals("hal",names4.element());
	}

	@Test
	public void testClear() {
		names4.clear();
		assertEquals(0,names4.size());
	}

	@Test
	public void testToString() {
		assertEquals("[hal]",names4.toString());
		names4.offer("aaa");
		assertEquals("[hal, aaa]",names4.toString());
	}

}
