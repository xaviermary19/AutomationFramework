package com.wbl;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.base.CommonPage;
import com.wbl.pages.HomePage;
import com.wbl.pages.SearchResultsPage;
import com.wbl.utils.ExcelHelper;

public class HomePageTest extends BaseTest {
	
	HomePage hm;
	
	@DataProvider(name = "searchData")
	public Object[][] testData()
	{
		return ExcelHelper.getExcelData("HomePage-Data.xlsx", "Sheet1");
	}
	
	@Test(dataProvider = "searchData")
	public void searchTest(String searchKeyWord, String expected)
	{
		//hm = new HomePage(driver);
		hm = PageFactory.initElements(driver, HomePage.class);
		SearchResultsPage sp = hm.search(searchKeyWord);
		System.out.println(driver.getTitle());
		hm.takeScreenShot();
		Assert.assertEquals(sp.getTitle(), expected);
		
	}

}
