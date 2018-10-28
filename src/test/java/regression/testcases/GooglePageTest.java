package regression.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import regression.base.TestBase;

public class GooglePageTest extends TestBase {
    public GooglePageTest(){
        super();
    }

    @BeforeTest(alwaysRun = true)
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
    @AfterTest(alwaysRun = true)

    public void tearDown(){
        driver.quit();
    }
}


