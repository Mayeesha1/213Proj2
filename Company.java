
/**
The company class stores all the employees in an array-based list. These employees can 
be added, removed, checked out, have payments processed, and printed in a list.
@author mayeesha, rebecca
*/
public class Company {
	private Employee[] emplist;
	private int numEmployee;
	
	/**
	Method used to help other methods find an employee in the employee list and 
	return the index of the employee in the employee list
	@param employee to find in the employee list
	@return index of employee in list, -1 if not found
	*/
	private int find(Employee employee) { 
		int count= 0;
		while(count<numEmployee) {
			if(emplist[count].equals(emplist)) {
				return count; //index in array not serial num
			}
			count++;
		}
		//return  count; //equals numEmployee
		return -1;
	}
	
	/**
	Helper method to grow the employee list capacity by 4 when the list is full
	*/
	private void grow() {
		int GROW_VAR = 4;
		Employee[] temp=new Employee[emplist.length+GROW_VAR];
		for(int i=0;i<numEmployee;i++) {
			temp[i]=emplist[i];
		}
		emplist=temp;
	} 
	
	/**
	Method to add an employee to the employee list. Also, we grow the list capacity 
	when it's full and only add the employee if their profile is valid. 
	@param employee to be added
	*/
	public boolean add(Employee employee) { 
		if(employee.getDatePublished().isValid()) {
			if(emplist.length==numEmployee) { //list full
				grow();
			} 
			if(numEmployee==0) {
				emplist[0] = employee; //all empty slots	
			}
			else {
				int ptr=emplist.length-1;
				while(emplist[ptr]==null) { //first empty slot
					ptr--;
				}
				emplist[ptr+1] = employee;
			}
			numEmployee++; //increase employee count
		} 
	} 
	
	/**
	The method to remove an employee from the employee list. The employee is found using 
	the find method and the list maintains the current sequence of employee's after the 
	removal. If the employee is not in the company, the method returns false.
	@param employee to be removed
	@return true if successfully removed, false if employee not in company
	*/
	public boolean remove(Employee employee) { 
		int index = find(employee);
		if(index>-1) {
			for(int i=index; i<emplist.length-1; i++) {
				emplist[i] = emplist[i+1];
			}
			if(numEmployee == emplist.length) { //put a null space
				emplist[emplist.length-1] = null; 
			}
			numEmployee--;
			return true;
		}
		return false;
	}
	
	/**
	Method to set a part time employees working hours.
	@param part time employee's hours to be set
	*/
	public boolean setHours(Employee employee) {
		
	} 
	
	/**
	Method to process the payments for the employees in the company. This method is 
	to ensure that the employees receive their proper payments by processing them. 
	*/
	public void processPayments() { } 
	
	/**
	Method to print the earning statements for all the employers in the company
	in the normal order from the employee list
	 */
	public void print() { } 
	
	/**
	Method to print the earning statements for all the employers in the company
	by the order of their Department from the employee list
	 */
	public void printByDepartment() { } 
	
	/**
	Method to print the earning statements for all the employers in the company
	by the order of date from the employee list
	 */
	public void printByDate() { } 
	
}
