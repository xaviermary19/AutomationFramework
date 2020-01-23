package com.wbl;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.pages.HomePage;
import com.wbl.pages.SearchResultsPage;

public class SearchResultsPageTest extends BaseTest {
	
	HomePage hm;
	
	public SearchResultsPageTest()
	{
		PageFactory.initElements(driver, SearchResultsPage.class);
	}
	
	@Test
	public void maxPriceSortTest()
	{
		hm = PageFactory.initElements(driver, HomePage.class);
		SearchResultsPage sp = hm.search("Laptop");
		sp.selectValueFromSortDropDown("Price: high to low");
		sp.pricesInSearchResults();
	}

}
