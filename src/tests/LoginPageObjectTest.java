package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import pageObjects.LoginPageObject;
import utils.SeleniumWebDriverUtils;
import utils.CaptureScreenShot;

public class LoginPageObjectTest extends CommonTests {

    protected LoginPageObject loginPage;

    @Parameters({"url", "browserType", "waitTimeOut"})
    @BeforeClass
    public void setUp(String url, String browserType, Integer waitTimeOut) throws Exception {
        this.url = url;
        this.browserType = browserType;
        this.waitTimeOut = waitTimeOut;
        driver = new SeleniumWebDriverUtils(url, browserType, waitTimeOut);
        loginPage = new LoginPageObject(driver);
        driver.startDriver();
    }

    @Test
    public void loginPageTests() throws Exception {
        Assert.assertTrue(loginPage.verifyLoginPage(), "Sign is page is not open");
        loginPage.enterUsername("garthbosch@gmail.com");
        loginPage.enterPassword("gfb821009");
        loginPage.clickSignIn();
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
