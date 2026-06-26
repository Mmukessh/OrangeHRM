package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.mukesh.utility.waitHelper.waitJVM;

public class ManagePayGradePage extends CommonToAllPages {

    WebDriver driver;

    public ManagePayGradePage(WebDriver driver) {
        this.driver = driver;
    }

    private By addPayGradeButton= By.xpath("//button[@data-testid='add-pay-grade']");
    private By addName=By.xpath("//input[@id='CreatePayGrade_name']");
    private By SaveButton=By.xpath("//button[@type='submit']");
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

    public boolean managePayGradePage(String name){
        click(addPayGradeButton);
        enterText(addName,name);
        click(SaveButton);
        waitJVM(3000);
        List<String> roles=getdata();
        boolean found=roles.contains(name);
        return found;

    }
}
