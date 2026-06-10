package com.mukesh.utility;

import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dropdown {

    public static void selectLocation(By locatorLocation,String value)
    {

        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        WebElement dropdownTrigger=wait.until(ExpectedConditions.elementToBeClickable(locatorLocation));
        dropdownTrigger.click();

        String optionXpath = "//li[contains(@class, 'custom-dropdown-item')]//span[contains(@class, 'text') and text()='" + value + "']";


        WebElement option=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        option.click();
    }
}
