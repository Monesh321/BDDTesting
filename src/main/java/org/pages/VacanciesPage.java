package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacanciesPage {
    WebDriver driver;


    @FindBy(xpath = "//button[contains(text(),'Experience level')]")
    WebElement experienceLevel;

    @FindBy(xpath = "//button[contains(text(),'Employment type')]")
    WebElement expType;

    @FindBy(xpath = "//input[@name='Manchester']")
    WebElement officeLocation;

    @FindBy(xpath = "//h3[contains(text(),'Software Engineering, Director')]")
    WebElement result;

    @FindBy(xpath = "//button[contains(text(),'Select')]")
    WebElement select;

    @FindBy(linkText = "View full job description")
    WebElement viewJd;


    private VacanciesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    private static VacanciesPage searchInstance = null;

    public static VacanciesPage getInstance(WebDriver driver) {
        if (searchInstance == null) {
            searchInstance = new VacanciesPage(driver);
        }
        return searchInstance;
    }

    public boolean verifysearchResult(String searchText) {
        return result.getText().contains(searchText);
    }

    public void filterResults(String exp, String type, String location){
        experienceLevel.click();
        WebElement ex= driver.findElement(By.xpath("//label[contains(text(),'"+exp+"')]//..//span"));
        ex.click();
        expType.click();
        WebElement typ= driver.findElement(By.xpath("//label[contains(text(),'"+type+"')]//..//span"));
        typ.click();
        officeLocation.click();
        WebElement loc= driver.findElement(By.xpath("//label[contains(text(),'"+location+"')]//..//span"));
        loc.click();

    }


    public void ClickSelect(){
        select.click();
    }

}
