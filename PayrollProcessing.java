import java.util.Scanner;
import java.util.StringTokenizer;

/**
The PayrollProcessing class is used to run all the commands in the company. Based on 
the input commands, the PayrollProcessing class uses the company methods as needed 
to add, remove, calculate payments, set working hours, and print earning statements 
from the employee list. This class also handles exceptions from the user input.
@author mayeesha, rebecca
*/
public class PayrollProcessing {
	
	//..
	//private Company company; 
	/**
	Method to run the Company so that the company can add, 
	remove, calculate payments, set working hours, as well 
	as display earning statements from the list of employees 
	by order of date hired or the employees' department.
	 */
	
	public void run() {
		
		System.out.println("Payroll Processing starts.");
		Scanner scanner=new Scanner(System.in);
		String line=scanner.nextLine();
		Company company = new Company();
		//try {
		while(!line.equals("Q")) {
			StringTokenizer st=new StringTokenizer(line," ",false);
			String command=st.nextToken(); 
			if(command.equals("AP")) { //part-time employee w hourly pay rate
			String NAME = st.nextToken();
			String DEP_CODE = st.nextToken();
			String DATE = st.nextToken();
			String PER_HOUR = st.nextToken();
			double HOURLY_RATE = Double.parseDouble(PER_HOUR);
			Profile profile = new Profile(NAME, DEP_CODE, DATE);
			Employee employee = new Employee(profile);
			Parttime parttime = new Parttime(profile, HOURLY_RATE);
			if(!(DEP_CODE.equals("CS") || DEP_CODE.equals("ECE") || DEP_CODE.equals("IT"))) {
				System.out.println("'" + DEP_CODE + "'" + " is not a valid department code.");
			}
			else if(!parttime.getProfile().getDateHired().isValid()) {
				System.out.println(DATE + " is not a valid date!");
			}
			else if(company.add(parttime)) {
					System.out.println("Employee added.");
				} else {
					System.out.println("Employee already in the list.");
				}
			 		
			
			} else if(command.equals("AF")) { //full-time employee w annual salary
				String NAME = st.nextToken();
				String DEP_CODE = st.nextToken();
				String DATE = st.nextToken();
				String PER_YEAR = st.nextToken();
				double ANNUAL_SALARY = Double.parseDouble(PER_YEAR);
				Profile profile = new Profile(NAME, DEP_CODE, DATE);
				Employee employee = new Employee(profile);
				Fulltime fulltime = new Fulltime(profile, ANNUAL_SALARY);
				if(!(DEP_CODE.equals("CS") || DEP_CODE.equals("ECE") || DEP_CODE.equals("IT"))) {
					System.out.println("'" + DEP_CODE + "'" + " is not a valid department code.");
				}
				else if(!fulltime.getProfile().getDateHired().isValid()) {
					System.out.println(DATE + " is not a valid date!");
				}
				else {
					if(company.add(fulltime)) {
						System.out.println("Employee added.");
					}
					else {
						System.out.println("Employee already in the list.");
					}
				} 

			} else if(command.equals("AM")) { //full-time employee w diff roles
				String NAME = st.nextToken();
				String DEP_CODE = st.nextToken();
				String DATE = st.nextToken();
				String PER_YEAR = st.nextToken();
				double ANNUAL_SALARY = Double.parseDouble(PER_YEAR);
				String ROLE = st.nextToken();
				int INT_CODE = Integer.parseInt(ROLE);
				Profile profile = new Profile(NAME, DEP_CODE, DATE);
				Employee employee = new Employee(profile);
				Management management = new Management(profile, ANNUAL_SALARY, ROLE);
				int MANAGER_CODE=1;
				int DEPARTMENT_HEAD_CODE=2;
				int DIRECTOR_CODE=3;
				if(INT_CODE==MANAGER_CODE) {
					management.setRole("Manager");
				}
				else if(INT_CODE==DEPARTMENT_HEAD_CODE) {
					management.setRole("Department Head");
				}
				else if(INT_CODE==DIRECTOR_CODE) {
					management.setRole("Director");
				}
				else {
					System.out.println("Invalid management code.");
				}
				if(!(DEP_CODE.equals("CS") || DEP_CODE.equals("ECE") || DEP_CODE.equals("IT"))) {
					System.out.println("'" + DEP_CODE + "'" + " is not a valid department code.");
				}
				else if(!management.getProfile().getDateHired().isValid()) { 
					System.out.println(DATE + " is not a valid date!");
				}
				else if(company.add(management) && ((INT_CODE == 1) || (INT_CODE == 2) || (INT_CODE == 3))) {
						System.out.println("ur boolean value is: " + company.add(management));
						System.out.println("Employee added.");
				}  
					if(/*!company.add(management) &&*/ ((INT_CODE == 1) || (INT_CODE == 2) || (INT_CODE == 3))){
						System.out.println("Employee already in the list." + company.add(management));
					}
				 			
			} else if(command.equals("R")) { //remove employee
				String NAME = st.nextToken();
				String DEP_CODE = st.nextToken();
				String DATE = st.nextToken();
				Profile profile = new Profile(NAME, DEP_CODE, DATE);
				Employee employee = new Employee(profile);
				if(company.remove(employee)) {
					System.out.println("Employee removed.");
				} else {
					System.out.println("Employee database is empty.");
				}
				
			} else if(command.equals("C")) { //calculate payments
				company.processPayments();
				
			} else if(command.equals("S")) { //set hours for employee
				String NAME=st.nextToken();
				String DEP_CODE=st.nextToken();
				String DATE=st.nextToken();
				double HOURS = Double.parseDouble(st.nextToken());
				Profile profile = new Profile(NAME, DEP_CODE, DATE);
				Employee employee = new Employee(profile);
				if(HOURS<0) {
					System.out.println("Working hours cannot be negative.");
				}
				else if(HOURS>100) {
					System.out.println("Invalid Hours: over 100.");
				}
				else {
					if(company.setHours(employee)) {
						System.out.println("Working hours set.");
					}
				}
				
			} else if(command.equals("PA")) { //earnings for all employees
				company.print();
			} else if(command.equals("PH")) { //earnings by date hired
				company.printByDate();
				
			} else if(command.equals("PD")) { //earnings grouped by department
				company.printByDepartment();
				
			} else {
				System.out.println("Command '" + command + "' is not supported!");
			}
			line = scanner.nextLine();	
		 }
		System.out.println("Payroll Processing completed."); //quit
		scanner.close();
		//} catch (Exception e) {
			//  System.out.println("Exception error! Please recheck input!");
		//}
		
		
	}
}

