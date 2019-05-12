package io.maestrano.marlin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    By addDashboard_by = By.xpath("//*[@data-pt-name='bb_hd_close_create_dash']");
    By addDashboardName_by = By.xpath("//*[@placeholder=\"Dashboard's name\"]");
    By addDashboardBtn_by = By.xpath("//*[@data-pt-name='bb_hd_confirmAddDashboard']");
    String dashboard_xpath = "//*[@data-pt-name='bb_hd_dashboardnav' and contains(text(),'DASHBOARD_NAME')]";
    By dashboardoptions_by = By.xpath("//*[@data-pt-name=\"bb_mm_more\"]");
    By editdashboard_by = By.xpath("//a[contains(@class,'px-3 py-3  d-block pointer chaseanalytics')and contains(text(),'Edit dashboard')]");
    By addmodulebtn_by = By.xpath("//a[contains(text(),'Add module')]");
    String module_xpath = "//div[text()='MODULE_NAME' and @class='thumbnail-title']/..";
    By addtodashboardlnk_by = By.xpath("//a[text()='Add to dashboard']");
    By hidemodules_by = By.xpath("//a[@data-pt-name='bb_ft_collapseaddmodule']");

    // By editmodulename_by = By.xpath("//input[contains(@class,'module-name-input')]");
    By savebtn_by = By.xpath("//*[text()='Save']");
    By addKPI_by = By.xpath("//button[@data-pt-name='bb_mm_more_dashboard_kpi']");

    String kpi_xpath = "//div[@class='modal-container']//li[contains(text(),'KPI_NAME')]";
    By timeperiod_by = By.xpath("//select[@name='timePeriod']");

    By comparisonperiod_by = By.xpath("//select[@name='comparionPeriod']");
    String option_xpath = "//option[contains(text(),'OPTION_NAME')]";
    By donebtn_by = By.xpath("//button[text()='Done']");


    public void addDashBoard(String dashboardName) {
        driver.findElement(addDashboard_by).click();
        driver.findElement(addDashboardName_by).sendKeys(dashboardName);
        driver.findElement(addDashboardBtn_by).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isPageLoaded() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.findElements(signOutBy).size());
        return driver.findElements(signOutBy).size() != 0;
    }

    public boolean isDashboardPresent(String dashName) {
        System.out.println(dashboard_xpath.replace("DASHBOARD_NAME", dashName));
        return !driver.findElements(By.xpath(dashboard_xpath.replace("DASHBOARD_NAME", dashName))).isEmpty();
    }

    public void editDashboard() {
        driver.findElement(dashboardoptions_by).click();
        driver.findElement(editdashboard_by).click();


    }

    public void clickAddModule() {
        driver.findElement(addmodulebtn_by).click();
    }

    public void addModule(String modulename) {
        driver.findElement(By.xpath(module_xpath.replace("MODULE_NAME", modulename))).click();
    }

    public void clickOnAddToDashboardLink() {
        driver.findElement(addtodashboardlnk_by).click();
    }

    public void clickOnHidemodules() {
        driver.findElement(hidemodules_by).click();
    }

    //    public void editmoduleName(String modName){
//        driver.findElement(editmodulename_by).sendKeys(modName);
//    }

    public void addKPI(String kpiName){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(addKPI_by).click();
        driver.findElement(By.xpath(kpi_xpath.replace("KPI_NAME",kpiName))).click();

    }

    public void selectTimeperiod(String Timeperiod){
        driver.findElement(timeperiod_by).click();
        driver.findElement(By.xpath(option_xpath.replace("OPTION_NAME",Timeperiod))).click();

    }

    public void selectComarisionPeriod(String comparionPeriod){
        driver.findElement(comparisonperiod_by).click();
        driver.findElement(By.xpath(option_xpath.replace("OPTION_NAME",comparionPeriod))).click();

    }

    public void clickOndone(){
        driver.findElement(donebtn_by).click();
    }
    public void clickOnSaveButton() {
        driver.findElement(savebtn_by).click();
    }
}
