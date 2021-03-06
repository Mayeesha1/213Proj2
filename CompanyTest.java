import static org.junit.Assert.*;

import org.junit.Test;

public class CompanyTest {

	@Test
	public void testAdd() {
		Company comp = new Company();
		
		Profile profile = new Profile("Masud, Mayeesha", "CS", "06/16/2000");
		double fannsal = 80000;
		Fulltime ftime = new Fulltime(profile, fannsal);
		assertTrue(comp.add(ftime)); //test case #1, adding a fulltime employee
		
		assertFalse(comp.add(ftime)); //test case #2, adding an existing employee
		
		double annsal = 90000;
		String role = "1";
		Profile profile2 = new Profile("Kim, Rebecca", "CS", "09/24/2001");
		Management management = new Management(profile2, annsal, role);
		assertTrue(comp.add(management)); //test case #3, adding a management employee with manager role
		
		double annsal2 = 150000;
		String role2 = "2";
		Profile profile3 = new Profile("Waldorf, Blair", "IT", "11/22/2019");
		Management management2 = new Management(profile3, annsal2, role2);
		assertTrue(comp.add(management2)); //test case #4, adding a management employee with department head role
		
		double annsal3 = 150000;
		String role3 = "3";
		Profile profile4 = new Profile("Hwang, Hyunjin", "ECE", "03/20/2000");
		Management management3 = new Management(profile4, annsal3, role3);
		assertTrue(comp.add(management3)); //test case #5, adding a management employee with director role
		
		Profile profile5 = new Profile("Kim, Seungmin", "ECE", "09/22/2000");
		int hourlyPay = 85;
		Parttime ptime = new Parttime(profile5, hourlyPay);
		assertTrue(comp.add(ptime)); //test case #6, adding a parttime employee
	}

	@Test
	public void testRemove() {
		Company comp = new Company();
		
		double hourlyPay = 30.75;
		Profile profile = new Profile("Kim, Jongdae", "IT", "04/05/2010");
		Parttime ptime = new Parttime(profile, hourlyPay);
		assertFalse(comp.remove(ptime)); //test case #1, removing an employee that does not exist
		
		assertTrue(comp.add(ptime)); 
		assertTrue(comp.remove(ptime)); //test case #2, removing a parttime employee
		
		Profile profile2 = new Profile("Lee, Minho", "CS", "01/19/1998");
		double fannsal = 70000;
		Fulltime ftime = new Fulltime(profile2, fannsal);
		assertTrue(comp.add(ftime));  //adding fulltime employee to be removed
		
		double annsal = 96010;
		String role = "1";
		Profile profile3 = new Profile("Salvatore, Damon", "ECE", "01/19/1955");
		Management mgment = new Management(profile3, annsal, role);
		assertTrue(comp.add(mgment)); //adding management employee to be removed with manager role
		
		double annsal2 = 50200;
		String role2 = "2";
		Profile profile4 = new Profile("Star, Patrick", "IT", "03/17/1984");
		Management mgment2 = new Management(profile4, annsal2, role2);
		assertTrue(comp.add(mgment2)); //adding management employee to be removed with department head role
		
		double annsal3 = 100515;
		String role3 = "3";
		Profile profile5 = new Profile("Tentacles, Squidward", "CS", "10/09/1972");
		Management mgment3 = new Management(profile5, annsal3, role3);
		assertTrue(comp.add(mgment3)); //adding management employee to be removed with director role
		
		assertTrue(comp.remove(ftime)); //test case #3, removing a fulltime employee
		assertTrue(comp.remove(mgment)); //test case #4, removing a management employee with manager role
		assertTrue(comp.remove(mgment2)); //test case #4, removing a management employee with dep head role
		assertTrue(comp.remove(mgment3)); //test case #4, removing a management employee with director role

	}

	@Test
	public void testSetHours() {
		
		Company comp = new Company();
		double hours = 55;
		Profile profile = new Profile("Byun, Baekhyun", "ECE", "02/11/2006");
		Parttime ptime = new Parttime(profile, 25);
		assertFalse(comp.setHours(ptime)); //test case #1, setting hours for an employee that does not exist
		
		ptime.setHours(hours);
		assertTrue(comp.add(ptime)); //test case #2, setting hours for an employee that exists
	}

}
