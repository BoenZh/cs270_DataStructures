
public class HourlyEmp extends Employee {
	
	private double payRate;
	private int hours;

	/**
	 * 
	 * @param id
	 * @param name
	 * @param payRate
	 * @param hours
	 */
	public HourlyEmp(int id, String name, double payRate, int hours) {
		super(id, name);
		this.payRate = payRate;
		this.hours = hours;
	}
	
	/**
	 * 
	 * @param h
	 */
	public void addHours(int h){
		hours=hours+h;
	}
	
	/**
	 * Return the fields in the format needed for reading (and writing) from a text file.
	 * @return id and name with new line character between the two fields
	 */
	public String toString(){
		
		
		return "HourlyEmp\n"+super.toString()+"\n"+String.format("%.2f", payRate)+"\n"+hours;
	}
	
	
	

	/**
	 * @return the payRate
	 */
	public double getPayRate() {
		return payRate;
	}

	/**
	 * @param payRate the payRate to set
	 */
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	/**
	 * This method computes and returns the pay for one month. If the
	 * employee is an HourlyEmp, their pay is payRate*hours.
	 * If the employee is a SalariedEmp, their pay is annualSalary/12.
	 */
	public double computeMonthlyPay() {
		
		return payRate * hours;
	}

	@Override
	/**
	 *  This method will increase the employee's salary. If the 
	 * employee is an HourlyEmp, amt is added to their payRate.
	 * If the employee is a SalariedEmp, amt is added to annualSalary.
	 * @param amt is the amount of the raise
	 */
	public void raise(double amt) {
		payRate=payRate + amt;

	}

}
