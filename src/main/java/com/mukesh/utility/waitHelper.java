package com.mukesh.utility;

import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    public static void checkvisibilityTclick(By locator)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15));
        WebElement button=wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public static void refresgpage()
    {
        DriverManager.getDriver().navigate().refresh();
    }

    public static List<WebElement> waitfoeElement(By locator)
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(20));

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
