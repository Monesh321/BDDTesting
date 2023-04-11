package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;


    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement cookies;
    @FindBy(xpath = "//input[@id='search-box']")
    WebElement searchbox;

    @FindBy(xpath = "//button[@id='button-addon']")
    WebElement search;


    private SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    private static SearchPage searchInstance = null;

    public static SearchPage getInstance(WebDriver driver) {
        if (searchInstance == null) {
            searchInstance = new SearchPage(driver);
        }
        return searchInstance;
    }

    public void acceptCookies(){
        cookies.click();
    }

    public void searchJob(String searchtext) {
        searchbox.sendKeys(searchtext);
        search.click();
    }


}
