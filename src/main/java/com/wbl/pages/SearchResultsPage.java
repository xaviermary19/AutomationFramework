package com.wbl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wbl.base.CommonPage;

public class SearchResultsPage extends CommonPage{

	@FindBy(how=How.CSS,using=".desktop-bar-sort")
	WebElement sortDropDown;
	
	@FindBy(how=How.CSS, using = "[class$='field field--select field--primary']")
	List<WebElement> sortDropDownValues;
	
	@FindBy(how=How.CSS, using = ".price-group")
	List<WebElement> prices;
	
	@FindBy(how=How.CSS, using = ".search-result-product-title.gridview a")
	List<WebElement> searchTitleLinks;
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		
	}
		
	public String selectValueFromSortDropDown(String value)
	{
		sortDropDown.click();
		for(WebElement val : sortDropDownValues)
		{
			if(val.getText().equals(val))
			{
				val.click();
				break;
			}
		}
		
		prices = driver.findElements(By.cssSelector(".price-group"));
		return prices.get(0).getText();
	}
	
	public SearchResultDetailPage clickSearchResult(int index)
	{
		searchTitleLinks.get(index).click();
		return new SearchResultDetailPage(driver);
	}
	
	public float findMax(List<WebElement> elements)
	{
		float max=0;
		float actualPrice = Float.parseFloat(prices.get(0).getText().replaceAll("[^0-9].", ""));
		System.out.println("Max in the list : " + actualPrice);
		
		for(WebElement elm : prices)
		{
			float price = Float.parseFloat(elm.getText().replaceAll("[^0-9].", ""));
			if(price>max)
			{
				max = price;
			}
		}
		return actualPrice=max;
	}
	
	public void pricesInSearchResults()
	{
		for(WebElement elm : prices)
		{
			System.out.println(elm.getText());
		}
			
				
		
	}

}
