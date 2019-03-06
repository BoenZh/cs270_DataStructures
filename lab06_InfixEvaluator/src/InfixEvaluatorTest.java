import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InfixEvaluatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExpression01() {
	  assertEquals( 1, InfixEvaluator.evaluate("7 - 3 * 2") );
	}
	@Test
	public void testExpression02() {
	  assertEquals( 8, InfixEvaluator.evaluate("( 7 - 3 ) * 2") );
	}

}
