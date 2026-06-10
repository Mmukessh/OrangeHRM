package com.mukesh.test;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

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
