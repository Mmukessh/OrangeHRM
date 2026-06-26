package com.mukesh.test;

import com.github.javafaker.Faker;
import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.AddJobTitlePage;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_011_AddJobTitle extends BaseTest {

    @Description("Add new job title")
    @Test

    public void addNewJobTitle() {

        Faker faker = new Faker();
        String role=faker.lorem().characters(5);

        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        AddJobTitlePage addJobTitlePage=new AddJobTitlePage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickHRAdministration();
        dashboardPage.clickjobtitle();
        boolean result=addJobTitlePage.addJobTitle(role);

        Assert.assertEquals(result,true);


    }
}
