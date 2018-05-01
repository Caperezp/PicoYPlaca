
package picoyplaca.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PicoYPlacaTest {
    
    public PicoYPlacaTest() {
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
    
    //Test the method with a plaque number and expecting a confirmation of a correct number
    @Test
    public void testverifyNumber(){
        System.out.println("Method verifyNumber test");
        int inputData = 193;//The input is a correct plaque number
        boolean result = PicoYPlaca.verifyNumber(inputData);
        boolean expResult = true;
        assertEquals(expResult, result); 
        if (expResult == false)//The test fails if the final result is false
            fail("Method verifyNumber failed: method returned false istead of true");
        
    }
    
}
