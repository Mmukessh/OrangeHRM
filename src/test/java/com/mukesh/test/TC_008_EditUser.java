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

public class TC_008_EditUser extends BaseTest {

    @Description("Edit existing user")
    @Test(priority =3)

    public void editUserTest(ITestContext iTestContext){

        String userName=iTestContext.getAttribute("USERNAME").toString();

        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        EdituserPage edituserPage=new EdituserPage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        waitJVM(30000);

        dashboardPage.useredit2(userName);
        waitJVM(20000);
        edituserPage.editrole("Report Admin");
    }
}
