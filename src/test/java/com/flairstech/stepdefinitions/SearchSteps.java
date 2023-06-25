package com.flairstech.stepdefinitions;

import com.flairstech.pageobjects.GooglePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchSteps {
    private WebDriver driver;
    private GooglePage googlePage;

    @Before
    public void setup() {
        configureDriver();
    }

    @Given("User is on the Google homepage")
    public void userIsOnGoogleHomepage() {
        googlePage = new GooglePage(driver);
        googlePage.navigateToGoogle();
    }

    @When("User searches for {string}")
    public void userSearchesForKeyword(String keyword) {
        googlePage.enterSearchKeyword(keyword);
        googlePage.search();
    }

    @When("User clicks on the link containing Mercedes-Benz Stadium")
    public void userClicksOnLinkContaining() {
        googlePage.clickSearchResultLink();
    }

    @Then("User should be successfully directed to the homepage containing {string}")
    public void userShouldBeSuccessfullyDirectedToTheHomepage(String title) {
        assertTrue(googlePage.isPageLoaded(), "Page is not loaded");
        assertTrue(driver.getTitle().contains(title));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * A method used to set up and configure the Chrome Driver
     */
    private void configureDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}
