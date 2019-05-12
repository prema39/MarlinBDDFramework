package io.maestrano.marlin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){

        super(driver);
    }

    By email_name  = By.name("email");
    By password_name = By.name("password");
    By login_button_xpath =By.xpath("//form[@name='form']/div[3]/button");

    public DashboardPage login(String username, String password){
        driver.findElement(email_name).sendKeys(username);
        driver.findElement(password_name).sendKeys(password);
        driver.findElement(login_button_xpath).click();
        return new DashboardPage(driver);

    }



}
