package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.mukesh.utility.waitHelper.checkVisibility;
import static com.mukesh.utility.waitHelper.getTextWithWait;

public class LoginPage extends CommonToAllPages {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userName= By.id("txtUsername");
    private By passWord=By.id("txtPassword");
    private By clickSubmit=By.xpath("//button[@type='submit']");
    private By toastMessage = By.xpath("//div[@class='toast-message']");
    private By usernameError= By.xpath("//span[@id='txtUsername-error']");
    private By passwordError=By.xpath("//span[@id='txtPassword-error']");

    public void Login(String username,String password)
    {
        openURL();
        enterText(userName,username);
        enterText(passWord,password);
        click(clickSubmit);

    }

    public void InvalidLoginCredentials(String username,String password)
    {
        openURL();
        enterText(userName,username);
        enterText(passWord,password);
        click(clickSubmit);

    }

    public String getmsg()
    {
       // WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        return getTextWithWait(toastMessage);//wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage)).getText();
    }

    public String getuserNameError()

    {
        return getTextWithWait(usernameError);
    }
    public String getpasswordError()
    {
        return getTextWithWait(passwordError);
    }
}
