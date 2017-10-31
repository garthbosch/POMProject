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

    @Parameters({"url", "browserType", "waitTimeOut"})
    @BeforeClass
    public void setUp(String url, String browserType, Integer waitTimeOut) throws Exception {
        this.url = url;
        this.browserType = browserType;
        this.waitTimeOut = waitTimeOut;
        driver = new SeleniumWebDriverUtils(url, browserType, waitTimeOut);
        homePage = new HomePageObject(driver);
        driver.startDriver();
    }

    @Test
    public void homePageTests() throws Exception {
        login(driver);
        Assert.assertTrue(homePage.verifyHomePage(), "Home is page is not open");
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
