import static org.junit.Assert.*;

import org.junit.Test;

public class CompanyTest {

	@Test
	public void testAdd() {
		Company comp = new Company();
		
		String name = "Masud, Mayeesha";
		String department = "CS";
		String date = "06/16/2000";
		double annsal = 80000;
		Profile profile = new Profile(name, department, date);
		Fulltime ftime = new Fulltime(profile, annsal);
		assertTrue(comp.add(ftime)); //test case #1, adding a new fulltime employee
		assertFalse(comp.add(ftime)); //test case #2, adding an existing employee
		String name2 = "Kim, Rebecca";
		String department2 = "CS";
		String date2 = "09/24/2001";
		double annsal2 = 90000;
		String role = "2";
		Profile profile2 = new Profile(name2, department2, date2);
		Management management = new Management(profile2, annsal2, role);
		assertTrue(comp.add(management)); //test case #3, adding a new management employee
		String name3 = "Kim, Seungmin";
		String department3 = "ECE";
		String date3 = "09/22/2000";
		double hourlyRate = 85000;
		Profile profile3 = new Profile(name3, department3, date3);
		Parttime ptime = new Parttime(profile3, hourlyRate);
		assertTrue(comp.add(ptime)); // test case #4, adding a new parttime employee
		//fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		Company comp = new Company();
		
		String name = "Doe, John";
		String department = "IT";
		String date = "04/05/2010";
		double hourlyPay = 80000;
		Profile profile = new Profile(name, department, date);
		Parttime ptime = new Parttime(profile, hourlyPay);
		assertFalse(comp.remove(ptime));
		//fail("Not yet implemented");
	}

	/*@Test
	public void testSetHours() {
		fail("Not yet implemented");
	}*/

}
