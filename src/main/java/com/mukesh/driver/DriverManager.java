package com.mukesh.driver;

import com.mukesh.utility.propertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    //public static WebDriver driver;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//    public static WebDriver getDriver() {
//        return driver;
//    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void init() {
        String bowser = propertyReader.readKeys("browser");

        switch (bowser) {

            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                System.out.println("Invalid Browser");
        }


    }

    public static void tearDown() {
        {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();

            }
        }
    }
}
