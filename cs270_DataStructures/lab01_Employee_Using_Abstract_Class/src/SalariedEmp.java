
public class SalariedEmp extends Employee {
	
	private double annualSalary;

	/**
	 *
	 * 
	 * @param id
	 * @param name
	 * @param annualSalary
	 */
	public SalariedEmp(int id, String name, double annualSalary) {
		super(id, name);
		this.annualSalary = annualSalary;
	}

	/**
	 * This method computes and returns the pay for one month. If the
	 * employee is an HourlyEmp, their pay is payRate*hours.
	 * If the employee is a SalariedEmp, their pay is annualSalary/12.
	 */
	@Override
	public double computeMonthlyPay() {
		
		return annualSalary/12;
	}

	
	@Override
	/**
	 *  This method will increase the employee's salary. If the 
	 * employee is an HourlyEmp, amt is added to their payRate.
	 * If the employee is a SalariedEmp, amt is added to annualSalary.
	 * @param amt is the amount of the raise
	 */
	public void raise(double amt) {
		annualSalary= annualSalary+amt;

	}
	
	/**
	 * Return the fields in the format needed for reading (and writing) from a text file.
	 * @return id and name with new line character between the two fields
	 */
	public String toString(){
		
		return "SalariedEmp\n"+super.toString()+"\n"+String.format("%.2f", annualSalary);
	}

	/**
	 * @return the annualSalary
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}

	/**
	 * @param annualSalary the annualSalary to set
	 */
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	

}
