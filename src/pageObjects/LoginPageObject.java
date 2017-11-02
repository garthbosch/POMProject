package pageObjects;

import utils.SeleniumWebDriverUtils;

public class LoginPageObject {

    private static final String LOGIN_CONTAINER = "//h2[@class='login-form-title text-center ng-binding']";
    private static final String USERNAME_TEXTBOX = "//input[@id='email']";
    private static final String PASSWORD_TEXTBOX = "//input[@id='password']";
    private static final String LOGIN_BUTTON = "//input[@id='logInButton']";
    protected SeleniumWebDriverUtils driver;

    public LoginPageObject(SeleniumWebDriverUtils driver) {
        this.driver = driver;
    }

    public boolean verifyLoginPage() throws Exception {
        return driver.getTextByXpath(LOGIN_CONTAINER).contains("SIGN IN");
    }

    public void enterUsername(String usernameText) {
        try {
            driver.enterTextByXpath(USERNAME_TEXTBOX, usernameText);
        } catch (Exception e) {
            System.err.println("enterUsername method failed - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void enterPassword(String passwordText) {
        try {
            driver.enterTextByXpath(PASSWORD_TEXTBOX, passwordText);
        } catch (Exception e) {
            System.err.println("enterPassword method failed - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickSignIn() {
        try {
            driver.clickByXpath(LOGIN_BUTTON);
        } catch (Exception e) {
            System.err.println("clickSignIn method failed - " + e.getMessage());
            e.printStackTrace();
        }
    }

}
