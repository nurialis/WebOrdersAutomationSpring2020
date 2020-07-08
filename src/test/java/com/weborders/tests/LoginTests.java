package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test (description = "Just login and verify title")
    public void loginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders","Page title is wrong!");

        //assertion *** usteki ile ayni
     /* String actual = Driver.getDriver().getTitle();
        String expected = "Web Orders";
        Assert.assertEquals(actual, expected, "Page title is wrong!"); */
    }
}
