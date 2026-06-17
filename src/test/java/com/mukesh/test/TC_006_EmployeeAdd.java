package com.mukesh.test;

import com.github.javafaker.Faker;
import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.AddEmployeePage;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_006_EmployeeAdd extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_006_EmployeeAdd.class);

    @Description("Verify To add employee with ESS role and enable")
    @Test(priority = 1)

    public void addEmployee(ITestContext iTestContext)
    {
        Faker  faker = new Faker();
        String ename=faker.name().firstName();

        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        AddEmployeePage addEmployeePage=new AddEmployeePage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickEmployeeManagement();
        dashboardPage.clickAddEmployee();

        addEmployeePage.addEmployee(ename,"Mukesh","Dhage","2026","May","10","India Office","PAN CARD","765432","1987","June","29","Single","Male","Indian","DL9876","2027","May","20","Onboarding Template for All Locations");
        String msg=addEmployeePage.getactiveStatus();
        Assert.assertEquals(msg,"Active");

        String fullname=addEmployeePage.getfullname();
        System.out.println(fullname);
        iTestContext.setAttribute("FullName",fullname);
    }
}
