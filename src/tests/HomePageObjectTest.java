package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import utils.CaptureScreenShot;
import utils.SeleniumWebDriverUtils;

public class HomePageObjectTest extends CommonTests {

    protected HomePageObject homePage;
    protected String homePageVerification;

    @Parameters({"url", "browserType", "waitTimeOut", "username", "password", "homePageVerification" })
    @BeforeClass
    public void setUp(String url, String browserType, Integer waitTimeOut, String username, String password, String homePageVerification) throws Exception {
        this.url = url;
        this.browserType = browserType;
        this.waitTimeOut = waitTimeOut;
        this.username = username;
        this.password = password;
        this.homePageVerification = homePageVerification;
        driver = new SeleniumWebDriverUtils(url, browserType, waitTimeOut);
        homePage = new HomePageObject(driver);
        driver.startDriver();
    }

    @Test
    public void homePageTests() throws Exception {
        login(driver, username, password);
        Assert.assertTrue(homePage.verifyHomePage(homePageVerification), "Home is page is not open");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        System.out.println("Testcase status is " + result.getStatus());
        System.out.println("Iresult status is " + result.FAILURE);

        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                captureScreenshot.captureScreenshot(false, browserType, getClass().getName(), driver);
        }
        driver.shutdown();
    }
}
