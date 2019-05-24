package com.weightwatcher.findstudio;


import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.weightwatcher.poms.HomePage;
import com.weightwatcher.poms.StudioPage;
import com.weightwatcher.poms.StudioSearchPage;

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
	HomePage objHomePage;
	StudioSearchPage objStudioSearchPage;
	StudioPage objStudioPage;  
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
        objHomePage = new HomePage(driver);
        assertTrue(objHomePage.getHomePageTitle().contains("Weight Loss"));
        
    }

    @When("^Click on find a studio$")
    public void click_on_find_a_studio() throws Throwable {
    	objHomePage.clickFindStudioButton();    
    }

    @Then("^Displayed location name matches with the name of the first searched result$")
    public void displayed_location_name_matches_with_the_name_of_the_first_searched_result() throws Throwable {
    	objStudioPage=new StudioPage(driver);
    	
    	assertEquals(selectedName, objStudioPage.getStudioName());
    	System.out.println("TODAY’s hours of operation:\n"+objStudioPage.getTodaySchedule());
    }

    @And("^In the search field, search for meetings for zip code \"([^\"]*)\"$")
    public void in_the_search_field_search_for_meetings_for_zip_code_something(String zipcode) throws Throwable {
    	objStudioSearchPage=new StudioSearchPage(driver);
    	assertTrue(objStudioSearchPage.getStudioPageTitle().contains("Meetings Near You"));
    	objStudioSearchPage.zipCodeSearch(zipcode);
    }

    @And("^Click on the first search result$")
    public void click_on_the_first_search_result() throws Throwable {
    	selectedName=objStudioSearchPage.getFirstStudioName();
    	System.out.println("Title of first result: "+selectedName);
    	System.out.println("Distance: "+objStudioSearchPage.getFirstStudioDistance());
    	objStudioSearchPage.clickFirstStudio();
    }
    
    @After
    public void after() {
    	driver.close();
    }

}

