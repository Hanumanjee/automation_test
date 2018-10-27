package regression.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import regression.utils.TestUtil;
import regression.utils.WebEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialization(){
        String browserName = prop.getProperty("browser");
        String ipAddress = "10.0.0.40";
        if(browserName.equals("chrome")){


            //System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");

            System.setProperty("webdriver.chrome.driver", "D:\\ideaProjects\\automation_test\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "System.getProperty(\"user.dir\")+ \"/src/test/resources/chromedriver.exe");
            driver = new FirefoxDriver();
        }else if(browserName.equals("remote")){
            //1. DesiredCapabilities
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.WIN8_1);

            //2. Chrome Option Defination

            ChromeOptions options = new ChromeOptions();
            options.merge(cap);

            String hubURL = "http://10.0.0.40:4444/wd/hub";
            try {
                driver = new RemoteWebDriver(new URL(hubURL), cap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
//

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }








}
