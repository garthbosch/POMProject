package tests;

import pageObjects.LoginPageObject;
import utils.CaptureScreenShot;
import utils.SeleniumWebDriverUtils;

public class CommonTests {

    protected LoginPageObject loginPage;
    protected SeleniumWebDriverUtils driver;
    protected CaptureScreenShot captureScreenshot = new CaptureScreenShot();
    protected String url;
    protected String browserType;
    protected Integer waitTimeOut;

    public void login(SeleniumWebDriverUtils seleniumWebDriverUtils) throws Exception {
        loginPage = new LoginPageObject(seleniumWebDriverUtils);
        loginPage.enterUsername("garthbosch@gmail.com");
        loginPage.enterPassword("gfb821009");
        loginPage.clickSignIn();
    }
}
