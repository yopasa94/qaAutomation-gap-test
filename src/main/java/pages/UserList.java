package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.IntStream;

public class UserList extends BasePage{
    @FindBy(css = "table tr:not(:first-child)")
    public List<WebElement> listRows;

    @FindBy(xpath = "//table //a [contains(text(), 'Delete')]")
    public List<WebElement> deleteChildNodes;

    @FindBy(xpath = "li[@class='selected']/a[contains(text(), Employee)]")
    public WebElement tabListButton;

    public UserList(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public int findByLeaderName(String leaderName){
        int position=-1;
        try {
            position = IntStream.range(0, listRows.size())
                    .filter((index) -> listRows.get(index).getText().contains(leaderName))
                    .findFirst().getAsInt();
        }catch(Exception e){
            position=-1;
        }
        return position;
    }

    public void removeUser(int id){

    }
}
