package regression.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regression.base.TestBase;
import regression.pages.ContactsPage;
import regression.pages.HomePage;
import regression.pages.LoginPage;
import regression.utils.TestUtil;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test
    public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
    }

    @Test
    public void verifyUserNameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }



    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}