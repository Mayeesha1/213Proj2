
/**
The employee class holds all the main attributes of an employee. 
(add more after i understand more LOL)...
@author mayeesha, rebecca
*/
public class Employee {
	//not sure what other instance variables to add for an employee
	private Profile profile; 
	
	public Employee(String name, String department, String date) {
		profile.setName(name);
		profile.setDepartment(department);
		Date datePublished = new Date(date);
		profile.setDate(datePublished);
	}
	
	/**
	This method calculates the payments for an employee, keeping 
	in mind the total hours they worked. (fix if im wrong later...)
	 */
	public void calculatePayment() {
		
	} 
	@Override
	public boolean equals(Object obj) {
		return true; //just for now to make the error go away
	}
	@Override 
	public String toString() { 
		return "hello"; //just for now to make the error go away
	} 
}
