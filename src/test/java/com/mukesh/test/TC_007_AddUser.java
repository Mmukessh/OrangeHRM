package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.AddEmployeePage;
import com.mukesh.page.AddUser;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import java.util.Random;

import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_007_AddUser extends BaseTest {

    @Description("To add New User")
    @Test(priority = 2)

    public void addNewUser(ITestContext iTestContext)
    {
        Faker faker=new Faker();
        String username= faker.name().username();
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        AddUser  addUser=new AddUser(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickHRAdministration();
        dashboardPage.addUser();
        String employeeName=iTestContext.getAttribute("FullName").toString();
        System.out.println(employeeName);
        addUser.adduser(employeeName,username,"Global Admin","Welcome@1Atthang","Welcome@1Atthang");
       String userstatus= String.valueOf(dashboardPage.userstatus(username));
        System.out.println(userstatus);
        Assert.assertEquals(userstatus,"Enabled");
        waitJVM(5000);
    }




}
