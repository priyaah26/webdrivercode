package org.seleniumwebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownWithoutSelectTag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// applying implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// get url
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();

		// clicking on the dropdown
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

		// to capture the entire option
		List<WebElement> listOfOpt = driver.findElements(By.xpath("//ul[contains(@class,multiselect)]//label"));

		// find total number of options
		System.out.println("Total number of options: " + listOfOpt.size());

		// print all the options from dropdown

		// using normal for loop
		/*
		 * for (int i = 0; i < listOfOpt.size(); i++) {
		 * 
		 * System.out.println(listOfOpt.get(i).getText()); }
		 */

		// select options from dropdown using for and if 
		/*
		for (int i = 0; i < listOfOpt.size(); i++) {
			String option = listOfOpt.get(i).getText();

			if (option.equals("Java") || option.equals("Python")) {
				listOfOpt.get(i).click();
			}

		}
		*/
		
		// using for each
		
		for(WebElement option:listOfOpt)
		{
			String text=option.getText();
			if(text.equals("Java") || text.equals("Python"))
			{
				option.click();
			}
		}

	}

}
