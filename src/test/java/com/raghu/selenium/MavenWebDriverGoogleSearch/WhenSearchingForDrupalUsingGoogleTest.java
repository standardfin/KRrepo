package com.raghu.selenium.MavenWebDriverGoogleSearch;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class WhenSearchingForDrupalUsingGoogleTest  
{
	  private String baseUrl;
	  private WebDriver driver;
	  private ScreenshotHelper screenshotHelper;
	  

	  @Before
	  public void openBrowser() {
		    baseUrl = "http://www.google.com";
		    		//System.getProperty("webdriver.base.url");
		    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raghu\\workspace\\ChromeDriver\\chromedriver.exe");
		    System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.get(baseUrl);
		    screenshotHelper = new ScreenshotHelper();
	  }
	  
	  @After
	  public void saveScreenshotAndCloseBrowser() throws IOException {
	    screenshotHelper.saveScreenshot("screenshot.png");
	    driver.quit();
	  }
	  
	  @SuppressWarnings("deprecation")
	@Test
	  public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException {
/*	    assertEquals("The page title should equal Google at the start of the test.", "Google", driver.getTitle());
	    WebElement searchField = driver.findElement(By.name("q"));
	    searchField.sendKeys("Drupal!");
	    searchField.submit();*/
	    	    
/*	    assertTrue("The page title should start with the search string after the search.",
	      (new WebDriverWait(driver, 10)).until(new ExpectedCondition() {
	        public Boolean apply(WebDriver d) {
	          return d.getTitle().toLowerCase().startsWith("drupal!");
	        }
	      })
	    );*/

		SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
		searchPage.enterSearchKeyWord("Drupal!");
		searchPage.search();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver d) {
	          return d.getTitle().toLowerCase().startsWith("drupal!");
	        }
	      });
		
		System.out.println("Page title is: " + driver.getTitle());
	  }
	  
	  private class ScreenshotHelper {
	    public void saveScreenshot(String screenshotFileName) throws IOException {
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot, new File(screenshotFileName));
	    }
	  }
}
