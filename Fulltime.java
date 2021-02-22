
import java.text.DecimalFormat;

/**
The fulltime class is an extension of the employee class with specific pay rates and
additional compensations.
@author mayeesha, rebecca
*/
	public class Fulltime extends Employee {
		
		private double payment; //could do super.get methods instead idk
		private double annualSalary;
		
		public Fulltime(Profile profile, double annualSalary) {
			super(profile);
			payment=0;
			this.annualSalary=annualSalary;
		}
		/**
		Getter method for the payment of the employee so it can be used in other 
		classes
		@return payment
		*/
		public double getPayment() {
			return payment;
		}
		
		@Override 
		public void calculatePayment() { 
			double PAY_PERIODS=26;
			payment=payment+(annualSalary/PAY_PERIODS);
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Fulltime) {
				Fulltime fulltime=(Fulltime) obj;
				return fulltime.getProfile().equals(this.getProfile());
			}
			return false;
		}
		
		@Override 
		public String toString() { 
			String pattern="###,000.00";
			DecimalFormat df=new DecimalFormat(pattern);
			return super.toString() + "::Payment $" + df.format(payment) + "::FULL TIME::Annual Salary $" 
					+ df.format(annualSalary);
		} 
	}

