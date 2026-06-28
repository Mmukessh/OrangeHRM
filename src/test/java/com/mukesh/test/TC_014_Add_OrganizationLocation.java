package com.mukesh.test;

import com.github.javafaker.Faker;
import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.AddLocation;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_014_Add_OrganizationLocation extends BaseTest {

    @Description("Add Organization Location")
    @Test

    public void TC_14_addOrganizationLocation()
    {
        Faker faker=new Faker();
        String name=faker.lorem().characters(5);
        String city=faker.address().cityName();
        String zip=faker.address().zipCode();

        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        AddLocation addLocation=new AddLocation(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickHRAdministration();
        dashboardPage.clickorganizationLocation();
        //waitJVM(3000);
       boolean result= addLocation.addlocation(name,"India","(GMT-12:00) GMT-12:00",city,zip);
       String data= String.valueOf(addLocation.getdata());
        System.out.println(data);
        Assert.assertEquals(result,true);
    }
}
