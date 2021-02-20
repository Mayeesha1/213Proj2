import Proj1.Book;

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
		if(employee.getDateHired().isValid()) {
			if(emplist.length==numEmployee) { //list full
				grow();
			} 
			if(numEmployee==0) {
				emplist[0] = employee; //all empty slots	
				return true;
			}
			else {
				int ptr=emplist.length-1;
				while(emplist[ptr]==null) { //first empty slot
					ptr--;
				}
				emplist[ptr+1] = employee;
				
			}
			numEmployee++; //increase employee count
			return true;
		}
		return false;
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
		return true; //just for now 
	} 
	
	/**
	Method to process the payments for the employees in the company. This method is 
	to ensure that the employees receive their proper payments by processing them.
	(better description?) 
	*/
	public void processPayments() { } 
	
	/**
	Method to print the earning statements for all the employers in the company
	in the normal order from the employee list
	 */
	public void print() {
		if(numEmployee>0) {
			System.out.println("--Printing earning statements for all employees--");
			for(int i=0;i<numEmployee;i++) {
				System.out.println(emplist[i].toString());
			}
		}
		else {
			System.out.println("Employee database is empty.");
		}
	} 
	
	/**
	Method to print the earning statements for all the employers in the company
	by the order of their Department from the employee list
	 */
	public void printByDepartment() { } 
	
	/**
	Method to print the earning statements for all the employers in the company
	by the order of date from the employee list
	 */
	public void printByDate() { 
		if(numEmployee>0) {
			System.out.println("--Printing earning statements by date hired--");
			
			mergeSortDate(emplist,0,numEmployee-1);
			for(int i=0;i<numEmployee;i++) {
				System.out.println(emplist[i].toString());
			}
		}
		else {
			System.out.println("Employee database is empty.");
		}
	} 
	
	/**
	Helper method to merge sort the employees in order of dates hired
	@param employee array
	@param left index
	@param right index
	*/
	public static void mergeSortDate(Employee[] emplist, int left, int right) { 
		if(right<=left) return;
		int mid=(left+right)/2; //left, right, mid are indexes
		mergeSortDate(emplist,left,mid);
		mergeSortDate(emplist,mid+1,right);
		mergeDate(emplist,left,mid,right);
	}
	
	/**
	Helper method to merge two arrays together so it can be sorted in order of dates published
	@param books array
	@param left index
	@param mid index
	@param right index
	*/
	public static void mergeDate(Employee[] emplist, int left, int mid, int right) {
		Employee[] leftEmployee=new Employee[mid-left+1];
		Employee[] rightEmployee=new Employee[right-mid];
		for(int i=0;i<mid-left+1;i++) {
			leftEmployee[i]=emplist[left+i];
		}
		for(int j=0;j<right-mid;j++) {
			rightEmployee[j]=emplist[mid+j+1];
		}
		int leftIndex=0;
		int rightIndex=0;
		for(int k=left;k<right+1;k++) {
			if(leftIndex<mid-left+1 && rightIndex<right-mid) { //setter, getter constructors for book
				if((leftEmployee[leftIndex].getDateHired().getYear()
								<rightEmployee[rightIndex].getDateHired().getYear())
						|| (leftEmployee[leftIndex].getDateHired().getYear()
								==rightEmployee[rightIndex].getDateHired().getYear() 
							&& leftEmployee[leftIndex].getDateHired().getMonth()
								<rightEmployee[rightIndex].getDateHired().getMonth())
						|| (leftEmployee[leftIndex].getDateHired().getYear()
								==rightEmployee[rightIndex].getDateHired().getYear() 
							&& leftEmployee[leftIndex].getDateHired().getMonth()
								==rightEmployee[rightIndex].getDateHired().getMonth() 
							&& leftEmployee[leftIndex].getDateHired().getDay()
								<rightEmployee[rightIndex].getDateHired().getDay())) {
					emplist[k]=leftEmployee[leftIndex];
					leftIndex++;
				}
				else {
					emplist[k]=rightEmployee[rightIndex];
					rightIndex++;
				}
			}
			else if(leftIndex<mid-left+1) {
				emplist[k]=leftEmployee[leftIndex];
				leftIndex++;
			}
			else if(rightIndex<right-mid) {
				emplist[k]=rightEmployee[rightIndex];
				rightIndex++;
			}
		}
	}
	
}
