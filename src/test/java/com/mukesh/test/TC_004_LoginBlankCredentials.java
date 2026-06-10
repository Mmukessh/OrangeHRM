package com.mukesh.test;

import com.mukesh.base.BaseTest;
import com.mukesh.driver.DriverManager;
import com.mukesh.page.LoginPage;
import com.mukesh.utility.propertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_LoginBlankCredentials extends BaseTest {

    @Description("Verify with blank username and password")
    @Test

    public void testWithBlankCredentials()
    {
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        loginPage.Login(propertyReader.readKeys("blankusername"),propertyReader.readKeys("blankpassword"));
        String userErrormsg=loginPage.getuserNameError();
        String passwordErrormsg=loginPage.getpasswordError();
        Assert.assertEquals(userErrormsg,"Username cannot be empty");
        Assert.assertEquals(passwordErrormsg,"Password cannot be empty");
    }
}
