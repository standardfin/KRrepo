package com.raghu.selenium.MavenWebDriverGoogleSearch;


import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage {
	final WebDriver driver;
/*	@FindBy(how = How.NAME, using = "login")
	private WebElement loginEdit;
	@FindBy(how = How.NAME, using = "pass")
	private WebElement passwordEdit;
*/
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchField;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterSearchKeyWord(String keyword){
		searchField.sendKeys(keyword);
	}
	
	public void search(){
		searchField.sendKeys(Keys.ENTER);
	}
}

