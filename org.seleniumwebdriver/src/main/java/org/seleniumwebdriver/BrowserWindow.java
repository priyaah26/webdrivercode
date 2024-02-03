package org.seleniumwebdriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
		//capture id's for browser windows
		Set<String> windowIDs=driver.getWindowHandles();  // store 2 window id's
		
		//Approach1 - using List collection
		/*
		List <String> windowidsList = new ArrayList(windowIDs); // converted Set ---> List
			
		String parentWindowID=windowidsList.get(0);
		String childWindowID=windowidsList.get(1);
		
		
		//Swith to child window
		driver.switchTo().window(childWindowID);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[1]/a/button")).click();
		
		//Switch to parent window
		driver.switchTo().window(parentWindowID);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		
		*/
		
		/*
		for(String winid:windowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
			
			if( title.equals("OrangeHRM HR Software | OrangeHRM"))
			{
				driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[1]/a/button")).click();
			}
		}
		*/
		
		for(String winid:windowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
			
			if( title.equals("OrangeHRM HR Software | OrangeHRM"))
			{
				driver.close();
			}
		}
		
		

	}

}
