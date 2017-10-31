package utils;

import java.io.Serializable;

public enum PageObjects implements Serializable {

    AboutUsLink("//li[@class='dropdown active']", "About Us"),
    AboutUsLinkText("About Us", "About Us");

    private final String elementId;

    private final String elementNameOnPage;

    PageObjects(String elementId, String elementNameOnPage) {
        this.elementId = elementId;
        this.elementNameOnPage = elementNameOnPage;
    }

    public String getElementId() {
        return elementId;
    }

    public String getElementNameOnPage() {
        return elementNameOnPage;
    }
}
