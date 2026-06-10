package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.AddEmployeePage;
import com.mukesh.page.DashboardPage;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_006_EmployeeAdd extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_006_EmployeeAdd.class);

    @Description("Verify To add employee with ESS role and enable")
    @Test

    public void addEmployee()
    {
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        AddEmployeePage addEmployeePage=new AddEmployeePage(DriverManager.getDriver());

        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("password"));
        dashboardPage.clickEmployeeManagement();
        dashboardPage.clickAddEmployee();

        addEmployeePage.addEmployee("Guru","Mukesh","Dhage","2026","June","10","India Office","PAN CARD","765432");

    }
}
