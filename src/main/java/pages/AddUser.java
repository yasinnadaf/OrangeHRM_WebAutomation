package pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUser extends BaseClass {

    WebDriver driver;

    @CacheLookup
    @FindBy(id = "menu_item_81")
    WebElement hRAdmin;

    @CacheLookup
    @FindBy (xpath = "//i[contains(text(),'add')]")
    WebElement clickAdd;

    @FindBy (xpath = "//table/tbody/tr[1]/td[4]")
    WebElement getTableData;

    @FindBy (id = "selectedEmployee_value")
    WebElement empName;

    @FindBy (id = "user_name")
    WebElement userName;

    @FindBy (id = "password")
    WebElement pass;

    @FindBy (id = "confirmpassword")
    WebElement confPass;

    @FindBy (id = "modal-save-button")
    WebElement saveBtn;

    @FindBy (xpath = "//label[contains(text(),'Enabled')]")
    WebElement status;

    public AddUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addUser() throws InterruptedException {
        hRAdmin.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement tableName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
        Boolean flag = tableName.isDisplayed();
        if (flag == Boolean.TRUE){
            Thread.sleep(4000);
            System.out.println("Getting table data: "+getTableData.getText());
            clickAdd.click();
            Thread.sleep(4000);
            Thread.sleep(1000);
            empName.sendKeys("Muhammad Khan");
            Thread.sleep(2000);
            userName.sendKeys("khanSab");
            Thread.sleep(500);
            pass.sendKeys("L@UwVxzE73");
            Thread.sleep(3000);
            confPass.sendKeys("L@UwVxzE73");
            Thread.sleep(500);
            handleDropDown();
            status.click();
            Thread.sleep(3000);
            saveBtn.click();

        }
    }

    public void handleDropDown() throws InterruptedException {
        WebElement adminClick = driver.findElement(By.id("adminrole"));
        Select s = new Select(adminClick);
        s.selectByValue("string:1");
        WebElement clickEss = driver.findElement(By.id("essrole"));
        Select select = new Select(clickEss);
        select.selectByValue("string:2");
        Thread.sleep(1000);
        WebElement supVisorRole = driver.findElement(By.name("supervisorrole"));
        Select slct = new Select(supVisorRole);
        slct.selectByValue("string:63");
        Thread.sleep(500);
    }
}
