import java.util.Scanner;
import java.util.StringTokenizer;

/**
The payrollprocessing class is used to run all the commands in the company. Based on 
the inputted commands, the payrollprocessing class uses the company methods as needed 
to add, remove, calculate payments, set working hours, and print earning statements 
from the employee list. This class also handles exceptions through the user input.
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
		while(!line.equals("Q")) {
			StringTokenizer st=new StringTokenizer(line,",",false);
			String command=st.nextToken(); 
			if(command.equals("AP")) {
				
			} else if(command.equals("AF")) {
				
			} else if(command.equals("AM")) {
				
			} else if(command.equals("R")) {
				
			} else if(command.equals("C")) {
				
			} else if(command.equals("S")) {
				
			} else if(command.equals("PA")) {
				
			} else if(command.equals("PH")) {
				
			} else if(command.equals("PD")) {
				
			} else {
				System.out.println("Invalid command!");
			}
			line = scanner.nextLine();	
		}
		System.out.println("Payroll Processing completed."); //quit
		
		scanner.close();
	} 
}
