package com.flairstech.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

    private static final String GOOGLE_URL = "https://www.google.com";
    private WebDriver driver;
    private By searchBox = By.id("APjFqb");
    private By searchResultLink = By.partialLinkText("Mercedes-Benz Stadium | Official");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * A method used to navigate to the Google homepage
     */
    public void navigateToGoogle() {
        driver.get(GOOGLE_URL);
    }

    public void enterSearchKeyword(String keyword) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(keyword);
    }

    public void search() {
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public void clickSearchResultLink() {
        driver.findElement(searchResultLink).click();
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("Mercedes-Benz Stadium");
    }
}
