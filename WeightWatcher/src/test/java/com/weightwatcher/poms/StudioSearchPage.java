package com.weightwatcher.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudioSearchPage {

	WebDriver driver;
	By searchBar = By.xpath("//*[@id=\"meetingSearch\"]");
	By searchButton = By.xpath("//*[@id=\"content\"]//button");
	By firstStudioName = By.xpath("//*[@class=\"meeting-locations-list__item\"]//div[@class=\"location__name\"]//span");
	By firstStudioDistance = By.xpath("//*[@class=\"meeting-locations-list__item\"]//*[@class=\"location__distance\"]");
	By firstStudio=By.xpath("//*[@class=\"meeting-locations-list__item\"][1]");
	
	
	public StudioSearchPage(WebDriver driver){

        this.driver = driver;

    }
	
	public void zipCodeSearch(String zipcode) {
		driver.findElement(searchBar).sendKeys(zipcode);
		driver.findElement(searchButton).click();
		
	}
	
	public void clickFirstStudio(){

         driver.findElement(firstStudio).click();

	 }
	
	public String getFirstStudioName() {
		String firstStudioNameStr=driver.findElement(firstStudioName).getText();
		return firstStudioNameStr;
	}
	
	public String getFirstStudioDistance() {
		String firstStudioDistanceStr=driver.findElement(firstStudioDistance).getText();
		return firstStudioDistanceStr;
	}
	
	
	 
	public String getStudioPageTitle(){

        return    driver.getTitle();

       }
	
}
