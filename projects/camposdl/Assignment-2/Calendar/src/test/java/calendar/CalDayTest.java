/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
     CalDay calDay0 = new CalDay();
     calDay0.iterator();
     Calendar rightnow = Calendar.getInstance();
     int thisMonth = rightnow.get(Calendar.MONTH);
     int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
     int thisYear = rightnow.get(Calendar.YEAR);
     GregorianCalendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
     CalDay calDay1 = new CalDay(calendar);

     Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     Appt appt1 = new Appt(16, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     Appt appt2 = new Appt(10, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     Appt appt3 = new Appt(0, 3, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     calDay1.addAppt(appt0);
     calDay1.addAppt(appt1);
     calDay1.addAppt(appt2);
     calDay1.addAppt(appt3);

     String string0 = calDay1.toString();
     String string1 = calDay1.getFullInfomrationApp(calDay1);

     calDay1.getSizeAppts();

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

  }

}
