package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.mukesh.utility.Dropdown.adminRole;
import static com.mukesh.utility.waitHelper.refresgpage;
import static com.mukesh.utility.waitHelper.waitJVM;

public class EdituserPage extends CommonToAllPages {

    WebDriver driver;

    public EdituserPage(WebDriver driver) {
        this.driver = driver;
    }

    private By adminroledropdown=By.xpath("//div[@id='adminrole']");
    private By savebutton=By.xpath("//button[@id='modal-save-button']");
    private By disableradiobutton=By.xpath("//label[@for='status_0']");
    private By changePass_checkbox=By.xpath("//label[@for='changepassword']");
    private By confirmPassword=By.xpath("//input[@id='confirmpassword']");
    private By password=By.xpath("//input[@id='password']");


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

    public void changepassword(String Changepassword,String confirmChangePassword)
    {
        click(changePass_checkbox);
        enterText(password,Changepassword);
        enterText(confirmPassword,confirmChangePassword);
        waitJVM(4000);
        click(savebutton);
    }
}
