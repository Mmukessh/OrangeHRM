package com.mukesh.utility;

import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.mukesh.utility.waitHelper.getWait;
import static com.mukesh.utility.waitHelper.waitJVM;

public class CalendarHelper {

//    public static WebDriver driver = DriverManager.getDriver();
//    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public static void joindate(By calenderButton,
                                By yearButton,
                                By monthButton,
                                String targetYear,
                                String targetMonth,
                                String targetDate) {


        // Step 1: Open calendar
        DriverManager.getDriver().findElement(calenderButton).click();
        waitJVM(1000);

        WebElement yearBtn = getWait().until(ExpectedConditions.elementToBeClickable(yearButton));
        String currentYear = yearBtn.getAttribute("title");

        if (!currentYear.equals(targetYear)) {
            yearBtn.click();
            waitJVM(500);

            By yearLocator = By.xpath("//div[contains(@class,'picker__select--year')]" +
                    "//span[@class='text' and text()='" + targetYear + "']");

            WebElement yearOption = getWait().until(ExpectedConditions.elementToBeClickable(yearLocator));
            scrollIntoView(DriverManager.getDriver(), yearOption);
            yearOption.click();
            waitJVM(500);

            getWait().until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'picker__select--year')]//ul[contains(@class,'show')]")));
        }
        WebElement monthBtn = getWait().until(ExpectedConditions.elementToBeClickable(monthButton));
        String currentMonth = monthBtn.getAttribute("title");

        if (!currentMonth.equals(targetMonth)) {
            monthBtn.click();
            waitJVM(500);

            By monthLocator = By.xpath("//div[contains(@class,'picker__select--month')]" +
                    "//span[@class='text' and text()='" + targetMonth + "']");

            WebElement monthOption = getWait().until(ExpectedConditions.elementToBeClickable(monthLocator));
            scrollIntoView(DriverManager.getDriver(), monthOption);
            monthOption.click();
            waitJVM(500);

            getWait().until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'picker__select--month')]//ul[contains(@class,'show')]")));
        }

        // Step 4: Click Date via JS to bypass any residual overlay
        By dateLocator = By.xpath("//div[contains(@class,'picker__day')" +
                " and not(contains(@class,'outfocus'))" +
                " and text()='" + targetDate + "']");

        WebElement dateElement = getWait().until(ExpectedConditions.elementToBeClickable(dateLocator));
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", dateElement);
    }

    private static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitJVM(300);
    }

    public static void dobDate(By dobCalenderButton, By dobyearButton, By dobmonthButton, String dobYear, String dobMonth, String dobDate) {
        DriverManager.getDriver().findElement(dobCalenderButton).click();//dobYear,,
        waitJVM(1000);

        WebElement dobyearElement = getWait().until(ExpectedConditions.elementToBeClickable(dobyearButton));
        String currentYear = dobyearElement.getAttribute("title");

        if (!currentYear.equals(dobYear)) {
            dobyearElement.click();
            WebElement yearOption = getWait().until(ExpectedConditions.elementToBeClickable(DriverManager.getDriver().findElement(By.xpath("//ul[contains(@class, 'select-dropdown')]//li//span[normalize-space()='" + dobYear + "']"))));
            yearOption.click();
        }
        waitJVM(500);
        WebElement dobmonthElement = getWait().until(ExpectedConditions.elementToBeClickable(dobmonthButton));
        String currentMonth = dobmonthElement.getAttribute("title");

        if (!currentMonth.equals(dobMonth)) {
            dobmonthElement.click();
            WebElement monthOption = getWait().until(ExpectedConditions.elementToBeClickable(DriverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'picker__select--month')]//ul[contains(@class, 'select-dropdown')]//li//span[normalize-space()='" + dobMonth + "']"))));
            monthOption.click();
        }
        waitJVM(500);

        WebElement dobdateButton = getWait().until(ExpectedConditions.elementToBeClickable(DriverManager.getDriver().findElement(By.xpath("//table[contains(@class, 'picker__table')]//div[contains(@class, 'picker__day--infocus')][normalize-space()='" + dobDate + "']"))));
        dobdateButton.click();
    }

    public static void licenseExpiryCalender(By calender, By licenseExpiryYearButton, By licenseExpiryMonthButton, String expiryyear, String expirymonth, String expirydate) {
        // 1. Click the calendar button
        getWait().until(ExpectedConditions.elementToBeClickable(calender)).click();

        // 2. CRITICAL: Wait for the picker container to actually have the 'opened' class
        // This ensures we are targeting the correct, visible calendar.
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".picker--opened")));

        // 3. Year Selection
        WebElement yearElement = getWait().until(ExpectedConditions.elementToBeClickable(licenseExpiryYearButton));
        String currentYear = yearElement.findElement(By.tagName("input")).getAttribute("value");

        if (!currentYear.equals(expiryyear)) {
            yearElement.click();
            // Anchor the option to the OPENED picker so we don't click a hidden list from another calendar
            By yearOption = By.xpath("//div[contains(@class, 'picker--opened')]//ul//li//span[text()='" + expiryyear + "']");
            getWait().until(ExpectedConditions.elementToBeClickable(yearOption)).click();
        }

        // 4. Month Selection
        WebElement monthElement = getWait().until(ExpectedConditions.elementToBeClickable(licenseExpiryMonthButton));
        String currentMonth = monthElement.findElement(By.tagName("input")).getAttribute("value");

        if (!currentMonth.equals(expirymonth)) {
            monthElement.click();
            By monthOption = By.xpath("//div[contains(@class, 'picker--opened')]//ul//li//span[text()='" + expirymonth + "']");
            getWait().until(ExpectedConditions.elementToBeClickable(monthOption)).click();
        }

        // 5. Date Selection
        // Use text() comparison to be exact
        By expirydateLocator = By.xpath("//div[contains(@class, 'picker--opened')]//table//div[contains(@class, 'picker__day--infocus') and text()='" + expirydate + "']");
        getWait().until(ExpectedConditions.elementToBeClickable(expirydateLocator)).click();

    }
}


