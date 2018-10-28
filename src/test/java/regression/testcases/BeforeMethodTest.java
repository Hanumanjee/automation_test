package regression.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import regression.base.TestBase;

public class BeforeMethodTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        initialization();
    }

    @Test
    public void HanumanjeeTest(){

        System.out.println("Passed");
        WebElement searchField= driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input"));
        searchField.clear();
        searchField.sendKeys("San Fransisco");

        //

    }

    @Test
    public void HanumanjeeTest1(){

        System.out.println("Passed");
       WebElement searchField= driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input"));
       searchField.clear();
       searchField.sendKeys("Hanumanjee");

        //

    }
    @Test
    public void HanumanjeeTest2(){

        System.out.println("Passed");
        WebElement searchField= driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input"));
        searchField.clear();
        searchField.sendKeys("Puri");

        //

    }
    @AfterMethod(alwaysRun = true)

    public void tearDown(){
        driver.quit();
    }
}
