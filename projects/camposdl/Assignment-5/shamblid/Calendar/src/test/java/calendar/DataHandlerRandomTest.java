package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;



    /**
     * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
     */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

        int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
    }
    /**
     * Return a randomly selected appointments to recur forever or Never recur  !.
     */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

        int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
    }




    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
     public void radnomtest()  throws Throwable  {
         DataHandler dataHandler1;
         dataHandler1 = new DataHandler();
         DataHandler dataHandler2;
         dataHandler2 = new DataHandler("calendar.xml", false);

         long startTime = Calendar.getInstance().getTimeInMillis();
         long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


         System.out.println("Start testing...");

         try{

            /** Calendar rightnow = Calendar.getInstance();

             int thisMonth = rightnow.get(Calendar.MONTH);

             int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

             int thisYear = rightnow.get(Calendar.YEAR);
             //		// Get a calendar which is set to a specified date.
             GregorianCalendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
             CalDay calDay1 = new CalDay(calendar);*/

             for (int iteration = 0; elapsed < TestTimeout/2; iteration++) {
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

                 int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
                 int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
                 int recur=ApptRandomTest.RandomSelectRecur(random);
                 int recurIncrement = ValuesGenerator.RandInt(random);
                 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
                 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

                 // if(!appt.getValid())continue;


                // calDay1.addAppt(appt);

                 int thing = ValuesGenerator.getRandomIntBetween(random, 0, 8);

                 if(thing%2 == 0){
                     appt.setXmlElement(null);
                 }


                 dataHandler1.saveAppt(appt);
                 dataHandler1.deleteAppt(appt);

                 dataHandler2.saveAppt(appt);
                 dataHandler2.deleteAppt(appt);

                 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                 if((iteration%10000)==0 && iteration!=0 )
                     System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

             }

             for (long iteration = TestTimeout/2; elapsed < TestTimeout; iteration++) {
                 long randomseed =System.currentTimeMillis(); //10
                 //			System.out.println(" Seed:"+randomseed );
                 Random random = new Random(randomseed);

                 int rMon = ValuesGenerator.getRandomIntBetween(random, 1, 12);
                 int rDay = ValuesGenerator.getRandomIntBetween(random, 1, 31);
                 int rYear = ValuesGenerator.getRandomIntBetween(random, 1, 50);
                 GregorianCalendar dayOne = new GregorianCalendar(rYear, rMon, rDay);

                 rMon = ValuesGenerator.getRandomIntBetween(random, 1, 12);
                 rDay = ValuesGenerator.getRandomIntBetween(random, 1, 31);
                 rYear = ValuesGenerator.getRandomIntBetween(random, 1, 50);
                 GregorianCalendar dayTwo = new GregorianCalendar(rYear, rMon, rDay);

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

                 int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
                 int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
                 int recur=ApptRandomTest.RandomSelectRecur(random);
                 int recurIncrement = ValuesGenerator.RandInt(random);
                 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
                 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

                 dataHandler1.saveAppt(appt);

                 try {
                     dataHandler1.getApptRange(dayOne, dayTwo);
                 }
                 catch(DateOutOfRangeException e){

                 }

                 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                 if((iteration%10000)==0 && iteration!=0 )
                     System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
             }


         }catch(NullPointerException e){

         }

         System.out.println("Done testing...");


	 }


	
}
