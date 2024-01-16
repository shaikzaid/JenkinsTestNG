package apisecfree.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import apisecfree.base.TestBase;

public class HomePage_SpecFile extends TestBase {
	  WebDriver driver;
	  HomePage_SpecUrl HomePage_SpecUrl;

	    By SpecUrl = By.name("openAPISpec");
	    By Email = By.name("email");
	    By Submit = By.id("btn");
	    By BasicInfoTab = By.name("Basic");
	    
	    By ParametersTab = By.name("param");

	    By OwaspTab = By.name("owaspt");
	    By backButton= By.name("arrow-back-circle");
	    
	    By variablesdownloadbtn = By.id("variablesDownloadBtn");
	    
   public HomePage_SpecFile(WebDriver driver) {
	   this.driver=driver;
	   HomePage_SpecUrl=new HomePage_SpecUrl(driver);
   }
  
   
   public boolean validateSpecFile(File file) throws InterruptedException {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	   
	   WebElement element = driver.findElement(By.linkText("Upload a Spec"));
   	JavascriptExecutor js1 = (JavascriptExecutor)driver;
   	js1.executeScript("arguments[0].click()", element);
   	
   	Thread.sleep(3000);
   	
   	WebElement fileInput = driver.findElement(By.id("getFile"));
    
	
	if(file.isFile()) {
		fileInput.sendKeys(file.getAbsolutePath());
		 driver.findElement(Email).clear();
		 driver.findElement(Email).sendKeys("uiauto@apisec.ai");
	}
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("document.getElementById('btn').click();");
	Thread.sleep(3000);
	 WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='progressOne']/div/progress")));
     Thread.sleep(3000);
     Boolean progressBar1 = wait.until(ExpectedConditions.attributeToBe(progressBar, "value", "100"));
     
     WebElement ParametersTab1 = driver.findElement(ParametersTab);

     if (ParametersTab1.isDisplayed() && ParametersTab1.isEnabled()) {
        ParametersTab1.click();
        
     } else {
         System.out.println("ParametersTab is not clickable.");
     }
     
     
     ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
     Thread.sleep(9000);
     WebElement variablesdownloadbtn=driver.findElement(By.id("variablesDownloadBtn"));
     	variablesdownloadbtn.click();
     Thread.sleep(3000);
		
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));		
//			
//			WebElement element1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div[4]/div/div/table/tbody/tr[1]/th")));
//			JavascriptExecutor js2 = (JavascriptExecutor)driver;
//			js2.executeScript("arguments[0].scrollIntoView();", element1);
//			 
//			Thread.sleep(7000);
//			 
//			 
//			driver.findElement (By.xpath ("/html/body/section/div[1]/div[1]/button")).click();
   	
   	return true;
	   
   }

}
