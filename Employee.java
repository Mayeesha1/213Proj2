import Proj1.Book;

/**
The employee class holds all the main attributes of an employee. 
(add more after i understand more LOL)...
@author mayeesha, rebecca
*/
public class Employee {
	//not sure what other instance variables to add for an employee
	private Profile profile; 

	
	public Employee(String name, String department, Date date) {
		profile.setName(name);
		profile.setDepartment(department);
		profile.setDate(date);
	}
	
	public Date getDateHired() { //REDUNDANT(also in profile class)!! lmk if you know a better way to do it
		return profile.getDateHired();
	}
	
	/**
	This method calculates the payments for an employee, keeping 
	in mind the total hours they worked. (fix if im wrong later...)
	 */
	public void calculatePayment() {
		
	} 
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee employee=(Employee) obj;
			//return employee.?.equals(this.?); //not sure what to return yet?
		}
		return false;
	}
	@Override 
	public String toString() { 
		return "hello"; //just for now to make the error go away so i can test
	} 
}
