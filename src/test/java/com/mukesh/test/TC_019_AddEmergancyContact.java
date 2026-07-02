package com.mukesh.test;

import com.github.javafaker.Faker;
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

public class TC_019_AddEmergancyContact extends BaseTest {

    @Description("Add Dependant")
    @Test

    public void TC_019_AddEmergancy(ITestContext itestContext)
    {
        String employeeName=itestContext.getAttribute("FullName").toString();

        Faker f=new Faker();
        String emgName=f.name().fullName();
        String relationship=f.relationships().spouse();
        String homeNumber=f.number().digits(10);
        String mobile=f.number().digits(10);
        String office=f.number().digits(10);

        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        AddEmployeePage addEmployeePage=new AddEmployeePage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickEmployeeDetails(employeeName);
       boolean result= addEmployeePage.addEmergancyContact(emgName,relationship,homeNumber,mobile,office);
        Assert.assertEquals(result,true);
    }
}
