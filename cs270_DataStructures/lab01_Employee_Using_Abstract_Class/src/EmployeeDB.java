/*
 * Name: Zhang boen
  Assignment: Lab 01
  Title: EMP
  Course: CSCI 270
  Lab Section: 01
  Semester: Fall, 2016
  Instructor: Dr. Blaha
  Date: 9/19/2016
  Sources consulted: none
  Program description: do Emp data
  Known Bugs: add emp has a bug
  Creativity: none
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class contains methods to maintain an Employee database.
 * 
 * @author Dr. Blaha
 */

public class EmployeeDB {
	private Employee[] employees = null; // array to hold HourlyEmp and
											                 // SalariedEmp objects
	private int numEmp;                  // total number of Employee objects

	/**
	 * Read the file with name fileName that has the following format
	 * 
	 * The first line contains a positive integer, n, that specifies the number
	 * of employee records in the file. Each employee record starts with the
	 * class name and is followed by all the fields for that employee. Here is a
	 * small example. 
	 * 3 
	 * HourlyEmp 
	 * 123 
	 * John Smith 
	 * 15.50 
	 * 32 
	 * SalariedEmp 
	 * 124 
	 * Edward Snowden 
	 * 115000.00 
	 * HourlyEmp 
	 * 33 
	 * Mary Laux 
	 * 44.75 
	 * 53
	 * 
	 * @param fileName is the name of the input file.
	 */
	public void readFile(String fileName) {
		Scanner infile = null;
		try {
			infile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found");
			System.exit(0);
		}
		numEmp = Integer.parseInt(infile.nextLine());
		

		employees = new Employee[numEmp+1];
		for (int i = 0; i < numEmp; i++) {
			if (infile.nextLine().equals("HourlyEmp")) {
				int id = Integer.parseInt(infile.nextLine());
				String name = infile.nextLine();
				double payRate = Double.parseDouble(infile.nextLine());
				int hours = Integer.parseInt(infile.nextLine());
				employees[i] = new HourlyEmp(id, name, payRate, hours);
			} else { // SalariedEmp
				int id = Integer.parseInt(infile.nextLine());
				String name = infile.nextLine();
				double annualSalary = Double.parseDouble(infile.nextLine());
				employees[i] = new SalariedEmp(id, name, annualSalary);
			}
		} // for

		infile.close();
		// System.out.println(Arrays.toString(employees));
		

	}// readFile

	/**
	 * Compute the payroll for the current month
	 * 
	 * @return total pay for one month for all employees
	 */
	public double totalPay() {		 
		double result = 0.0;
		for(int i =0;i<numEmp;i++){
			result+=employees[i].computeMonthlyPay();
		}
			
		
		return result;
	}

	/**
	 * Find the employee with the specified id
	 * 
	 * @param id of the employee
	 * @return the employee object with the specified id or null
	 */
	public Employee getEmployee(int id) {
		Employee result =null;
		for(int i =0;i<numEmp;i++){
			if(employees[i].getId()==id)
				result=employees[i];
		}
		
		return result;
	}

	/**
	 * Find and return the number of hourly employees
	 * 
	 * @return the number of hourly employee
	 */
	public int numHourlyEmp() {
		int count=0;
		for(int i =0;i<numEmp;i++){
			if(employees[i] instanceof HourlyEmp)
				count++;
		}
		
		return count;
	}

	/**
	 * Find and return the number of salaried employees
	 * 
	 * @return the number of salaried employee
	 */
	public int numSalariedEmp() {
		int count=0;
		for(int i =0;i<numEmp;i++){
			if(employees[i] instanceof SalariedEmp)
				count++;
		}
		return count;
	}

	/**
	 * Increase all salaried employee salary by percentInc
	 * 
	 * @param percentInc the percentage increase given to all salaried employees
	 */
	public void salariedEmpRaise(double percentInc) {
		
		for(int i =0;i<numEmp;i++){
			if(employees[i] instanceof SalariedEmp){
				
				
			((SalariedEmp) employees[i]).setAnnualSalary(((SalariedEmp) employees[i]).getAnnualSalary()*(1+percentInc));
			}
		}
		 
	}
	

	/**
	 * Add the employee emp to the database (i.e., array employees)
	 * 
	 * @param emp is a reference to the employee we will add to the database
	 */
	public void addEmployee(Employee emp) {
		ArrayList<Employee> a1=new ArrayList<Employee> (Arrays.asList(employees));
		a1.ensureCapacity(numEmp*2);
		
		a1.add(emp);
		numEmp=a1.size();
		
	}

	 

	/**
	 * Write all employee information to the file "fileName" in the format
	 * needed by readFile.
	 * 
	 * @param fileName of the file this method writes to.
	 * @throws FileNotFoundException 
	 */
	public void writeFile(String fileName) throws FileNotFoundException {
		PrintWriter outfile=new PrintWriter("result.txt");
		 for(int i =0;i<numEmp;i++){
			 outfile.println(employees[i]);
		 }
		 outfile.close();
	}

}// EmployeeDB
