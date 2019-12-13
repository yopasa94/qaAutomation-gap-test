package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePage{

    @FindBy(id="user_email")
    WebElement user;
    @FindBy(id="user_password")
    WebElement password;
    @FindBy(className = "submit")
    WebElement singInButton;

    public Login(){
        PageFactory.initElements(this.getChromeDriver(), this);
    }

    public void performLogin(String user, String password) {
        this.user.sendKeys(user);
        this.password.sendKeys(password);
        this.singInButton.click();
    }

}
