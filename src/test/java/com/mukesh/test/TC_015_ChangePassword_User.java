package com.mukesh.test;

import com.github.javafaker.Faker;
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

public class TC_015_ChangePassword_User extends BaseTest {

    @Description("Change User Password")
    @Test(priority = 4)

    public void TC_15_changepasswordUser(ITestContext itestcontext)

    {
        Faker faker = new Faker();
        String password=faker.internet().password();
        String confirmPassword=password;
        String username=itestcontext.getAttribute("USERNAME").toString();

        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        EdituserPage edituserPage=new EdituserPage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        waitJVM(30000);

        dashboardPage.useredit2(username);
        waitJVM(30000);
        edituserPage.changepassword(password,confirmPassword);
    }


}
