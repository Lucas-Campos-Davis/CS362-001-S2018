
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.LinkedList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    DataHandler dataHandler0 = new DataHandler();
      //get todays date
      Calendar rightnow = Calendar.getInstance();
      //current month/year/date is today
      /** the month the user is currently viewing **/
      int thisMonth = rightnow.get(Calendar.MONTH);
      /** todays date **/
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      /** the year the user is currently viewing **/
      int thisYear = rightnow.get(Calendar.YEAR);

//		// Get a calendar which is set to a specified date.
      Calendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
      // Increment the calendar's date by 1 day.
      calendar.add(calendar.DAY_OF_MONTH,1);







      int startHour=15;
      int startMinute=30;
      int startDay=thisDay;
      int startMonth=thisMonth+1;
      int startYear=thisYear;
      String title="Birthday Party";
      String description="This is my birthday party.";
      String emailAddress="aburasa@oregonstate.edu";

      //Construct a new Appointment object with the initial data
      Appt appt1 = new Appt(startHour,
              startMinute ,
              startDay ,
              startMonth ,
              startYear ,
              title,
              description,
              emailAddress);

     // System.out.println(appt1.toString());

      assertTrue(dataHandler0.saveAppt(appt1));

      // create another appointment
      startHour=14;
      startMinute=30;
      startDay=thisDay;
      startMonth=thisMonth+1;
      startYear=thisYear;
      title="Class";
      description="Rescheduled class.";
      //Construct a new Appointment object with the initial data
      Appt appt2 = new Appt(startHour,
              startMinute ,
              startDay ,
              startMonth ,
              startYear ,
              title,
              description,
              emailAddress);

      //System.out.println(appt2.toString());

      assertTrue(dataHandler0.saveAppt(appt2));

      // create another appointment
      startHour=16;
      startMinute=30;
      startDay=calendar.get(Calendar.DAY_OF_MONTH);
      startMonth=calendar.get(Calendar.MONTH)+1;
      startYear=thisYear;
      title="Visit";
      description="Visiting my parents!";
      //Construct a new Appointment object with the initial data
      Appt appt3 = new Appt(startHour,
              startMinute ,
              startDay ,
              startMonth ,
              startYear ,
              title,
              description,
              emailAddress);
      int[] recurDaysArr={2,3,4};
      appt3.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

      appt3.setValid();

     // System.out.println(appt3.toString());


      assertTrue(dataHandler0.saveAppt(appt3));


      // create another appointment
      startHour=16;
      startMinute=30;
      startDay=-1;
      startMonth=thisMonth+2;
      startYear=thisYear;
      title="Visit";
      description="Visiting my parents!";
      //Construct a new Appointment object with the initial data
      Appt appt4 = new Appt(startHour,
              startMinute ,
              startDay ,
              startMonth ,
              startYear ,
              title,
              description,
              emailAddress);
      int[] recurDaysArr4={2,3,4};
      appt4.setRecurrence( recurDaysArr4, Appt.RECUR_BY_WEEKLY, 3, Appt.RECUR_NUMBER_FOREVER);

      appt4.setValid();

     // System.out.println(appt4.toString());


      assertFalse(dataHandler0.saveAppt(appt4));


      //get a list of appointments for one day, which is today
      GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
      GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);

      tomorrow.add(today.DAY_OF_MONTH,1);


      DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");

      //			System.out.println("today is:" + dateFormat.format(today.getTime()));
      //			System.out.println("tomorrow is:" + dateFormat.format(tomorrow.getTime()));

      //Create a linked list of calendar days to return
      LinkedList<CalDay> calDays = new LinkedList<CalDay>();

      calDays = (LinkedList<CalDay>) dataHandler0.getApptRange(today,tomorrow);

      assertTrue(dataHandler0.deleteAppt(appt2));

      assertTrue(dataHandler0.save());

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      //get todays date
      Calendar rightnow = Calendar.getInstance();
      //current month/year/date is today
      /** the month the user is currently viewing **/
      int thisMonth = rightnow.get(Calendar.MONTH);
      /** todays date **/
      int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      /** the year the user is currently viewing **/
      int thisYear = rightnow.get(Calendar.YEAR);

      DataHandler dataHandler0 = new DataHandler(System.getProperty("user.dir") + System.getProperty("file.separator") +"calendar.xml",false);
      GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
      GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);

      tomorrow.add(today.DAY_OF_MONTH,1);


      DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");

      //			System.out.println("today is:" + dateFormat.format(today.getTime()));
      //			System.out.println("tomorrow is:" + dateFormat.format(tomorrow.getTime()));

      //Create a linked list of calendar days to return
      LinkedList<CalDay> calDays = new LinkedList<CalDay>();

      int startHour=15;
      int startMinute=30;
      int startDay=thisDay;
      int startMonth=thisMonth+1;
      int startYear=thisYear;
      String title="Birthday Party";
      String description="This is my birthday party.";
      String emailAddress="aburasa@oregonstate.edu";

      //Construct a new Appointment object with the initial data
      Appt appt1 = new Appt(startHour,
              startMinute ,
              startDay ,
              startMonth ,
              startYear ,
              title,
              description,
              emailAddress);

      // System.out.println(appt1.toString());

      assertTrue(dataHandler0.saveAppt(appt1));

      calDays = (LinkedList<CalDay>) dataHandler0.getApptRange(today,tomorrow);
      //assertEquals(null,dataHandler0.getApptRange(today,tomorrow));
      assertTrue(dataHandler0.save());
     // assertFalse(dataHandler0.saveAppt(null));

  }

}
