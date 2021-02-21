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
			company.add(parttime);
			
			} else if(command.equals("AF")) { //full-time employee w annual salary
				String NAME = st.nextToken();
				String DEP_CODE = st.nextToken();
				String DATE = st.nextToken();
				String PER_YEAR = st.nextToken();
				double ANNUAL_SALARY = Double.parseDouble(PER_YEAR);
				Profile profile = new Profile(NAME, DEP_CODE, DATE);
				Employee employee = new Employee(profile);
				Fulltime fulltime = new Fulltime(profile, ANNUAL_SALARY);
				company.add(fulltime);

			} else if(command.equals("AM")) { //full-time employee w diff roles
				String NAME = st.nextToken();
				String DEP_CODE = st.nextToken();
				String DATE = st.nextToken();
				String PER_YEAR = st.nextToken();
				double ANNUAL_SALARY = Double.parseDouble(PER_YEAR);
				String ROLE = st.nextToken();
				Profile profile = new Profile(NAME, DEP_CODE, DATE);
				Employee employee = new Employee(profile);
				Management management = new Management(profile, ANNUAL_SALARY, ROLE);
				if((DEP_CODE.equals("CS")) || (DEP_CODE.equals("ECE")) || (DEP_CODE.equals("IT"))) {
				company.add(management); 
				} else { 
					System.out.println("'" + DEP_CODE + "' is not a valid department code.");
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
				
			} else if(command.equals("S")) { //set hours for employee
				
			} else if(command.equals("PA")) { //earnings for all employees
				company.print();
			} else if(command.equals("PH")) { //earnings by date hired
				
			} else if(command.equals("PD")) { //earnings grouped by department
				
			} else {
				System.out.println("Command '" + command + "' is not supported!");
			}
			line = scanner.nextLine();	
		 }
		System.out.println("Payroll Processing completed."); //quit
		scanner.close();
		//} catch (Exception e) {
			//  System.out.println("Exception error! Please recheck input!");
		//	}
		
		
	}
}

