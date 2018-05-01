
package picoyplaca.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import picoyplaca.data.Input;


public class SearchTest {
    
    public SearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //Test the hole functionality of the method expecting a full string result
    @Test
    public void testGetResults() throws ParseException {
        System.out.println("Method getResults test");
        //Input data is a regular plaque number and date
        Input inputData = new Input();
        inputData.setPlaqueNumber(159);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        Date inputDate = dateFormat.parse("25/06/2018-16:00");
        inputData.setPlaqueDate(inputDate);
        Search instance = new Search();
        String result = instance.getResults(inputData);
        //If there where no errors we will see a regular result
        System.out.println("Final result: "+result);
    }

    //Test the result given by the method and checks if the result is in the correct range
    @Test
    public void testGetLastNumber() {
        System.out.println("Method GetLastNumber test");
        Search instance = new Search();
        int result = instance.getLastNumber();
        if (result < 0 || result > 9)//The test fails if the final result is not in the correct range
            fail("Method GetLastNumber failed: The result is not in the correct range");
    }

    //Test the method by giving a weekend and expecting the corresponding boolean result
    @Test
    public void testVerifyWeekend() {
        System.out.println("Method VerifyWeekend test");
        //The input is a weekend day, so the final result is false
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, 7);
        Search instance = new Search();
        boolean expResult = false;
        boolean result = instance.verifyWeekend(calendar);
        assertEquals(expResult, result); failed:
        if (expResult == true)//The test fails if the final result is true
            fail("Method VerifyWeekend failed: method returned true istead of false");
    }

    //Test the method by giving a time and expecting the corresponding boolean result
    @Test
    public void testVerifyHour() {
        System.out.println("Method VerifyHour test");
        //The input is a free pico y placa time, so the final result is false
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE, 00);
        Search instance = new Search();
        boolean expResult = false;
        boolean result = instance.verifyHour(calendar);
        assertEquals(expResult, result);
        if (expResult == true)//The test fails if the final result is true
            fail("Method VerifyHour failed: method returned true istead of false");
    }

    //Test the method and checks an expected result
    @Test
    public void testCheckAviability() {
        System.out.println("Method checkAviability test");
        //The input is a number and day of the week with pico y placa impediment
        int lastNumber = 2;
        int dayOfWeek = 2;
        Search instance = new Search();
        String expResult = "Your vehicule may not circulate";
        String result = instance.checkAviability(lastNumber, dayOfWeek);
        assertEquals(expResult, result);
        if (!result.equals(expResult))//The test fails if the final result is a confirmation than the vehicule is free to circulate
            fail("Method checkAviability failed: the result is not the expected");
    }
    
}
