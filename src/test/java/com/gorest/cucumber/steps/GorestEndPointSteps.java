package com.gorest.cucumber.steps;

import com.gorest.gorestinfo.UsersSteps;
import com.gorest.utils.TestUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class GorestEndPointSteps {

    static ValidatableResponse response;

    static String name = null;
    static String gender;
    static String email = null;
    static String status;
    static int userId;


    @Steps
    UsersSteps usersSteps;

    @Given("^As a user I create new user$")
    public void asAUserICreateNewUser() {
    }

    @When("^I create a new user by  information name \"([^\"]*)\" email \"([^\"]*)\" gender \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateANewUserByInformationNameEmailGenderStatus(String _name, String _email, String gender, String status)  {
        name = TestUtils.getRandomValue() + _name;
        email = TestUtils.getRandomValue() + _email;
        response = usersSteps.createUser(name, email, gender, status).statusCode(201);
        userId = response.extract().path("id");


    }

    @Then("^I got valid status code$")
    public void iGotValidStatusCode() {
        response.statusCode(201);
    }

    @When("^I get user information$")
    public void iGetUserInformation() {

        response = usersSteps.getUserById(userId);

    }

    @Then("^i verify valid status code$")
    public void iVerifyValidStatusCode() {
        response.statusCode(200);

    }

    @Given("^As a user I update user$")
    public void asAUserIUpdateUser() {
    }

    @When("^Update user details by  the information name \"([^\"]*)\" email \"([^\"]*)\" gender \"([^\"]*)\" status \"([^\"]*)\"$")
    public void updateUserDetailsByTheInformationNameEmailGenderStatus(String _name, String _email, String gender, String status) {
        name = name + "_updated";

        response = usersSteps.updateUser(userId, name, email, gender, status).statusCode(200);
    }
    @Then("^i verify code$")
    public void iVerifyCode() {
        response.statusCode(200);
    }



    @When("^i deleted user successfully$")
    public void iDeletedUserSuccessfully() {
        response = usersSteps.deleteUser(userId);
    }



    @Then("^I get valid code$")
    public void iValidCode() {
        response.statusCode(204);

    }
}
