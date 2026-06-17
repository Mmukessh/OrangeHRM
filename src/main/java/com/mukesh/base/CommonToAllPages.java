package com.mukesh.base;

import com.mukesh.driver.DriverManager;
import com.mukesh.utility.propertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAllPages {
    public CommonToAllPages() {
    }

    public void openURL()
    {
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(propertyReader.readKeys("url"));
    }

    public void enterText(By by, String text)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        DriverManager.getDriver().findElement(by).sendKeys(text);
    }

    public void click(By by)
    {

        DriverManager.getDriver().findElement(by).click();
    }
}
