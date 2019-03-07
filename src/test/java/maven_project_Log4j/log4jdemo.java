package maven_project_Log4j;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class log4jdemo {
	WebDriver driver;
	static Logger logger=Logger.getLogger(log4jdemo.class);
	
  @Test(priority=1)
  public void OpenBrowser() {
	  
	  PropertyConfigurator.configure("F:\\cjc_software\\java elipse\\eclips\\maven_project_Log4jproperties\\log4j.properties");
	  System.setProperty("webdriver.chrome.driver","F:\\16122018\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  logger.info("browser open succesfuuly");
  }
  
  @Test(priority=2)
  public void EnterApplicatinUrl(){
	  
	  driver.get("http://newtours.demoaut.com/");
	  driver.manage().window().maximize();

	  logger.info("add browser url to open browser successfully");
  }
  
  @Test(priority=3)
  public void LoginwithDetails()
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("diptichopade");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("chopade123");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  logger.debug("user has login succesfully");
  }
  
  @Test(priority=4)
  public void LoginwithInvalidDetails()
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("diptichopade");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("chopade12");
	  logger.warn("password is wrong");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  logger.error("user not login");
  }
  
  
  @AfterMethod
  public void CaptureScreenshot(){
	  
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyToDirectory(src, new File("F:\\cjc_software\\java elipse\\eclips\\maven_project_Log4jproperties\\src\\test\\resources\\Screenshot\\"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		logger.fatal("catch block msg");
		e.printStackTrace();
	}
	  
  }
    
	  
    
}
