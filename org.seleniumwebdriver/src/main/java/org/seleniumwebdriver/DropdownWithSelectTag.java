package org.seleniumwebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownWithSelectTag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// to open chrome browser
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				options.merge(capabilities);
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();

				// applying implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				// open url
				driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
				
				// maximize window
				driver.manage().window().maximize();
				
				// inspect drop own
				WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country-list']"));
				Select drpCountry=new Select(drpCountryEle);
				
				// 1) Selecting an option from the dropdown
				
				// select using visibleText
				//drpCountry.selectByVisibleText("USA");
				
				// select using selectByValue
				//drpCountry.selectByValue("4"); // use this only if value attribute is present for option tag
				
				// select by index
				drpCountry.selectByIndex(3); //France
		
				// 2) Find total options in dropdown
				List<WebElement> listOfOpt = drpCountry.getOptions();
				System.out.println("total number of options: "+ listOfOpt.size());
				
				//3) print options in console window
				/*
				for(int i=0; i < listOfOpt.size(); i++)
				{
					System.out.println(listOfOpt.get(i).getText());
				}
				*/
				
				//using enhanced loop
				for(WebElement op : listOfOpt)
				{
					System.out.println(op.getText());
				}
				
				

	}

}
