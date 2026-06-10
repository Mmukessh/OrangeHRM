package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.mukesh.utility.waitHelper.checkVisibility;
import static com.mukesh.utility.waitHelper.waitJVM;

public class TC_002_LoginInvalid extends BaseTest {

    @Description("Verify with valid username and invalid password")
    @Test

    public void testInvalidPassword(){
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        loginPage.Login(propertyReader.readKeys("username"),propertyReader.readKeys("invalidpassword"));
        waitJVM(5000);
        String msg=loginPage.getmsg();
        Assert.assertEquals(msg,"Invalid Credentials");
    }
}
