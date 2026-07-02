package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.AddEmployeePage;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC_020_TerminateEmployee extends BaseTest {

    @Description("Terminate Employee")
    @Test
    public void TC_020_TerminateEmployee(ITestContext itestContext){

        String employeeName=itestContext.getAttribute("FullName").toString();

        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        AddEmployeePage addEmployeePage=new AddEmployeePage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickEmployeeDetails(employeeName);
        String status=addEmployeePage.terminatEmployee();

        Assert.assertEquals(status,"Inactive");

    }
}
