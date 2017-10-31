package utils;

import gfb.logging.Logging;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenShot {

    protected String screenshotFile = "";
    protected static Logger log = Logging.getLogger(true);

    public void captureScreenshot(boolean isError, String selectedBrowserType, String filename, SeleniumWebDriverUtils driver) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(getEvidenceFolder(filename)).append("\\");
        if (isError) {
            sb.append("PASSED_");
        } else {
            sb.append("FAILED_");
        }
        sb.append(generateDateTimeString()).append("_").append(filename).append("_").append(selectedBrowserType.toUpperCase()).append(".png");
        screenshotFile = sb.toString();
        File screenCapture = ((TakesScreenshot) driver.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenCapture, new File(screenshotFile));
        log.info("Screenshot " + screenshotFile.toString() + " taken successfully.");
    }

    public String getEvidenceFolder(String filename) throws IOException {
        String getFolderPath = new File("logs\\" + filename).getPath();
        if (getFolderPath == null) {
            getFolderPath = Runtime.getRuntime().exec("mkdirs logs\\" + filename).toString();
            return getFolderPath;
        }
        return getFolderPath;
    }

    public String generateDateTimeString() {
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        return dateFormat.format(dateNow).toString();
    }
}
