
/**
The fulltime class is an extension of the employee class with specific pay rates and
additional compensations.
@author mayeesha, rebecca
*/
public class Fulltime extends Employee {
	
	
	public Fulltime(String name, String department, Date date) {
		super(name, department, date);
		// TODO Auto-generated constructor stub
	}
	@Override 
	public void calculatePayment() { } 
	@Override
	public boolean equals(Object obj) {
		return true; //just for now to make the error go away
	}
	@Override 
	public String toString() { 
		return "hello"; //just for now to make the error go away
	} 
}
