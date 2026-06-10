package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.mukesh.utility.waitHelper.*;

public class DashboardPage extends CommonToAllPages {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutButton=By.id("navbar-logout");
    private By employeeManagementLeft=By.xpath("//span[@data-tooltip='Employee Management']");
    private By addEmployeeButton=By.xpath("//a[@id='addEmployeeButton']");

    public void clickonLogout()
    {
        click(logoutButton);

    }

    public void clickEmployeeManagement()
    {
        click(employeeManagementLeft);
        waitJVM(15000);
    }

    public void clickAddEmployee()
    {
        checkvisibilityTclick(addEmployeeButton);
        waitJVM(15000);
    }


}
