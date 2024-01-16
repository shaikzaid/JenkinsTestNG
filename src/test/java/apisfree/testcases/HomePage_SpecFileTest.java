package apisfree.testcases;

import java.io.File;
import java.io.IOException;

import APIsecFree.ScreenShotListener.ScreenshotListener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apisecfree.base.TestBase;
import apisecfree.pages.HomePage_SpecFile;
import apisecfree.pages.HomePage_SpecUrl;
import apisecfree.util.FileUtil;
@Listeners(ScreenshotListener.class)
public class HomePage_SpecFileTest extends TestBase {
	HomePage_SpecFile HomePage_SpecFile;
	HomePage_SpecUrl HomePage_SpecUrl;
	FileUtil FileUtil;
	//ScreenshotListener ScreenshotListener;
	ScreenshotListener ScreenshotListener;

	public HomePage_SpecFileTest() {
		super();
	}


	 @BeforeMethod
	public void setUp(ITestContext context) {
		 ScreenshotListener= new ScreenshotListener(driver);
		 ScreenshotListener.setDriver(driver);
		this.driver = initialization();
		HomePage_SpecFile=new HomePage_SpecFile(driver);
		 HomePage_SpecUrl=new HomePage_SpecUrl(driver);
		 FileUtil = new FileUtil();


	}
	@Test
	public void validateSpecFile() throws InterruptedException, IOException {
		   File[] files= FileUtil.GetFiles();
        for (File file : files) {
        	Assert.assertTrue(HomePage_SpecFile.validateSpecFile(file));
		 System.out.println("SpecAnalysis Completed ");
    	 HomePage_SpecUrl.clickRunTestButton();
    	 Assert.assertTrue(HomePage_SpecUrl.isBackButtonEnabled());
    	 Thread.sleep(9000);
    	 System.out.println("RunTest Completed ");
    	driver.get("https://ui.apisecfree-stg-ui.apisec.ai/product.html");
			Reporter.getCurrentTestResult().setAttribute("driver", driver);
	}
}}
