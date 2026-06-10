package com.mukesh.base;

import com.mukesh.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

@BeforeMethod

    public void setup()
{
    DriverManager.init();
}

@AfterMethod
    public void teatDown()
{
    DriverManager.tearDown();
}
}
