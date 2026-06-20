package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.EdituserPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_009_DeleteUser extends BaseTest {

    @Description("Delete user and verify is it avaiable in list or not")
    @Test

    public void deleteUser(ITestContext iTestContext){

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        EdituserPage edituserPage = new EdituserPage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        waitJVM(30000);

        String userName=iTestContext.getAttribute("USERNAME").toString();
        dashboardPage.useredit2(userName);
        waitJVM(20000);
        edituserPage.disablebutton();
        dashboardPage.useredit2(userName);

    }
}
