import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EmployeeDBTest {

	//EmployeeDB object used for testing
	EmployeeDB db = null;
	
	
	@Before
	public void setUp() throws Exception {
		db = new EmployeeDB();
		db.readFile("employeeData.txt");
		
	}

	@Test
	public void testReadFile() {
		assertEquals("HourlyEmp\n123\nJohn Smith\n15.50\n32", db.getEmployee(123).toString());
		assertEquals("SalariedEmp\n124\nEdward Snowden\n115000.00", db.getEmployee(124).toString());
		assertEquals("HourlyEmp\n33\nMary Laux\n44.75\n53",  db.getEmployee(33).toString());
	}

	@Test
	public void testTotalPay() {
		assertEquals(12451.08, db.totalPay(), 0.005);
	}

	@Test
	public void testGetEmployee() {
		assertEquals("HourlyEmp\n123\nJohn Smith\n15.50\n32", db.getEmployee(123).toString());
		assertEquals("SalariedEmp\n124\nEdward Snowden\n115000.00", db.getEmployee(124).toString());
		assertEquals("HourlyEmp\n33\nMary Laux\n44.75\n53",  db.getEmployee(33).toString());
		assertEquals(null, db.getEmployee(22));
	}

	@Test
	public void testNumHourlyEmp() {
		assertEquals(2, db.numHourlyEmp());		 
	}
	
	@Test
	public void testNumSalariedEmp() {		 
		assertEquals(1, db.numSalariedEmp());
	}

	@Test
	public void testSalariedEmpRaise() {
		 db.salariedEmpRaise(0.10);
		 assertEquals("SalariedEmp\n124\nEdward Snowden\n126500.00", db.getEmployee(124).toString());
	}
	
	@Test
	public void testAddEmployee(){
		Employee emp = new SalariedEmp(125, "Hal Ramsey", 250000.00);
		db.addEmployee(emp);
		assertEquals("SalariedEmp\n125\nHal Ramsey\n250000.00", db.getEmployee(125).toString());
		assertEquals(2, db.numSalariedEmp());
		assertEquals(2, db.numHourlyEmp());		
	}
	
	@Test
	public void testEquals(){		
		assertFalse(db.getEmployee(123).equals(db.getEmployee(124)));
		assertFalse(db.getEmployee(123).equals(db.getEmployee(33)));
		assertTrue(db.getEmployee(123).equals(db.getEmployee(123)));
		assertTrue(db.getEmployee(124).equals(db.getEmployee(124)));
		
		//test Employee type is checked by equals
		Employee emp = new SalariedEmp(123, "Hal Ramsey", 250000.00);
		assertFalse(emp.equals(db.getEmployee(123)));
	}

}
