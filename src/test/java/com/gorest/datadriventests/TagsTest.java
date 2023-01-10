package com.gorest.datadriventests;

import com.gorest.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {
    @WithTag("Userfeature: NEGATIVE")
    @Title("This test will status code 404 when incorrect tag is provided")
    @Test
    public void invalidMethod(){
        SerenityRest.rest()
                .given()
                .when()
                .post("/user")
                .then()
                .statusCode(404)
                .log().all();
    }
    @WithTags({
            @WithTag("Userfeature: SMOKE"),
            @WithTag("Userfeature: POSITIVE")
    })

@Title("This test will verif status code of 200 is returned for GET request")
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();

}
    @WithTags({
            @WithTag("Userfeature:SMOKE"),
            @WithTag("Userfeature:NEGATIVE")
    })

    @Title("This test will provide an error code of 404 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users123")
                .then()
                .statusCode(404)
                .log().all();
    }

}

