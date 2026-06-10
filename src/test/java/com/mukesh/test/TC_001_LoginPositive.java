package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_001_LoginPositive extends BaseTest {

    @Description("To check verify login with valid credentials")
    @Test

    public void testLogin()
    {
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
