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
import java.util.ArrayList;
import java.util.List;

import static com.mukesh.utility.waitHelper.*;

public class DashboardPage extends CommonToAllPages {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutButton=By.id("navbar-logout");
    private By employeeManagementLeft=By.xpath("//span[@data-tooltip='Employee Management']");
    private By hr_Administration=By.xpath("//span[@data-tooltip='HR Administration']");
    private By addEmployeeButton=By.xpath("//a[@id='addEmployeeButton']");
    private By addUserButton=By.xpath("//div[@data-tooltip='Add User']");
    private By filterbutton=By.xpath("//a[@data-tooltip='Filter']");
    private By tablerow=By.xpath("//table/tbody/tr");

    //

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

    public void clickHRAdministration()
    {
        checkvisibilityTclick(hr_Administration);
        waitJVM(100000);
    }

    public void addUser()
    {
        checkvisibilityTclick(addUserButton);
    }

    public List<String> getuserdata()
    {
        List<String> users=new ArrayList<>();
        List<WebElement> userlist=DriverManager.getDriver().findElements(tablerow);

        for(WebElement row:userlist)
        {
            String user=row.getText();

            users.add(user);
        }
        return users;
    }

    public List<String> getusername()
    {
        List<String> users=new ArrayList<>();
        List<WebElement> userlist=DriverManager.getDriver().findElements(tablerow);

        for(WebElement row:userlist)
        {
            String user=row.findElement(By.xpath("./td[4]")).getText();
            users.add(user);
        }
            return users;
    }

    public String userstatus(String employeename)
    {
        List<WebElement> userlist=DriverManager.getDriver().findElements(tablerow);
        for(WebElement row:userlist)
        {
            String user=row.findElement(By.xpath("./td[2]")).getText();

            if(user.equals(employeename))
            {
                String status=row.findElement(By.xpath("./td[5]")).getText();
                return status;
            }
        }

        return null;
    }


}
