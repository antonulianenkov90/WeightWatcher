package com.weightwatcher.poms;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudioPage {
	
	WebDriver driver;
	By displayedStudioName=By.xpath("//div[@class=\"location__name\"]//span");
	By todaySchedule = By.xpath("//div[@class=\"hours-list-item-wrapper hours-list--currentday\"]//div[@class=\"hours-list-item-hours\"]");
	
	public StudioPage(WebDriver driver){

        this.driver = driver;

    }
	
	public String getStudioName() {
		String studioNameStr=driver.findElement(displayedStudioName).getText();
		return studioNameStr;
	}
	
	public String getTodaySchedule() {
		String todayScheduleStr=driver.findElement(todaySchedule).getText();
		return todayScheduleStr;
	}
}
