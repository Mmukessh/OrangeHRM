package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_005_Logout extends BaseTest {

    @Description("Verify thhat enter valid credentials and click on logout button and nevigate to login page")
    @Test

    public void logoutflow()
    {
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        waitJVM(5000);
        dashboardPage.clickonLogout();

        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("auth/seamlessLogin"));

        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("auth/seamlessLogin"));
    }
}
