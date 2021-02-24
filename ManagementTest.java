import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

public class ManagementTest {

	@Test
	public void testCalculatePayment() {
	
		DecimalFormat decimal = new DecimalFormat("#,###.##");
		
		double annsal = 85000;
		String role = "Manager"; //we did the role setting in payroll processing through the number 1/2/3 and
							     //then did an if loop to see if role == 1 then setRole("Manager") thats why im 
								 //testing with "Manager" and not "1" 
		Profile profile = new Profile("Squarepants, Spongebob", "CS", "07/14/1986");
		Management mgmt = new Management(profile, annsal, role);
		mgmt.setRole(role);
		mgmt.calculatePayment();
		assertEquals(decimal.format(mgmt.getPayment()), decimal.format(3461.54)); // test case #1, setting hours
																	// for management employee with manager role
		
		double annsal2 = 75500;
		String role2 = "Department Head";
		Profile profile2 = new Profile("Explorer, Dora", "IT", "10/14/1999");
		Management mgmt2 = new Management(profile2, annsal2, role2);
		mgmt2.setRole(role2);
		mgmt2.calculatePayment();
		assertEquals(decimal.format(mgmt2.getPayment()), decimal.format(3269.23));// test case #2, setting hours
															// for management employee with department head role
		
		double annsal3 = 96756;
		String role3 = "Director";
		Profile profile3 = new Profile("Swiping, Swiper", "ECE", "07/14/1986");
		Management mgmt3 = new Management(profile3, annsal3, role3);
		mgmt3.setRole(role3);
		mgmt3.calculatePayment();
		assertEquals(decimal.format(mgmt3.getPayment()), decimal.format(4182.92));// test case #3, setting hours
																   // for management employee with director role
		double annsal4 = 85000;
		Profile profile4 = new Profile("Mister, Krabs", "ECE", "05/29/2003");
		Fulltime ftime = new Fulltime(profile4, annsal4);
		ftime.calculatePayment();
		assertEquals(decimal.format(ftime.getPayment()), decimal.format(3269.23));// test case #4, setting hours
																   				        // for fulltime employee
		
		double hourlyPay = 39;
		Profile profile5 = new Profile("Hooks, Sandy", "ECE", "12/02/2006");
		Parttime ptime = new Parttime(profile5, hourlyPay);
		ptime.calculatePayment();
		assertEquals(decimal.format(ptime.getPayment()), decimal.format(0000.00));// test case #5, setting hours
														            // for parttime employee with 0 hours worked
		
		double hourlyPay2 = 39;
		double hours = 100;
		Profile profile6 = new Profile("Explorer", "Dora", "08/10/2012");
		Parttime ptime2 = new Parttime(profile6, hourlyPay2);
		ptime2.setHours(hours);
		ptime2.calculatePayment();
		assertEquals(decimal.format(ptime2.getPayment()), decimal.format(4290.00));// test case #5, setting hours
														           // for parttime employee with 100 hours worked
	}

}
