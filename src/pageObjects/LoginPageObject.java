package pageObjects;

import utils.SeleniumWebDriverUtils;

public class LoginPageObject {

    private String loginContainer = "//h2[@class='login-form-title text-center ng-binding']";
    private String usernameTextBox = "//input[@id='email']";
    private String passwordTextBox = "//input[@id='password']";
    private String loginButton = "//input[@id='logInButton']";
    protected SeleniumWebDriverUtils driver;

    public LoginPageObject(SeleniumWebDriverUtils driver) {
        this.driver = driver;
    }

    public boolean verifyLoginPage() throws Exception {
        return driver.getTextByXpath(loginContainer).contains("SIGN IN");
    }

    public void enterUsername(String usernameText) {
        try {
            driver.enterTextByXpath(usernameTextBox, usernameText);
        } catch (Exception e) {
            System.err.println("enterUsername method failed - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void enterPassword(String passwordText) {
        try {
            driver.enterTextByXpath(passwordTextBox, passwordText);
        } catch (Exception e) {
            System.err.println("enterPassword method failed - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickSignIn() {
        try {
            driver.clickByXpath(loginButton);
        } catch (Exception e) {
            System.err.println("clickSignIn method failed - " + e.getMessage());
            e.printStackTrace();
        }
    }

}
