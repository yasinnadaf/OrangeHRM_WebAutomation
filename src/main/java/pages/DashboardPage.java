package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    @CacheLookup
    @FindBy (xpath = "//i[contains(text(),'oxd_home_menu')]")
    WebElement homeBtn;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean dashboardSuccess() throws InterruptedException {
        Boolean f = homeBtn.isDisplayed();
        return f;
    }
}

