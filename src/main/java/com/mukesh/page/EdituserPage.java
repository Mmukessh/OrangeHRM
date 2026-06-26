package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.mukesh.utility.Dropdown.adminRole;
import static com.mukesh.utility.waitHelper.refresgpage;

public class EdituserPage extends CommonToAllPages {

    WebDriver driver;

    public EdituserPage(WebDriver driver) {
        this.driver = driver;
    }

    private By adminroledropdown=By.xpath("//div[@id='adminrole']");
    private By savebutton=By.xpath("//button[@id='modal-save-button']");
    private By disableradiobutton=By.xpath("//label[@for='status_0']");

    public void editrole(String role){

        adminRole(adminroledropdown,role);
        click(savebutton);
    }

    public void disablebutton()
    {
        click(disableradiobutton);
        click(savebutton);
        refresgpage();
    }
}
