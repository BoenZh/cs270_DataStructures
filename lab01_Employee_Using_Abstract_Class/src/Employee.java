
/**
 * @author Dr. Blaha
 * The Employee class is the abstract superclass for HourlyEmp and SalariedEmp.
 * It contains the two fields, id and name, that both subclasses have in common.
 * It has two abstract methods, computeMonthlyPay() and raise() that both subclasses
 * have in common.
 */
public abstract class Employee {
	protected int id;			//employee id is unique for each employee
	protected String name;		//firstName lastName
	
	
	/**
	 * constructor for Employee
	 * @param id is the employee's id
	 * @param name contains both first name and last name (e.g., John Doe)
	 */
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	/**
	 * Getter for field id
	 * @return the unique id
	 */
	public int getId() {
		return id;
	}


	/**
	 * Getter for field name
	 * @return the first and last name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Return the fields in the format needed for reading (and writing) from a text file.
	 * @return id and name with new line character between the two fields
	 */
	@Override
	public String toString() {
		return  id + "\n" + name;
	}

	/**
	 * This method computes and returns the pay for one month. If the
	 * employee is an HourlyEmp, their pay is payRate*hours.
	 * If the employee is a SalariedEmp, their pay is annualSalary/12.
	 * 
	 * @return the pay for one month
	 */
	public abstract double computeMonthlyPay();
	
	/**
	 * This method will increase the employee's salary. If the 
	 * employee is an HourlyEmp, amt is added to their payRate.
	 * If the employee is a SalariedEmp, amt is added to annualSalary.
	 * @param amt is the amount of the raise
	 */
	public abstract void raise(double amt);

	/**
	 * Check if this object is equal  to other
	 * @param other is the object we are checking for equality to this object
	 * @return true if other is the same type and has the same id value as 
	 *         this Employee, false otherwise.
	 *  
	 */
	@Override
	public boolean equals(Object other) {
		if (this.getClass()==other.getClass() && this.getId()== ((Employee)other).getId() )
		    return true;
		else
			return false;
	}
	
	
	
}
