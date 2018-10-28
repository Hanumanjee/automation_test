package regression.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import regression.base.TestBase;

public class BeforeMethodTest extends TestBase {
    @BeforeMethod
    public void setUp(){
        initialization();
    }

    @Test
    public void HanumanjeeTest(){

        System.out.println("Passed");

        //

    }
    @Test
    public void HanumanjeeTest1(){

        System.out.println("Passed");

        //

    }
    @Test
    public void HanumanjeeTest2(){

        System.out.println("Passed");

        //

    }
    @AfterMethod

    public void tearDown(){
        driver.quit();
    }
}
