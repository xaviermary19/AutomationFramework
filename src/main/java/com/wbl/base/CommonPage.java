package com.wbl.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.pages.SearchResultsPage;

public class CommonPage {
	
	protected WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"global-search-input\"]")
	WebElement searchBox;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"global-search-submit\"]/span/span")
	WebElement searchButton;
	
	public CommonPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void takeScreenShot()
	{
		try {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenShotName = new File ("C:/Users/antoj/eclipse-workspace/AutomationFramework/resources/screenshots/error.png");
		FileUtils.copyFile(scrFile, screenShotName);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public SearchResultsPage search(String searchdata)
	{
		searchBox.sendKeys(searchdata);
		searchButton.click();
		return PageFactory.initElements(driver, SearchResultsPage.class);
	}
}
