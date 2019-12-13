package pages;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

enum TableColumns {
    FIRST_NAME(0),
    ID(1),
    DATE(2),
    LEAD_NAME(3);

    private final int columnId;
    private TableColumns(int columnId) {
        this.columnId = columnId;
    }
    public int getValue(){
        return columnId;
    }
}

public class UserCreation {

    WebDriver driver;
    @FindBy(id = "employee_first_name")
    WebElement firstName;
    @FindBy(id = "employee_last_name")
    WebElement lastName;
    @FindBy(id = "employee_email")
    WebElement email;
    @FindBy(id = "employee_identification")
    WebElement id;
    @FindBy(id = "employee_leader_name")
    WebElement leadName;
    @FindBy(xpath = "//select[contains(@id,'employee_start_working_on')]")
    List <WebElement> startWorkingOn;
    @FindBy(css = "input[type=submit]")
    WebElement saveButton;

    public UserCreation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createUser(DataTable userInfo) {
        List <String> datatable=userInfo.raw().get(1);
        String fullName[]= datatable.get(TableColumns.FIRST_NAME.getValue()).split(" ");
        firstName.sendKeys(fullName[0]);
        lastName.sendKeys(fullName[1]);
        id.sendKeys(datatable.get(TableColumns.ID.getValue()));
        leadName.sendKeys(datatable.get(TableColumns.LEAD_NAME.getValue()));
        email.sendKeys("pending@fake.com");

        Select year = new Select(startWorkingOn.get(0));
        Select month = new Select(startWorkingOn.get(1));
        Select day = new Select(startWorkingOn.get(2));
        String date [] =datatable.get(TableColumns.DATE.getValue()).split("-");
        day.selectByValue(date[0]);
        month.selectByValue(date[1].replaceAll("^0+(?!$)",""));
        year.selectByValue(date[2]);
        saveButton.click();
    }
}
