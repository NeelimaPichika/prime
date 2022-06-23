package Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Signin {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();//it delete the history
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text() = 'Sign-up']")).click();
		driver.findElement(By.id("fullname")).sendKeys("Mahidhar");
		driver.findElement(By.id("emailid")).sendKeys("mahidharyours@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Mahi@123");
		driver.findElement(By.id("repass")).sendKeys("Mahi@123");
		
		Select Day = new Select(driver.findElement(By.id("date_day")));
		Day.selectByVisibleText("30");
		System.out.println("HI");
		
		
		Select Month = new Select(driver.findElement(By.id("date_mon")));
		Month.selectByVisibleText("SEP");
		
		Select Year = new Select(driver.findElement(By.id("date_yr")));
		Year.selectByVisibleText("1987");
		
		driver.findElement(By.id("sex")).click();
		
		Thread.sleep(2000);
		Select live = new Select(driver.findElement(By.id("country")));
		live.selectByVisibleText("India");
		
		Select City = new Select(driver.findElement(By.id("city")));
		City.selectByVisibleText("Hyderabad");
	    File src = driver.findElement(By.id("img_captcha")).getScreenshotAs(OutputType.FILE);	    
	    FileHandler.copy(src,new File("Screenshots"));
	    	
		driver.findElement(By.id("fld_captcha")).sendKeys("src");
		
		driver.findElement(By.id("btn_register")).click();
	}

}
