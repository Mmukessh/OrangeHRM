package com.mukesh.utility;

import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.mukesh.utility.waitHelper.*;

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

    public static void manageJobTitle(By locator,By xpath)
    {
        WebElement dropdowntrigger = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        dropdowntrigger.click();
        //String xpath = "//div[@id='top_level_menu_item_menu_item_102']//a[@data-automation-id='menu_admin_viewJobTitleList']";

        WebElement option = getWait().until(ExpectedConditions.elementToBeClickable(xpath));
        option.click();

    }

    public static void selectNationality(By locator,String value)
    {
        checkvisibilityTclick(locator);
        String xpath="//select[@id='countryCode']/preceding-sibling::ul//span[text()='" + value + "']";

        WebElement optionSelect=getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView({block:'center'});", optionSelect);

        getWait().until(ExpectedConditions.elementToBeClickable(optionSelect));
        optionSelect.click();

    }

    public static void selecttimeZone(By locator,String value)
    {
        checkvisibilityTclick(locator);
        String xpath="//select[@id='time_zone']/preceding-sibling::ul//span[text()='" + value + "']";

        WebElement optionSelect=getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView({block:'center'});", optionSelect);

        getWait().until(ExpectedConditions.elementToBeClickable(optionSelect));
        optionSelect.click();
    //(GMT-12:00) GMT-12:00
    }

    public static void clickonMoreOptions(By locator,By xpath)
    {
        WebElement dropdowntrigger = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        dropdowntrigger.click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(xpath));

        getWait().until(ExpectedConditions.elementToBeClickable(xpath)).click();

    }

    public static void selectrelationship(By locator,String relationshipValue)
    {
        WebElement dropdowntrigger = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        dropdowntrigger.click();
        String xpath = "//li[contains(@class, 'custom-dropdown-item')]//span[normalize-space()='" + relationshipValue + "']";

        WebElement option = getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        option.click();
    }
}
