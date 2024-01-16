package apisfree.testcases;

import java.io.IOException;
import java.util.List;

import APIsecFree.ScreenShotListener.ScreenshotListener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apisecfree.base.TestBase;
import apisecfree.pages.HomePage_SpecUrl;
import apisecfree.util.TestUtil;
@Listeners(ScreenshotListener.class)
public class HomePage_SpecUrlTest extends TestBase  {
	 HomePage_SpecUrl HomePage_SpecUrl;
	 TestUtil TestUtil;
	//ScreenshotListener ScreenshotListener;
	ScreenshotListener ScreenshotListener;

	public HomePage_SpecUrlTest() {
		super();	}

	 @BeforeMethod
	    public void setUp(ITestContext context) throws IOException, InterruptedException {
		 this.driver = initialization();
	       HomePage_SpecUrl = new HomePage_SpecUrl(driver);
	       TestUtil = new TestUtil();
		 ScreenshotListener= new ScreenshotListener(driver);
		 ScreenshotListener.setDriver(driver);

	    }

	@Test
	    public void validateSpecUrlAndRunTest() throws IOException, InterruptedException {

	        List<String> specUrls = TestUtil.GetUrls();
	        if(specUrls.isEmpty()) {
	        	System.out.println("  it is null" );
	        }
	        for (String specUrl : specUrls) {

	        	Assert.assertTrue(HomePage_SpecUrl.validateSpecUrl(specUrl));
	        	System.out.println("SpecAnalysis Completed ");
	        	 HomePage_SpecUrl.clickRunTestButton();
	        	 Assert.assertTrue(HomePage_SpecUrl.isBackButtonEnabled());
	        	 System.out.println("RunTest Completed ");
	        	driver.get("https://ui.apisecfree-stg-ui.apisec.ai/product.html");
				Reporter.getCurrentTestResult().setAttribute("driver", driver);
	        }
	    }
}