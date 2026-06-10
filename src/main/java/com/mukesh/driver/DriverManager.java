package com.mukesh.driver;

import com.mukesh.utility.propertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init()
    {
        String bowser= propertyReader.readKeys("browser");

        switch (bowser){

            case "chrome":
                    driver=new ChromeDriver();
                    break;

            case "firefox":
                driver=new FirefoxDriver();
                break;

            case "edge":
                driver=new EdgeDriver();
                break;

            default:
                System.out.println("Invalid Browser");
        }


    }

    public static void tearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
