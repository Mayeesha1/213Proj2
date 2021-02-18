
/**
The management class is for all the management employee attributes. These employees
are also fulltime employees. They share the same attributes from the fulltime employees.
@author mayeesha, rebecca
*/
public class Management extends Fulltime {
	
	@Override 
	public void calculatePayment() { } 
	@Override
	public boolean equals(Object obj) {
		return true; //just for now to make the error go away
	}
	@Override 
	public String toString() { 
		return "hello"; //just for now to make the error go away
	} 
}
