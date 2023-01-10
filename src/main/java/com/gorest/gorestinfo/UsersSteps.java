package com.gorest.gorestinfo;


import com.gorest.constants.EndPoints;
import com.gorest.model.UserPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


public class UsersSteps {

    static final String token = "Bearer f18701fb30de652b28f69e533949d14bf5a6aa48784ef8a29bf6b3871c99e766";
    private int userId;

    @Step("Creating User with Name :{0}, email : {1}, gender : {2} and status: {3}")
    public ValidatableResponse createUser(String name, String email, String gender, String status) {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .body(userPojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then();

    }

    @Step("Getting user ID : {0}")
    public ValidatableResponse getUserById(int userId) {
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .pathParam("id", userId)
                .when()
                .get(EndPoints.GET_USER)
                .then().log().all();

    }


    @Step("Updating User with Name :{0}, email : {1}, gender : {2} and status: {3}")
    public ValidatableResponse updateUser(int userId, String name, String email, String gender, String status) {

        UserPojo userPojo = new UserPojo();

        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .pathParam("id", userId)
                .body(userPojo)
                .when()
                .put(EndPoints.UPDATE_USER)
                .then().log().all();
    }

    @Step("Deleting student information with userId: {0}")
    public ValidatableResponse deleteUser(int userId) {

        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .pathParam("id", userId)
                .when()
                .delete(EndPoints.DELETE_USER)
                .then().log().all();

    }

    @Step("Getting user ID : {0}")
    public ValidatableResponse getUserByName(String name) {
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .pathParam("name", name)
                .when()
                .get(EndPoints.GET_USER_NAME)
                .then().log().all();

    }

}
