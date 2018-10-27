package regression.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regression.base.TestBase;

public class GooglePageTest extends TestBase {
    public GooglePageTest(){
        super();
    }

    @BeforeClass
    public void setUp(){
        initialization();
    }

    @Test
    public void HanumanjeeTest(){

        System.out.println("Passed");

        //

    }
    @AfterClass

    public void tearDown(){
        driver.quit();
    }
}


