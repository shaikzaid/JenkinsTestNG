package apisfree.testcases;

import APIsecFree.ScreenShotListener.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apisecfree.base.TestBase;
import apisecfree.pages.HomePage_SampleScan;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public class HomePage_SampleScanTest  extends TestBase {
	HomePage_SampleScan HomePage_SampleScan;
	//ScreenshotListener ScreenshotListener;
	ScreenshotListener ScreenshotListener;


	public WebDriver driver;

	HomePage_SampleScanTest(){
		super();
}

	@BeforeMethod
    public void setUp(ITestContext context) {
		ScreenshotListener= new ScreenshotListener(driver);
		ScreenshotListener.setDriver(driver);
        driver = initialization();
        HomePage_SampleScan = new HomePage_SampleScan(driver);
	}

	@Test
	public void SampleScanLinkTest() {
		HomePage_SampleScan.clickSampleScanLink();
		String expectedTitle = "APIsec Free";
		String actualTitle = driver.getTitle();
		 Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.getCurrentTestResult().setAttribute("driver", driver);
		}
}
// <class name="APIsecFree.ScanFree.ScansTest"/>
//<class name="apisfree.testcases.HomePage_SampleScanTest"/>

//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
//<suite name="Suite">
//<listeners>
//		<listener class-name="apisecfree.ExtentReportListener.ExtentReporterNG" />
//	</listeners>
//
//  <test thread-count="5" name="Test">
//    <classes>
//      <class name="apisfree.testcases.HomePage_SampleScanTest"/>
//      <class name="apisfree.testcases.HomePage_SampleSpecAnalysisTest"/>
//      <class name="apisfree.testcases.HomePage_SpecUrlTest"/>
//      <class name="apisfree.testcases.HomePageTest_TC1"/>
//      <class name="apisfree.testcases.HomePage_SpecFileTest"/>
//    </classes>
//  </test> <!-- Test -->
//</suite> <!-- Suite -->


//<dependency>
//    <groupId>org.testng</groupId>
//    <artifactId>testng</artifactId>
//    <version>7.7.1</version>
//    <scope>test</scope>
//</dependency>
