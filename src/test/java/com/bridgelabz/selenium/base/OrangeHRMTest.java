package com.bridgelabz.selenium.base;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddUser;
import pages.DashboardPage;
import pages.LoginPage;

public class OrangeHRMTest extends BaseClass{
    LoginPage login;
    DashboardPage dashboard;
    AddUser addingUser;

    @BeforeTest
    public void init(){
        setUp();
        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
        addingUser = new AddUser(driver);
    }

    @Test
    public void loginToHrmApp_Successfully() throws InterruptedException {
        String dashboardTitle = login.loginToPage();
        Assert.assertEquals("Employee Management", dashboardTitle );
    }

    @Test
    public void dashboardHrmApp() throws InterruptedException {
        loginToHrmApp_Successfully();
        dashboard.dashboardSuccess();
        addingUser.addUser();
        Thread.sleep(4000);
    }

    @AfterTest
    public void tearDown(){
        closeBrowser();
        log.info("Browser closed successfully");
    }
}
