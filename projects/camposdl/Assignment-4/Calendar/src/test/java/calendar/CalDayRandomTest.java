package calendar;


import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {


    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try{

             Calendar rightnow = Calendar.getInstance();

             int thisMonth = rightnow.get(Calendar.MONTH);

             int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

             int thisYear = rightnow.get(Calendar.YEAR);
             //		// Get a calendar which is set to a specified date.
             GregorianCalendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
             CalDay calDay1 = new CalDay(calendar);

			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);


				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

                 int startHourT=ValuesGenerator.getRandomIntBetween(random, -50, 73);
                 int startMinuteT=ValuesGenerator.getRandomIntBetween(random, -60, 119);
                 int startDayT=ValuesGenerator.getRandomIntBetween(random, -31, 61);
                 int startMonthT=ValuesGenerator.getRandomIntBetween(random, -12, 24);
                 int startYearT=ValuesGenerator.getRandomIntBetween(random, -50, 50);
                 Appt appt = new Appt(startHourT,
                         startMinuteT ,
                         startDayT ,
                         startMonthT ,
                         startYearT ,
                         title,
                         description,
                         emailAddress);
                 appt.setValid();

				// if(!appt.getValid())continue;


                 calDay1.addAppt(appt);


				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");

	 }


	
}
