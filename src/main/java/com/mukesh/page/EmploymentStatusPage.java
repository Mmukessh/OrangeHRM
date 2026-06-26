package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.mukesh.utility.waitHelper.waitJVM;

public class EmploymentStatusPage extends CommonToAllPages {

    WebDriver driver;

    public EmploymentStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addStatus= By.xpath("//div[@data-tooltip='Add Employment Status']//a[contains(@class, 'btn-floating')]");
    private By addname=By.xpath("//div[@id='modal1'][1]//input[@id='name']");
    private By saveButton=By.xpath("(//a[contains(@class, 'primary-btn') and contains(text(), 'Save')])[1]");
    private By tablerRow=By.cssSelector(".list-container table tbody td");
    private By status=By.xpath("//div[contains(@class, 'list-container')]//tbody/tr/td[2]");

    public List<String> getdata() {

        List<String> roles = new ArrayList<>();
        List<WebElement> roleList = DriverManager.getDriver().findElements(tablerRow);

        for (WebElement row : roleList) {

            String roleName = row.findElement(status).getText();
            roles.add(roleName);
        }
        return roles;
    }


    public boolean addEmploymentStatus(String name)
    {
        click(addStatus);
        enterText(addname,name);
        click(saveButton);
        waitJVM(3000);
        List<String> roles=getdata();
        boolean found=roles.contains(name);
        return found;


    }
}
