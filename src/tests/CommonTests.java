package tests;

import gfb.logging.Logging;
import org.apache.log4j.Logger;
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
    protected String username;
    protected String password;
    public static Logger log = Logging.getLogger(true);

    public void login(SeleniumWebDriverUtils seleniumWebDriverUtils, String username, String password) throws Exception {
        this.username = username;
        this.password = password;
        loginPage = new LoginPageObject(seleniumWebDriverUtils);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
    }
}
