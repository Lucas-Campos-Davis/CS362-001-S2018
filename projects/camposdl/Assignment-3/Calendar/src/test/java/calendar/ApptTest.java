/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();

  }
   @Test(timeout = 4000)
   public void test01()  throws Throwable  {
      Appt appt1 = new Appt(12,30,10,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
      String string1 = appt1.toString();
      assertEquals("test@gmail.com", appt1.getEmailAddress());
      assertTrue(appt1.hasTimeSet());
      assertTrue(appt1.isOn(10,10,2010));
      assertTrue(appt1.getValid());

   }
    @Test(timeout = 4000)
    public void test02()  throws Throwable  {
        Appt appt2 = new Appt(-9,30,10,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
        appt2.setValid();
        String string2 = appt2.toString();
        assertFalse(appt2.getValid());
        Appt appt3 = new Appt(9,30,10,10, 0,"TEST", "TEST TESt", "test@gmail.com");
        appt3.setValid();
        assertFalse(appt3.getValid());
        Appt appt4 = new Appt(9,-30,10,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
        appt4.setValid();
        assertFalse(appt4.getValid());
        Appt appt5 = new Appt(9,30,-10,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
        appt5.setValid();
        assertFalse(appt5.getValid());
        Appt appt7 = new Appt(9,30,110,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
        appt7.setValid();
        assertFalse(appt7.getValid());

        Appt appt8 = new Appt(100,30,10,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
        appt8.setValid();
        assertFalse(appt8.getValid());
        Appt appt9 = new Appt(10,300,10,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
        appt9.setValid();
        assertFalse(appt9.getValid());
        Appt appt10 = new Appt(10,30,100,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
        appt10.setValid();
        assertFalse(appt10.getValid());

        Appt appt6 = new Appt(0,0,1,1, 1,"TEST", "TEST TESt", "test@gmail.com");
        appt6.setValid();
        assertTrue(appt6.getValid());
        Appt appt11 = new Appt(23,59,31,12, 2010,"TEST", "TEST TESt", "test@gmail.com");
        appt11.setValid();
        assertTrue(appt11.getValid());
    }
    @Test(timeout = 4000)
    public void test03()  throws Throwable  {
        Appt appt1 = new Appt(12,30,10,10, 2010,"TEST", "TEST TESt", "test@gmail.com");
        String string1 = "";
        appt1.setDescription(string1);
        appt1.setDescription("NEW");

        Appt appt2 = new Appt(10,10, 2010,"TEST", "TEST TESt", string1);


        int [] test = new int [0];
        int [] test2 = new int [1];
        test2[0] = 0;
        appt1.setRecurrence(test,0,0,0);
        appt1.setRecurrence(test2,0,1,1);
        assertEquals(1,appt1.getRecurIncrement());
        assertEquals(1,appt1.getRecurNumber());

        //assertEquals("NEW", appt1.getDescription());

    }
    public void test04()  throws Throwable {
        Appt appt1 = new Appt(12,30,10,10, 2010,null, "TEST TESt", null);

        assertEquals(null,appt1.getXmlElement());
        assertEquals(0, appt1.getRecurNumber());
        assertEquals(null, appt1.getRecurDays());

    }

}
