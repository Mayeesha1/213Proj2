
public class Profile {
	private String name;//employee's name in the form "lastname, firstname"
	private String department; //department code CS, ECE, IT
	private Date dateHired;
	//@Override
	//public String toString() { } //commented out for now to test
	@Override
	public boolean equals(Object obj) { 
		return true;
	}
	/**
	Setter method for the name of the employee so the value can be set 
	in other  classes
	@param employee name
	*/
	public void setName(String name) {
		this.name=name;
	}
	/**
	Setter method for the department code so that the value can be set
	in other classes
	@param department code
	*/
	public void setDepartment(String department) {
		this.department=department;
	}
	/**
	Setter method for the date an employee joined so the value can be set
	in other classes
	@param date when employee joined
	*/
	public void setDate(Date dateHired) {
		this.dateHired=dateHired;
	}
	/**
	Getter method for date hired of the employee so it can be used in other 
	classes
	@return date hired
	*/
	public Date getDateHired() {
		return dateHired;
	}
}
