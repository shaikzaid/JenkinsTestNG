package APIsecFree.ScreenShotListener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScreenshotListener extends TestListenerAdapter {

    private WebDriver driver;

    public ScreenshotListener() {
    }

    public ScreenshotListener(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed! Capturing Screenshot...");
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);

            // Save the screenshot to a file
            String screenshotName = result.getName() + "_failure.png";
            saveScreenshot(screenshot, screenshotName);
        }
    }

    private void saveScreenshot(byte[] screenshot, String screenshotName) {
        try {
            File screenshotFile = new File("C:\\Users\\Asiya-APIsec\\Pictures\\" + screenshotName);
            FileOutputStream fos = new FileOutputStream(screenshotFile);
            fos.write(screenshot);
            fos.close();
            System.out.println("Screenshot saved to: " + screenshotFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}

