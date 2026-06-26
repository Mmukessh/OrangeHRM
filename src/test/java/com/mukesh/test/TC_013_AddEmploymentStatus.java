package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.EmploymentStatusPage;
import com.mukesh.page.LoginPage;
import com.mukesh.page.ManagePayGradePage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_013_AddEmploymentStatus extends BaseTest {

    @Description("Add Employment Status")
    @Test

    public void  TC_013_AddEmploymentStatus()
    {
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        EmploymentStatusPage employmentStatusPage=new EmploymentStatusPage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickHRAdministration();
        dashboardPage.clickemploymentStatus();

        boolean result=employmentStatusPage.addEmploymentStatus("Test");

        Assert.assertEquals(result,true);


    }
}
