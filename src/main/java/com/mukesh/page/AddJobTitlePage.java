package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.mukesh.utility.waitHelper.waitJVM;

public class AddJobTitlePage extends CommonToAllPages {

    WebDriver driver;

    public AddJobTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    private By addjobtitleButton=By.xpath("//button[contains(@class, 'oxd-button') and contains(., 'Add Job Title')]");
    private By jobTitle=By.xpath("//input[@id='add_job_title_jobTitleName']");
    private By savebutton=By.xpath("//button[contains(., 'Save')]");
    private By tablerow=By.cssSelector(".oxd-table-body .oxd-table-row");

    public List<String> getdata() {

        List<String> roles = new ArrayList<>();
        List<WebElement> roleList = DriverManager.getDriver().findElements(tablerow);

        for (WebElement row : roleList) {

            String roleName = row.findElement(By.cssSelector(".oxd-table-cell:nth-child(2)")).getText();
            roles.add(roleName);
        }
        return roles;
    }
    public boolean addJobTitle(String jobtitle)
    {
        click(addjobtitleButton);
        waitJVM(1500);
        enterText(jobTitle,jobtitle);
        click(savebutton);
        waitJVM(3000);
        List<String> roles=getdata();
        boolean found=roles.contains(jobtitle);
        return found;
    }
}
