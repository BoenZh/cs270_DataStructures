import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	BinarySearchTree<String> a1;
	
	@Before
	public void setUp() throws Exception {
		a1= new BinarySearchTree<String>();
		a1.add("a");
		a1.add("b");
		a1.add("c");
		a1.add("d");
	}

	@Test
	public void testToString() {
		assertEquals("a b c d",a1.toString());
	}

	@Test
	public void testSize() {
		assertEquals(4,a1.size());
	}

	@Test
	public void testFindMin() {
		assertEquals("a", a1.findMin());
	}

	@Test
	public void testFindMax() {
		assertEquals("d",a1.findMax());
	}

	@Test
	public void testRemoveMin() {
		assertEquals(true,a1.removeMin());
	}

	@Test
	public void testRemoveMax() {
		assertEquals(true,a1.removeMax());
	}

	@Test
	public void testLeaves() {
		assertEquals(2,a1.leaves());
	}

	@Test
	public void testHeight() {
		assertEquals(3,a1.height());
	}

}
