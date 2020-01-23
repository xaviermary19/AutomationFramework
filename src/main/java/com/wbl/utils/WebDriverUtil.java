package com.wbl.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlUnit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverUtil {
	
	static Logger log = LogManager.getLogger(WebDriverUtil.class);
		
		//factory design pattern
		public static WebDriver getDriver(String browsername)
		{
			WebDriver driver = null;
			log.info("In get driver method -browser :" + browsername);
			try
			{
				switch(browsername)
				{
					case "chrome" :
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver.exe");
						driver = new ChromeDriver();
						break;
						
					case "firefox" :
						System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/resources/drivers/geckodriver.exe");
						driver = new FirefoxDriver();
						break;
						
					case "ie" :
						System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/resources/drivers/IEDriverServer.exe");
						driver = new InternetExplorerDriver();
						break;
						
				/*	case "htmlUnit" :
						driver = new HtmlUnitDriver(); */
						
					default :
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/drivers/chromedriver.exe");
						driver = new ChromeDriver();
						break;
				}
				
			}catch(Exception e){
				log.error("There is an exception when creating webdriver object");
				log.error(e.getMessage());
				
			}
			return driver;
		}
	
	
}
