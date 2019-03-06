import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author dr. Blaha
 * JUnit test class for SalariedEmp
 */
public class SalariedEmpTest {

	//SalariedEmp object used for testing
	SalariedEmp e1 = null;
	
	//This method is executed before each Test to setup test cases
	@Before
	public void setUp() throws Exception {
		e1 = new SalariedEmp(124, "Mary Laux", 75000.00);
	}
	
	//Test the constructor 
	@Test
	public void testSalariedEmp() {
		assertEquals(124, e1.getId());
		assertEquals("Mary Laux", e1.getName());
		assertEquals(75000.00, e1.getAnnualSalary(), 0.005);		 
	}
	
	//Test computePay
	@Test
	public void testCommputePay() {
		assertEquals(75000.00/12, e1.computeMonthlyPay(), 0.005);
	}
	
	//Test raise
	@Test
	public void testRaise() {
		e1.raise(1450.00);
		assertEquals(76450, e1.getAnnualSalary(), 0.005);		
	}

	//Test toString
	@Test
	public void testToString() {
		 assertEquals("SalariedEmp\n124\nMary Laux\n75000.00", e1.toString());
	}

}
