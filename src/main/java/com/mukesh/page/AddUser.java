package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static com.mukesh.utility.Dropdown.adminRole;
import static com.mukesh.utility.Dropdown.selectEmployeeName;
import static com.mukesh.utility.waitHelper.checkvisibilityTclick;
import static com.mukesh.utility.waitHelper.waitJVM;

public class AddUser extends CommonToAllPages {

    WebDriver driver;
    public AddUser(WebDriver driver) {
        this.driver = driver;
    }

    private By employeeName= By.xpath("//input[@id='selectedEmployee_value']");
    private By userName=By.xpath("//input[@id='user_name']");
    private By essRoledropdown=By.xpath("//div[@role='button' and @id='essrole']");
    private By adminRoleDropdown=By.xpath("//div[@id='adminrole']");
    private By supervisorrolerdropdown=By.xpath("//div[@id='supervisorrole']");
    private By adminroledropdown=By.xpath("//div[@id='adminrole']");
    private By confirmPassword=By.xpath("//input[@id='confirmpassword']");
    private By password=By.xpath("//input[@id='password']");
    private By savebutton=By.xpath("//button[@id='modal-save-button']");


    public void adduser(String employeename,String username,String adminrole,String passwoed,String confirmpassword)
    {

        selectEmployeeName(employeeName,employeename);
        enterText(userName,username);
        adminRole(adminRoleDropdown,adminrole);
        enterText(password,passwoed);
        enterText(confirmPassword,confirmpassword);
        waitJVM(10000);
        checkvisibilityTclick(savebutton);
        waitJVM(20000);


    }

    public void editRole(String newRole)
    {
        adminRole(adminRoleDropdown,newRole);
    }



}
