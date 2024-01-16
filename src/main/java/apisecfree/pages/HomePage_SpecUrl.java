package apisecfree.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import apisecfree.base.TestBase;

public class HomePage_SpecUrl extends TestBase {
    WebDriver driver;

    By SpecUrl = By.name("openAPISpec");
    By Email = By.name("email");
    By Submit = By.id("btn");
    By BasicInfoTab = By.name("Basic");
    
    By ParametersTab = By.name("param");

    By OwaspTab = By.name("owaspt");
    By backButton= By.name("arrow-back-circle");
    
    By variablesdownloadbtn = By.id("variablesDownloadBtn");
    //By  = By.xpath("//*[@id='previousBtn']/ion-icon//div/svg/path");
    

    public HomePage_SpecUrl(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean validateSpecUrl(String specUrl) {
        try {
            driver.findElement(Email).clear();
            driver.findElement(SpecUrl).clear();
            driver.findElement(Email).sendKeys("uiauto@apisec.ai");
            driver.findElement(SpecUrl).sendKeys(specUrl);
            

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("document.getElementById('btn').click()");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            Thread.sleep(3000);
//            WebElement progressBar;
//
//            try {
//                progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='progressOne']/div/progress")));
//            } catch (TimeoutException e) {
//                // Handle the timeout exception
//                System.out.println("Timeout waiting for the progress bar. URL might be taking too long to load.");
//                throw e; // Re-thro   
//            

            WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='progressOne']/div/progress")));
            Thread.sleep(3000);
            Boolean progressBar1 = wait.until(ExpectedConditions.attributeToBe(progressBar, "value", "100"));
            
            WebElement ParametersTab1 = driver.findElement(ParametersTab);

            if (ParametersTab1.isDisplayed() && ParametersTab1.isEnabled()) {
              // System.out.println("ParametersTab is clickable.");
               ParametersTab1.click();
               
            } else {
                System.out.println("ParametersTab is not clickable.");
            }
            
            
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            Thread.sleep(9000);
            WebElement variablesdownloadbtn=driver.findElement(By.id("variablesDownloadBtn"));
            	variablesdownloadbtn.click();
            Thread.sleep(3000);
            

            return true;
        } catch (Exception e) {
        	
            System.out.println("Exception occurred while processing URL: " + specUrl);
            e.printStackTrace(); 
           
        } finally {
          // driver.get("https://ui.apisecfree-stg-ui.apisec.ai/product.html");
        //	WebElement runButton = driver.findElement(runButtonXPath);
        	  
        }

        return false; 
    }
    
    public void clickRunTestButton() throws InterruptedException {
//    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//    	  WebElement element = driver.findElement(By.id("btn"));
//    	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//
//    	  
//    	WebElement runButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("runbtn")));
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", runButton);
//    	runButton.click();    	
    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
    	 Thread.sleep(9000);
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement runButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("runbtn")));
        runButton.click();
        
       System.out.println("Generating Test Cases");
       Thread.sleep(9000);

    }
    
    public boolean isBackButtonEnabled() throws InterruptedException { 	
    	//Thread.sleep(200000);
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));  
    	 WebElement backButtonElement = wait.until(ExpectedConditions.elementToBeClickable(backButton));
    	    return driver.findElement((By) backButton).isEnabled();  	    
    }
    
}