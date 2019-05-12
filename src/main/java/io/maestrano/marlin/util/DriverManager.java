package io.maestrano.marlin.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;


    public static  WebDriver getDriver(){
        if(driver != null){
            return driver;
        }else{
            ConfigReader configReader = new ConfigReader();
            String browserName = configReader.getProperty("browser");

            switch(browserName.trim().toLowerCase()){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/binaries/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "ie":

            }
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static  void quit(){
        driver.quit();
        driver  = null;
    }
}
