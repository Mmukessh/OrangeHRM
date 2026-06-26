package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.driver.DriverManager;
import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.mukesh.utility.Dropdown.adminRole;
import static com.mukesh.utility.Dropdown.manageJobTitle;
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
    private By nextButton=By.xpath("//i[text()='chevron_right']");
    private By filterUsername=By.xpath("//input[@id='systemuser_uname_filter']");
    private By filtersearchButton=By.xpath("//a[contains(text(), 'Search')]");
    private By jobdropdown=By.xpath("//a[@data-automation-id='menu_admin_Job']");
    private By manageJobTitle=By.xpath("//div[@id='top_level_menu_item_menu_item_102']//a[@data-automation-id='menu_admin_viewJobTitleList']");
    private By manageGrade=By.xpath("//div[@id='top_level_menu_item_menu_item_102']//a[@data-automation-id='menu_admin_viewPayGrades']");
    private By employmentStatus=By.xpath("//div[@id='top_level_menu_item_menu_item_102']//a[@data-automation-id='menu_admin_employmentStatus']");
    private By organizationdropdown=By.xpath("//a[@data-automation-id='menu_admin_Organization']");
    private By addorganization=By.xpath("//div[@id='top_level_menu_item_menu_item_108']//a[@data-automation-id='menu_admin_viewLocations']");

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
        waitJVM(40000);
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
            String user=row.findElement(By.xpath("./td[2]")).getText();
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

    public void useredit(String username)
    {

        clickHRAdministration();
        List<WebElement> userlist=DriverManager.getDriver().findElements(tablerow);

        for(WebElement row:userlist)
        {
            String user=row.findElement(By.xpath("./td[2]")).getText();

            if(user.equals(username))
            {
                WebElement editbutton=row.findElement(By.xpath("./td[8]"));
                editbutton.click();
                waitJVM(15000);

               // break;
            }
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                click(nextButton);
        }




    }

    public void useredit1(String username)
    {
        clickHRAdministration();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        boolean userfound = false;

        while (!userfound) {
            // 1. Always re-fetch the list at the start of the loop
            List<WebElement> userlist = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tablerow));

            for (int i = 0; i < userlist.size(); i++) {
                try {
                    // 2. Re-fetch the row by index to avoid staleness within the same page
                    WebElement row = DriverManager.getDriver().findElements(tablerow).get(i);
                    String user = row.findElement(By.xpath("./td[2]")).getText();

                    if (username.equals(user)) {
                        WebElement editbutton = row.findElement(By.xpath("./td[8]"));
                        editbutton.click();
                        userfound = true;
                        break;
                    }
                } catch (StaleElementReferenceException e) {
                    // If table refreshes while iterating, restart the loop for this page
                    i--;
                }
            }

            if (!userfound) {
                WebElement nextBtn = DriverManager.getDriver().findElement(nextButton);

                // 3. Check if 'Next' is disabled before clicking
                if (nextBtn.findElement(By.xpath("./..")).getAttribute("class").contains("disabled")) {
                    break; // Reached last page
                }

                // Scroll and click
                ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
                nextBtn.click();
                waitJVM(10000);
                // 4. CRITICAL: Wait for the table to go "stale" and then reload
                // This ensures we are reading the NEW page data
                wait.until(ExpectedConditions.stalenessOf(userlist.get(0)));
            }
        }
    }

    public void useredit2(String username)
    {
        clickHRAdministration();

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10)
        );

        boolean userfound = false;

        while (!userfound)
        {
            List<WebElement> userlist =
                    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tablerow));


            for (int i = 0; i < userlist.size(); i++)
            {
                try
                {
                    WebElement row =
                            DriverManager.getDriver()
                                    .findElements(tablerow)
                                    .get(i);

                    String user =
                            row.findElement(By.xpath("./td[2]")).getText();


                    if (username.equals(user))
                    {
                        WebElement editbutton =
                                row.findElement(By.xpath("./td[8]"));

                        editbutton.click();

                        userfound = true;
                        break;
                    }

                }
                catch (StaleElementReferenceException e)
                {
                    i--;
                }
            }


            if (!userfound)
            {

                // 🔴 CHANGED CODE START
                List<WebElement> nextButtons =
                        DriverManager.getDriver()
                                .findElements(nextButton);


                if (nextButtons.isEmpty())
                {
                    System.out.println(
                            "User not found : " + username
                    );
                    break;
                }


                WebElement nextBtn = nextButtons.get(0);
                // 🔴 CHANGED CODE END



                // 🔴 CHANGED CODE START
                if (nextBtn.findElement(By.xpath("./.."))
                        .getAttribute("class")
                        .contains("disabled"))
                {

                    System.out.println(
                            "User not found : " + username
                    );

                    break;
                }
                // 🔴 CHANGED CODE END



                ((JavascriptExecutor)DriverManager.getDriver())
                        .executeScript(
                                "arguments[0].scrollIntoView(true);",
                                nextBtn
                        );


                nextBtn.click();

                waitJVM(3000);


                wait.until(
                        ExpectedConditions.stalenessOf(userlist.get(0))
                );
            }
        }


        // 🔴 CHANGED CODE START
        if(!userfound)
        {
            System.out.println(
                    "Final Result: Username "
                            + username
                            + " does not exist"
            );
        }
        // 🔴 CHANGED CODE END
    }

    public String searchByFilter(String username)
    {
        clickHRAdministration();
        click(filterbutton);
        waitJVM(5000);
        enterText(filterUsername, username);
        waitJVM(5000);
        click(filtersearchButton);
        waitJVM(5000);

        WebElement userlist=DriverManager.getDriver().findElement(tablerow);
        String username_table=userlist.findElement(By.xpath("./td[2]")).getText();


      // String username_table= String.valueOf(getusername());

       return username_table;
    }

    public void clickjobtitle()
    {
        clickHRAdministration();
        manageJobTitle(jobdropdown,manageJobTitle);
        waitJVM(3000);

    }

    public void clickManageGrade()
    {
        clickHRAdministration();
        manageJobTitle(jobdropdown,manageGrade);
        waitJVM(3000);

    }
    public void clickemploymentStatus()
    {
        clickHRAdministration();
        manageJobTitle(jobdropdown,employmentStatus);
        waitJVM(3000);

    }

    public void clickorganizationLocation()
    {
        manageJobTitle(organizationdropdown,addorganization);
        waitJVM(3000);
    }

}
