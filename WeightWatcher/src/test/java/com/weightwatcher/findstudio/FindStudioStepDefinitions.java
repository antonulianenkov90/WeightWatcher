package com.weightwatcher.findstudio;


import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class FindStudioStepDefinitions {
	WebDriver driver;
	String selectedName;

    @Before
    public void before() {
    	System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Anton\\Desktop\\chromedriver74.exe");
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
	
    @Given("^User on home page$")
    public void user_on_home_page() throws Throwable {
        driver.get("https://www.weightwatchers.com/us/");      
        assertTrue(driver.getTitle().contains("Weight Loss"));
        
    }

    @When("^Click on find a studio$")
    public void click_on_find_a_studio() throws Throwable {
    driver.findElement(By.linkText("Find a Studio")).click();    
    }

    @Then("^Displayed location name matches with the name of the first searched result$")
    public void displayed_location_name_matches_with_the_name_of_the_first_searched_result() throws Throwable {
    	String displayedName=driver.findElement(By.xpath("//div[@class=\"location__name\"]//span")).getText();
    	assertEquals(selectedName, displayedName);
    	System.out.println("TODAY’s hours of operation:\n" + driver.findElement(By.xpath("//div[@class=\"hours-list-item-wrapper hours-list--currentday\"]//div[@class=\"hours-list-item-hours\"]")).getText());
    }

    @And("^In the search field, search for meetings for zip code \"([^\"]*)\"$")
    public void in_the_search_field_search_for_meetings_for_zip_code_something(String zipcode) throws Throwable {
    	assertTrue(driver.getTitle().contains("Meetings Near You"));
    	driver.findElement(By.xpath("//*[@id=\"meetingSearch\"]")).sendKeys(zipcode);
    	driver.findElement(By.xpath("//*[@id=\"content\"]//button")).click();
    }

    @And("^Click on the first search result$")
    public void click_on_the_first_search_result() throws Throwable {
    	selectedName =driver.findElement(By.xpath("//*[@class=\"meeting-locations-list__item\"]//div[@class=\"location__name\"]//span")).getText();
    	System.out.println("Title of first result: "+selectedName);
    	System.out.println("Distance: "+driver.findElement(By.xpath("//*[@class=\"meeting-locations-list__item\"]//*[@class=\"location__distance\"]")).getText());
    	driver.findElement(By.xpath("//*[@class=\"meeting-locations-list__item\"][1]")).click();
    	
    }
    
    @After
    public void after() {
    	driver.close();
    }

}

