package pageObjects;

import utils.SeleniumWebDriverUtils;

public class HomePageObject {

    private static final String BLOG_BUTTON = "//span[@class='link-label ng-binding']";
    private SeleniumWebDriverUtils driver;

    public HomePageObject(SeleniumWebDriverUtils driver) {
        this.driver = driver;
    }

    public boolean verifyHomePage(String homePageVerification) throws Exception {
        return driver.getTextByXpath(BLOG_BUTTON).contains(homePageVerification);
    }
}