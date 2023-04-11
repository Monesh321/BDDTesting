package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.SearchPage;
import org.pages.VacanciesPage;

import java.time.Duration;
import java.util.Map;

public class MyStepdefs {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @When("I accept the cookie")
    public void iAcceptTheCookie() {
        SearchPage.getInstance(driver).acceptCookies();
    }

    @And("I search for the job {string}")
    public void iSearchForTheJob(String arg0) {
        SearchPage.getInstance(driver).searchJob(arg0);
        VacanciesPage.getInstance(driver).verifysearchResult(arg0);
    }

    @And("I filter the results of the search with the below values")
    public void iFilterTheResultsOfTheSearchWithTheBelowValues(DataTable dataTable) {

        for (Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
            VacanciesPage.getInstance(driver).filterResults(data.get("Experience level"), data.get("Employment Type"), data.get("Location"));
        }
    }

    @And("I click on {string}")
    public void iClickOn(String arg0) {
        VacanciesPage.getInstance(driver).ClickSelect();
    }

    @Then("I am able to verify JD successfully with below values")
    public void iAmAbleToVerifyJDSuccessfullyWithBelowValues() {


    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        driver.get("https://www.kpmgcareers.co.uk");
    }
}
