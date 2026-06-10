package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_LoginInvalidUsername extends BaseTest {

    @Description("Verify with invalid username and valid password")
    @Test

    public void testInvalidUsername()
    {
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        loginPage.Login(propertyReader.readKeys("invaliusername"),propertyReader.readKeys("password"));
        String msg=loginPage.getmsg();
        Assert.assertEquals(msg,"Please type the word exactly as it appears in the image.");
    }
}
