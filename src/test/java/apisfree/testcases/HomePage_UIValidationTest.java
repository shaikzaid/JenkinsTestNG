package apisfree.testcases;

import APIsecFree.ScreenShotListener.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import apisecfree.base.TestBase;
import apisecfree.pages.HomePage_UIValidation;
@Listeners(ScreenshotListener.class)
public class HomePage_UIValidationTest extends TestBase {

    HomePage_UIValidation HomePage_UIValidation;
   // ScreenshotListener ScreenshotListener;
    ScreenshotListener ScreenshotListener;

    public HomePage_UIValidationTest() {
        super();
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        WebDriver driver = initialization();
        HomePage_UIValidation = new HomePage_UIValidation(driver);
        ScreenshotListener= new ScreenshotListener(driver);
        ScreenshotListener.setDriver(driver);
    }

    @Test
    public void validateSampleScanLinkTest() {
        Assert.assertTrue(HomePage_UIValidation.validateSampleScanLink());
    }

    @Test
    public void validateSampleSpecAnalysisLinkTest() {
        Assert.assertTrue(HomePage_UIValidation.validateSampleSpecAnalysisLink());
    }
    @Test
	public void SpecTextboxTextTest() {
		String Text = HomePage_UIValidation.validateSpecTextboxText();
		Assert.assertEquals(Text,"");
	}
	@Test
	public void EmailTextboxTextTest() {
		String Text = HomePage_UIValidation.validateEmailTextboxText();
		Assert.assertEquals(Text,"");
        Reporter.getCurrentTestResult().setAttribute("driver", driver);
	}
    @Test
	public void validateSubmitbtnTest() {
				Assert.assertTrue(HomePage_UIValidation.validateSubmitbtn());
	}
//	@AfterMethod
//	public void teardown(WebDriver driver) {
//	driver.quit();
//	}
}