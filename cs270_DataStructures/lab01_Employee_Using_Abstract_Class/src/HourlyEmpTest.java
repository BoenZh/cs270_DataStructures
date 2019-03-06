import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author dr. Blaha
 * JUnit test class for HourlyEmp
 */
public class HourlyEmpTest {

	//HourlyEmp object used for testing
	HourlyEmp e1=null;
	 
	//This method is executed before each Test
	@Before
	public void setUp() throws Exception {
		e1 = new HourlyEmp(123, "John Smith", 12.5, 20);
	}

	
	//test constructor
	@Test
	public void testHourlyEmp() {
		assertEquals(123, e1.getId());
		assertEquals("John Smith", e1.getName());
		assertEquals(12.5, e1.getPayRate(), 0.005);
		assertEquals(20, e1.getHours());		 
	}
	
	//Test computePay
	@Test
	public void testComputePay() {
		assertEquals(12.5*20, e1.computeMonthlyPay(), 0.005);
	}
	
	//Test addHours
	@Test
	public void testAddHours() {
		e1.addHours(5);
		assertEquals(25, e1.getHours());
	}
	
	//Test raise
	@Test
	public void testRaise() {
		e1.raise(1.5);
		assertEquals(14.0, e1.getPayRate(), 0.005);		
	}
	
	//Test toString	
	@Test
	public void testToString() {
		 assertEquals("HourlyEmp\n123\nJohn Smith\n12.50\n20", e1.toString());
	}	

}
