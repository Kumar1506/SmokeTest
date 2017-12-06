package test_cases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SmokeTest {
	
	
	WebDriver driver = null;

	
	
  @Test
  public void login() throws InterruptedException, IOException {
	  
	  
	  System.setProperty("webdriver.chrome.driver", "C:/Users/sswamy/Selenium All Files/chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://saastpe.asia.manh.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("bmckimadmin");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@1");
	  driver.findElement(By.xpath("//button[@id='loginButton']")).click();
	  driver.findElement(By.xpath("//span[@id='button-1013-btnIconEl']")).click();
	  driver.findElement(By.xpath("//span[contains(text(),'Show All')]")).click();
	  driver.findElement(By.xpath("//span[text()='Integration']")).click();
	  driver.findElement(By.xpath("//span[text()='Post Message']")).click();
	
	//reading xml start
	 /* String projectPath=System.getProperty("user.dir");
	  File inFile = new File(projectPath+"\\SAPUTO_PO.txt");
	    StringBuilder targetString = new StringBuilder("");
	    try {
	        FileReader fr = new FileReader(inFile);
	        BufferedReader br = new BufferedReader(fr);

	        String s = null;
	        while ((s = br.readLine()) != null) {
	            targetString.append(s);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    */
	    //reading xml end
	 // System.out.println(targetString);
	    
		 WebElement frame= driver.findElement(By.xpath("//iframe[contains(@id, 'uxiframe')]"));
		 driver.switchTo().frame(frame);
		 driver.findElement(By.xpath("//input[@id='dataForm:uploadedFileID']")).click();
		 //to upload using autoit
		 Thread.sleep(2000);
		 Runtime.getRuntime().exec("C:\\Users\\sswamy\\workspace_selenium\\SmokeTest\\FileUpload.exe");
		 Thread.sleep(3000);

		 //send button
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@id='dataForm:postMessageCmdId' and @class='btn']")).click();
	 
	
	  
	  
  }
}
