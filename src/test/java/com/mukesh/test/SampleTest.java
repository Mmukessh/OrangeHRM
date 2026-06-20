package com.mukesh.test;

import com.mukesh.driver.DriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static com.mukesh.utility.waitHelper.waitJVM;

public class SampleTest {

    @Description("This is sample test to check all things are workng or not")
    @Test

    public void testsample()
    {
        WebDriver driver;

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mmukessh-trials80.orangehrmlive.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }


    }




