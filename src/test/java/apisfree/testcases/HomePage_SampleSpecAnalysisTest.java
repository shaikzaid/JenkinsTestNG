package apisfree.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import apisecfree.base.TestBase;
import apisecfree.pages.HomePage_SampleSpecAnalysis;
import org.testng.annotations.Listeners;

//@Listeners(ScreenshotListener.class)
public class HomePage_SampleSpecAnalysisTest extends TestBase{
	
	HomePage_SampleSpecAnalysis HomePage_SampleSpecAnalysis;
	//ScreenshotListener ScreenshotListener;
	public WebDriver driver;
	
	HomePage_SampleSpecAnalysisTest(){
		super();
}
	
	@BeforeMethod
    public void setUp() {
        driver = initialization();
        HomePage_SampleSpecAnalysis = new HomePage_SampleSpecAnalysis(driver);

    }
	
	@Test
	public void SampleSpecAnalysisLinkTest() {
		HomePage_SampleSpecAnalysis.clickSampleSpecAnalysisLink();
			
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expectedTitle = "APIsec Scan";
		String actualTitle = driver.getTitle();
		 Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.getCurrentTestResult().setAttribute("driver", driver);

		}
//	@AfterMethod
//	public void teardown(ITestResult result) {
//	driver.quit();
//	}
}