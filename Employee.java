
/**
The employee class holds all the main attributes of an employee. The employee object is created
and each employee has their own profile.
(add more after i understand more LOL)...
@author mayeesha, rebecca
*/
public class Employee {
	//not sure what other instance variables to add for an employee
	private Profile profile; 

	/**
	This constructor uses the name of an employee, the department, and the date published 
	to connect the information to the Profile class where all three attributes are held 
	for each employee.
	@param name of employee, department code, date hired
	@param date published
	*/
	public Employee(Profile profile) {
	this.profile = profile;
	}
	
	public Profile getProfile() { //**idk but did this in book for date ig
		return profile;
	}
	
	public void calculatePayment() { 
	//...
	}
	public String getdepCode() { //**idk but did this in book for date ig
		return profile.getDepartment();
	}
	
	
	/**
	This method gets the Date hired from the Profile class so it 
	can be used in other classes.
	 */
	public Date getDate() { //REDUNDANT(also in profile class)!! lmk if you know a better way to do it
		return profile.getDateHired();
	}
	
	/**
	This method checks if employees are equal and already in the database(?)
	@param obj of type employee to check with another employee object
	@return true if employees are equal, false if not
	*/
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee employee=(Employee) obj;
			return employee.profile.equals(this.profile);
		}
		return false;
	}
	/**
	The method creates a string description of an employee and thier profile (serial
	number, name, date published, and checked out status).
	@return string description
	*/
	@Override  
	public String toString() { 
		return profile.toString();
	} 
}
