package com.mukesh.test;

import com.github.javafaker.Faker;
import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.page.ManagePayGradePage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_012_ManageGrade extends BaseTest {

    @Description("Add new pay grade and verfiy added or not")
    @Test

    public void TC_012_ManageGrade() {

        Faker faker = new Faker();
        String name=faker.lorem().characters(5);

        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        ManagePayGradePage managePayGradePage=new ManagePayGradePage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickHRAdministration();
        dashboardPage.clickManageGrade();
        boolean result=  managePayGradePage.managePayGradePage(name);

        Assert.assertEquals(result,true);


    }
}
