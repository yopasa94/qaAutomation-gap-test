package test;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.*;

public class vacationManagmentSteps {

	Login loginPage;
	Home homePage;
	UserCreation userCreationPage;
	UserList userList;

	@After
	public void tearDown(){
		loginPage.getChromeDriver().close();
	}

    public vacationManagmentSteps() {
		this.loginPage= new Login();
		this.homePage= new Home(loginPage.getChromeDriver());
		this.userCreationPage= new UserCreation(loginPage.getChromeDriver());
		this.userList= new UserList(loginPage.getChromeDriver());
    }

    @Given("^open browser \"([^\"]*)\"$")
	public void open_browser(String browser) throws Throwable {
		//TO_DO
	}

	@When("^navigate to url \"([^\"]*)\"$")
	public void navigate_to_url(String url) throws Throwable {
		this.loginPage.getChromeDriver().navigate().to(url);

	}

	@When("^login_to_application with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void login_to_application_with_user_and_password(String user, String password) throws Throwable {
		loginPage.performLogin(user, password);
	}

	@Then("^the page loads all the elements$")
	public void the_page_loads_all_the_elements() throws Throwable {
		homePage.validateLoginElements();
	}

	@When("^a new user is created with the info$")
	public void a_new_user_is_created_with_the_info(DataTable data) throws Throwable {
		this.homePage.createEmployee.click();
		this.userCreationPage.createUser(data);
	}

	@Then("^the new user appears in the users table$")
	public void the_new_user_appears_in_the_users_table() throws Throwable {
		this.userList.tabListButton.click();
		int rowPosisition=this.userList.findByLeaderName("Silvio Yopasa");
		Assert.assertTrue(this.userList.listRows.get(rowPosisition).isDisplayed());
		Assert.assertTrue(this.userList.listRows.get(rowPosisition).getText().contains("James Smith"));
	}

	@When("^a user is deleted by id lead name \"([^\"]*)\"$")
	public void a_user_is_deleted_by_lead_name(String leaderName) throws Throwable {
		int rowPosition = this.userList.findByLeaderName(leaderName);
		this.userList.deleteChildNodes.get(rowPosition).click();
		loginPage.getChromeDriver().switchTo().alert().accept();
	}

	@Then("^the user does not appear in the users table$")
	public void the_user_does_not_appear_in_the_users_table() throws Throwable {
		int rowPosition = 0;
		rowPosition = this.userList.findByLeaderName("Silvio Yopasa");
		Assert.assertNotEquals("There is a similar user in the list",-1, rowPosition );
	}
}