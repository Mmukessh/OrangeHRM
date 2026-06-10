package com.mukesh.utility;

import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.mukesh.driver.DriverManager.driver;

public class waitHelper {

    public static void waitJVM(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkVisibility(By locator)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String getTextWithWait(By locator)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public static void checkvisibilityTclick(By locator)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15));
        WebElement button=wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }

    private static WebDriverWait getWait(DriverManager driverManager) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
