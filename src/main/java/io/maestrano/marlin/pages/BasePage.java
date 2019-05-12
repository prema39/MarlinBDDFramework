package io.maestrano.marlin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
   protected WebDriver driver;

   public BasePage(WebDriver driver){
       this.driver = driver;
   }

   By signOutBy = By.xpath("//button[text()='Sign Out']");

}
