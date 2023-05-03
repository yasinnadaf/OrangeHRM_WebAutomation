package com.bridgelabz.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    WebDriver driver;
    public static Logger log = Logger.getLogger(BaseClass.class.getName());

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://administrato-trials77.orangehrmlive.com/auth/login");
        log.info("Chrome browser started successfully");
    }

    public void closeBrowser(){
        driver.close();
    }

}
