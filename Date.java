import java.util.Calendar;
import java.util.StringTokenizer;

/**
The Date class stores the day, month, and year from user input in each 
identified variable and makes sure if a date is valid. 
@author mayeesha, rebecca
*/
public class Date implements Comparable<Date> {
	private int year;
	private int month; 
	private int day;
	
	/**
	This method compares a Date object with another Date object and returns 
	different numbers if it is less than, greater than, or equal too.
	@param date object
	*/
	@Override
	public int compareTo(Date date) { 
		return 0;
	}
	/**
	This method creates the Date object from what was scanned through 
	user input and puts them in their respective variables. The day, month,
	and year are separated using String tokenizer.
	@param date string scanned from user input
	*/
	public Date(String date) { //taking mm/dd/yyyy and create a Date object

	StringTokenizer dt = new StringTokenizer(date,"/");
	int mnth = 0;	
	int dy = 0; 
	int yr = 0;
	
	mnth = Integer.parseInt(dt.nextToken().trim());
	dy = Integer.parseInt(dt.nextToken().trim());
	yr = Integer.parseInt(dt.nextToken().trim());

	this.month = mnth;
	this.day = dy;
	this.year = yr; 
	} 
	
	/**
	This method creates the Date object for the current date using the
	Calendar class. It stores the current day, month, and year in their
	respective variables.
	*/
	public Date() {
		int currDay = 0;
		int currMonth = 0;
		int currYear = 0;
		this.day = currDay;
		this.month = currMonth;
		this.year = currYear; 
		
		Calendar todaysDate = Calendar.getInstance();
		currMonth = todaysDate.get(Calendar.MONTH);
		currMonth++; 
		currYear = todaysDate.get(Calendar.YEAR);
		currDay = todaysDate.get(Calendar.DAY_OF_MONTH);
	} 
	
	/**
	Getter method for day so it can be used in other classes
	@return day
	*/
	public int getDay() {
		return day;
	}
	
	/**
	Getter method for month so it can be used in other classes
	@return month
	*/
	public int getMonth() {
		return month;
	}
	
	/**
	Getter method for year so it can be used in other classes
	@return year
	*/
	public int getYear() {
		return year;
	}
	
	/**
	This method checks if the date published passed through input is valid 
	and meets certain requirements to be authentic to be stored in the Kiosk
	library
	@return boolean if date is valid
	*/
	public boolean isValid() {
		int MIN_YEAR=1900; 
		int JAN=1; 
		int FEB=2; 
		int MAR=3; 
		int APR=4; 
		int MAY=5; 
		int JUN=6; 
		int JUL=7; 
		int AUG=8; 
		int SEP=9; 
		int OCT=10; 
		int NOV=11; 
		int DEC=12; 
		int LOW_DAY=1; 
		int NO_LEAP=28; 
		int YES_LEAP=29; 
		int LOW_END=30; 
		int HIGH_END=31; 
		int FIRST_CHECK=4; 
		int SECOND_CHECK=100; 
		int THIRD_CHECK=400; 

		if(year < MIN_YEAR || year>Calendar.getInstance().get(Calendar.YEAR)
				|| (year==Calendar.getInstance().get(Calendar.YEAR) && month>Calendar.getInstance().get(Calendar.MONTH))
				|| (year==Calendar.getInstance().get(Calendar.YEAR) && month==Calendar.getInstance().get(Calendar.MONTH)
					&& day>Calendar.getInstance().get(Calendar.DAY_OF_MONTH))) {
				return false;
			}
			else if((month==JAN || month==MAR || month==MAY || month==JUL || month==AUG || month==OCT
				|| month==DEC) && day>HIGH_END) {
				return false;
			}
			else if((month==APR || month==JUN || month==SEP || month==NOV) && day>LOW_END) {
				return false;
			} else if(month > DEC || month < JAN || day < LOW_DAY) {
				return false;
			} else if(month==FEB) { //check leap year
				if(year%FIRST_CHECK==0) {
					if(year%SECOND_CHECK==0) {
						if(year%THIRD_CHECK==0) {
							if(day>YES_LEAP) {
								return false;
							}
						}
						else {
							if(day>NO_LEAP) {
								return false;
							}
						}
					}
					else {
						if(day>YES_LEAP) {
							return false;
						}
					}
				}
				else {
					if(day>NO_LEAP) {
						return false;
					}
				}
			}
			return true;
	}
	
}
