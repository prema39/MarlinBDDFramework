package stepdef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.maestrano.marlin.pages.DashboardPage;
import io.maestrano.marlin.pages.LoginPage;
import io.maestrano.marlin.util.ConfigReader;
import io.maestrano.marlin.util.DriverManager;
import io.maestrano.marlin.util.RandomGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.Driver;

public class StepDefinitions {
    WebDriver driver;
    ConfigReader cr  = new ConfigReader();
    LoginPage loginPage;
    DashboardPage dashboardPage;
    String dName;
    @Before
    public void initialize(){
        driver  = DriverManager.getDriver();
    }

    //@After
    public void teardown(){
        DriverManager.quit();
    }
    @Given("user is in login page")
    public void user_is_in_login_page() {
       driver.get(cr.getProperty("url"));
    }

    @When("user provides username  as {string} and password as {string}")
    public void user_provides_username_as_and_password_as(String userName, String password) {
        loginPage = new LoginPage(driver);
       dashboardPage = loginPage.login(userName, password);
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        Assert.assertTrue(dashboardPage.isPageLoaded(), "User has not been logged in");
    }



    @When("user enters the credential for tester")
    public void user_enters_the_credential_for_tester() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login(cr.getProperty("username_tester"), cr.getProperty("password_tester"));
    }

    @When("user wants add a dashboard with name as {string}")
    public void user_wants_add_a_dashboard_with_name_as(String dashboardName) {
        dName  = RandomGenerator.generateRandomizeString(dashboardName);
        dashboardPage.addDashBoard(dName);

    }

    @Then("user should on given dashboard")
    public void user_should_on_given_dashboard() {
       Assert.assertTrue(dashboardPage.isDashboardPresent(dName), "Dashboard with name "+dName+" is not present");
    }


    @When("user edits the dashboard")
    public void user_edits_the_dashboard() {
        dashboardPage.editDashboard();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @When("user click on addmodule button")
    public void user_click_on_addmodulebtn() {
        dashboardPage.clickAddModule();
    }


    @When("user add module with name as {string}")
    public void user_add_module_with_name_as(String modName) {
        dashboardPage.addModule(modName);
        dashboardPage.clickOnAddToDashboardLink();
        dashboardPage.clickOnHidemodules();
        //dashboardPage.editmoduleName();

    }
    @When("add the kpi as {string}")
    public void add_the_kpi_as(String KPIName) {

        dashboardPage.addKPI(KPIName);
    }

    @When("add the time period as {string}")
    public void add_the_time_period_as(String Timeperiod) {
dashboardPage.selectTimeperiod(Timeperiod);
    }

    @When("add the comparision period as {string}")
    public void add_the_comparision_period_as(String comparionPeriod) {
dashboardPage.selectComarisionPeriod(comparionPeriod);
dashboardPage.clickOndone();
    }

    @When("click on save")
    public void clickonsave() {
        dashboardPage.clickOnSaveButton();
    }


    @Then("added module should be displayed")
    public void added_module_should_be_displayed() {

    }

}
