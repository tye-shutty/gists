import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Locale;

public class TimeObjectF1 extends TimeObject {
	/**
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void printTime() {
		Calendar curr = Calendar.getInstance();
		System.out.println(String.format("Date: %1$tm/%1$td/%1$ty\nTime: %1$tH:%1$tS:%1$tM",curr));
	}
}
