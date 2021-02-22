import java.text.DecimalFormat;

/**
The management class is for all the management employee attributes. These employees
are also fulltime employees. They share the same attributes from the fulltime employees.
@author mayeesha, rebecca
*/

public class Management extends Fulltime {
	
	private String role;
	private double additionalComp;
	
	public Management(Profile profile, double annualSalary, String role) {
		super(profile, annualSalary);
		this.role=role;
		if(role.equals("1")) { //Manager
			additionalComp=192.31;
		}
		else if(role.equals("2")) { //Department Head
			additionalComp=365.38;
		}
		else { //Director
			additionalComp=461.54;
		}
	}
	
	public void setRole(String role) {
		this.role=role;
	}
	
	@Override 
	public void calculatePayment() { 
		super.calculatePayment();
		double payment = getPayment();
		payment = payment+additionalComp;
	} 
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Management) {
			Management management=(Management) obj;
			return management.getProfile().equals(this.getProfile());
		}
		return false;
	}
	
	@Override 
	public String toString() { 
		String pattern="###,000.00";
		DecimalFormat df=new DecimalFormat(pattern);
		return super.toString() + "::" + role + " Compensation $" 
				+ df.format(additionalComp); 
	} 
}