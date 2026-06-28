package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_016_SearchEmployee_ByName extends BaseTest {

    @Description("Search Employee By name")
    @Test

    public void TC_16_SearchEmployeeByName(ITestContext context)
    {
        String employeeName=context.getAttribute("FullName").toString();
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));

        boolean data= dashboardPage.searchEmployeeBy_Name(employeeName);
        Assert.assertEquals(data,true);
    }
}
