package pageObjects;

import utils.SeleniumWebDriverUtils;

public class HomePageObject {

    private SeleniumWebDriverUtils driver;
    private String blogButton = "//span[@class='link-label ng-binding']";

    public HomePageObject(SeleniumWebDriverUtils driver) {
        this.driver = driver;
    }

    public boolean verifyHomePage(String homePageVerification) throws Exception {
        return driver.getTextByXpath(blogButton).contains(homePageVerification);
    }
}
