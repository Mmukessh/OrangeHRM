package com.mukesh.utility;

import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.mukesh.utility.waitHelper.getWait;
import static com.mukesh.utility.waitHelper.waitJVM;

public class Dropdown {


    public static void selectLocation(By locatorLocation,String value)
    {


        WebElement dropdownTrigger=getWait().until(ExpectedConditions.elementToBeClickable(locatorLocation));
        dropdownTrigger.click();

        String optionXpath = "//li[contains(@class, 'custom-dropdown-item')]//span[contains(@class, 'text') and text()='" + value + "']";


        WebElement option=getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        option.click();
    }

    public static void maritalstatus(By locatorMaritalstatus,String value)
    {
        WebElement maritaldropdowntrigger=getWait().until(ExpectedConditions.elementToBeClickable(locatorMaritalstatus));
        maritaldropdowntrigger.click();
        String xpath="//ul[contains(@class,'select-dropdown')]//span[normalize-space()='" + value + "']";
        WebElement option=getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        option.click();
    }

    public static void selectGender(By  locatorGender,String value)
    {
        WebElement genderdropdowntrigger=getWait().until(ExpectedConditions.elementToBeClickable(locatorGender));
        genderdropdowntrigger.click();
        String xpathGender="//ul[contains(@class,'select-dropdown')]//span[normalize-space()='" + value + "']";
        WebElement option=getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpathGender)));
        option.click();
    }

    public static void nationality(By locator,String value)
    {
        WebElement dropdowntrigger=getWait().until(ExpectedConditions.elementToBeClickable(locator));
        dropdowntrigger.click();
        String xpathnationality="//select[@id='nation_code']/preceding-sibling::ul//span[text()='"+value+"']";
        WebElement option=getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpathnationality)));
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView({block:'center'});", option);

        getWait().until(ExpectedConditions.elementToBeClickable(option));
        option.click();

    }

    public static void onBoarding(By locator,String value)
    {
        WebElement dropdowntrigger=getWait().until(ExpectedConditions.elementToBeClickable(locator));
        dropdowntrigger.click();
        String xpath="//select[@id='eventTemplate']/preceding-sibling::ul//span[text()='" + value + "']";
        WebElement option=getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        option.click();

    }

    public static void adminRole(By locator,String value)
    {
        WebElement dropdowntrigger = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        dropdowntrigger.click();
        String xpath = "//li[contains(@class,'custom-dropdown-item')]"
                        +"[normalize-space()='"
                        +value+"']";

        WebElement option = getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        option.click();

    }

    public static void selectEmployeeName(By locator,String name)
    {
        WebElement employeename=getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        employeename.sendKeys(name);
        waitJVM(2000);
        employeename.sendKeys(Keys.ARROW_DOWN);
        employeename.sendKeys(Keys.ENTER);
    }

    public static void manageJobTitle(By locator)
    {
        WebElement dropdowntrigger = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        dropdowntrigger.click();
        String xpath = "//a[text()='Manage Job Titles']";

        WebElement option = getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        option.click();

    }
}
