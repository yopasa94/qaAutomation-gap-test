package pages;

import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends BasePage {

    @FindBy(css = "div #logo")
    WebElement logo;
    @FindBy(css = "p.flash_notice")
    WebElement bannerLoggedUser;
    @FindBy(css = "ul#user_information")
    WebElement loggedUser;
    @FindBy(xpath =  "//a[contains(text(),'Create')]" )
    public WebElement createEmployee;

    public Home(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateLoginElements() {
        Assert.assertTrue(logo.isDisplayed());
        Assert.assertTrue( bannerLoggedUser.isDisplayed());
        Assert.assertTrue( loggedUser.isDisplayed());
    }


}
