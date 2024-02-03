package org.seleniumwebdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReadingConcept {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// we need to create object for property class 
		Properties propertyObj = new Properties();
		
		//here we need to provide the file location 
		//where property file is located(pathname)
		File fileobj = new File("config.properties");
		
		// need to specify the operation (read/write)
		// for read --> getProperty
		// for write --> setProperty
		FileInputStream fileIpStreamObj = new FileInputStream(fileobj);
		
		// we need to load the file or generate
		// now file is loaded and ready
		propertyObj.load(fileIpStreamObj);
		
		/* we need to use getProperty to take the key
		 * if the name is not same we will get null pointer exception*/
		String browserName = propertyObj.getProperty("browser");
		System.out.println("name of the browser: " + browserName);
		
		String urlLink = propertyObj.getProperty("url");	
		System.out.println("url link is : " + urlLink);
				
	}

}
