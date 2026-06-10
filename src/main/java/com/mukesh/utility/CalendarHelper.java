package com.mukesh.utility;

import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.mukesh.utility.waitHelper.waitJVM;

public class CalendarHelper {

    public static void selectDate(By calenderButton,
                                  By yearButton,
                                  By monthButton,
                                  String targetYear,
                                  String targetMonth,
                                  String targetDate) {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 1: Open calendar
        driver.findElement(calenderButton).click();
        waitJVM(1000);

        WebElement yearBtn = wait.until(ExpectedConditions.elementToBeClickable(yearButton));
        String currentYear = yearBtn.getAttribute("title");

        if (!currentYear.equals(targetYear)) {
            yearBtn.click();
            waitJVM(500);

            By yearLocator = By.xpath("//div[contains(@class,'picker__select--year')]" +
                    "//span[@class='text' and text()='" + targetYear + "']");

            WebElement yearOption = wait.until(ExpectedConditions.elementToBeClickable(yearLocator));
           scrollIntoView(driver, yearOption);
            yearOption.click();
            waitJVM(500);

            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'picker__select--year')]//ul[contains(@class,'show')]")));
        }
        WebElement monthBtn = wait.until(ExpectedConditions.elementToBeClickable(monthButton));
        String currentMonth = monthBtn.getAttribute("title");

        if (!currentMonth.equals(targetMonth)) {
            monthBtn.click();
            waitJVM(500);

            By monthLocator = By.xpath("//div[contains(@class,'picker__select--month')]" +
                    "//span[@class='text' and text()='" + targetMonth + "']");

            WebElement monthOption = wait.until(ExpectedConditions.elementToBeClickable(monthLocator));
            scrollIntoView(driver, monthOption);
            monthOption.click();
            waitJVM(500);

            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'picker__select--month')]//ul[contains(@class,'show')]")));
        }

        // Step 4: Click Date via JS to bypass any residual overlay
        By dateLocator = By.xpath("//div[contains(@class,'picker__day')" +
                " and not(contains(@class,'outfocus'))" +
                " and text()='" + targetDate + "']");

        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(dateLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement);
    }

    private static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitJVM(300);
    }


}


