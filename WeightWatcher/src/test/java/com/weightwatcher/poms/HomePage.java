package com.weightwatcher.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	By findStudioButton =By.linkText("Find a Studio");  
	
	
	public HomePage(WebDriver driver){

        this.driver = driver;

    }
	 
	public void clickFindStudioButton(){

         driver.findElement(findStudioButton).click();

	 }
	 
	public String getHomePageTitle(){

        return    driver.getTitle();

       }
}
