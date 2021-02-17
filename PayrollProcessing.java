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
	private Company company; 
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
		company = new Company();
		try {
		while(!line.equals("Q")) {
			StringTokenizer st=new StringTokenizer(line," ",false);
			String command=st.nextToken(); 
		
			if(command.equals("AP")) { //part-time employee w hourly pay rate
			String name = st.nextToken();
			String depCode = st.nextToken();
			String date = st.nextToken();
			String moneyEarned = st.nextToken();
			System.out.println("name of employee is: " + name); //these are to test for now
			System.out.println("depCode of employee is: " + depCode);
			System.out.println("date joined of employee is: " + date);
			System.out.println("earnings of employee is: " + moneyEarned);
			if((depCode.equals("CS")) || (depCode.equals("ECE")) || (depCode.equals("IT"))) {
			    //call add method here and also check if employee already exists or not
			} else {
				System.out.println("invalid department code");
			}
			
			} else if(command.equals("AF")) { //full-time employee w annual salary
				
			} else if(command.equals("AM")) { //full-time employee w diff roles
				
			} else if(command.equals("R")) {
				
			} else if(command.equals("C")) {
				
			} else if(command.equals("S")) {
				
			} else if(command.equals("PA")) { //earnings for all employees
				
			} else if(command.equals("PH")) { //earnings by date hired
				
			} else if(command.equals("PD")) { //earnings grouped by department
				
			} else {
				System.out.println("Invalid command!");
			}
			line = scanner.nextLine();	
		 }
		System.out.println("Payroll Processing completed."); //quit

		}
		 catch (Exception e) {
			   System.out.println("Invalid input.");
			 }
		
		scanner.close();
	} 
}
