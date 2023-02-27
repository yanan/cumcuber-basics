package com.example.cucumber.definition;

import com.example.cucumber.base.BaseUtil;
import com.example.cucumber.transformation.EmailTransform;
import com.example.cucumber.transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Navigate login page");
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        System.out.println("Click login button");
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() {
        System.out.println("The driver is :" + base.StepInfo);
        System.out.println("I should see userform page");
    }

    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable{
        //List<List<String>> data = table.raw();
        //System.out.println("The value is " + data.get(0).get(0).toString());
        //System.out.println("The value is " + data.get(0).get(1).toString());

        //Create an ArrayList
        List<User> users = new ArrayList<User>();

        //Store all the users
        users = table.asList(User.class);

        for (User user:users){
            System.out.println("The username is " + user.username);
            System.out.println("The password is " + user.password);
        }
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {
        System.out.println("Username is : " + username);
        System.out.println("Password is : " + password);
    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) {
        System.out.println("The email address is" + email);
    }

    @And("^I verify the count of my salary digits for CNY (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForCNY(@Transform(SalaryCountTransformer.class) int salary) {
        System.out.println("My salary digits count is :" + salary);
    }

    public class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
