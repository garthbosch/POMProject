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
    protected String loginPageVerification;

    @Parameters({"url", "browserType", "waitTimeOut", "username", "password", "loginPageVerification"})
    @BeforeClass
    public void setUp(String url, String browserType, Integer waitTimeOut, String username, String password, String loginPageVerification) throws Exception {
        this.url = url;
        this.browserType = browserType;
        this.waitTimeOut = waitTimeOut;
        this.username = username;
        this.password = password;
        this.loginPageVerification = loginPageVerification;
        driver = new SeleniumWebDriverUtils(url, browserType, waitTimeOut);
        loginPage = new LoginPageObject(driver);
        driver.startDriver();
    }

    @Test
    public void loginPageTests() throws Exception {
        Assert.assertTrue(loginPage.verifyLoginPage(), loginPageVerification);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        log.info("Testcase status is " + result.getStatus());
        log.info("Iresult status is " + result.FAILURE);

        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                captureScreenshot.captureScreenshot(false, browserType, getClass().getName(), driver);
        }
        driver.shutdown();
    }
}
