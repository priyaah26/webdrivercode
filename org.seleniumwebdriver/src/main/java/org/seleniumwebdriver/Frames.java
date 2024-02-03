package org.seleniumwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
				
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();// frame1
		
		driver.switchTo().defaultContent();// switch back to page
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("WebDriver")).click();  // frame2
		
		driver.switchTo().defaultContent();// switch back to page
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Overview']")).click();

	}

}
