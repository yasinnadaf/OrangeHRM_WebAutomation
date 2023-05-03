package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "txtUsername")
    WebElement userName;

    @FindBy(id = "txtPassword")
    WebElement pass;

    @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']/div[@id='divLogin']/div[2]/div[1]/form[1]/div[3]/button[1]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String loginToPage() throws InterruptedException {
        userName.sendKeys("Admin");
        Thread.sleep(500);
        pass.sendKeys("L@UwVxzE73");
        Thread.sleep(500);
        loginBtn.click();
        String dashboardTitle = driver.getTitle();
        return dashboardTitle;
    }
}
