package com.rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.apache.commons.codec.digest.UnixCrypt.body;
import static org.hamcrest.Matchers.*;

public class Test {

    @org.testng.annotations.Test
    public void getResponseBody(){
        Response res = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key","PMAK-63e21081198d1d4236a8eab2-443b343e131083b06bd425ba2fa3e54d4a").
                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().statusCode(200).extract().response();
        System.out.println("Response body is: " + res.asString());

        //System.out.println("Workspace Name: "+ res.path("workspaces[0].name"));

        //System.out.println("Workspace Name: "+ JsonPath.getString("workspaces[0].name"));
        //System.out.println("Workspace Name: "+ JsonPath.from(res).getString("workspaces[0].name"));

        //String res

    }

    @org.testng.annotations.Test
    public void validate_First_Test_Case(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key","PMAK-63e21081198d1d4236a8eab2-443b343e131083b06bd425ba2fa3e54d4a").
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().statusCode(200)

        //Validating how many workspaces created in the DB
        //.body("workspaces.size()", equalTo(2))
        //.and().body("workspaces[0].name", equalTo("My Workspace"));

                //.body("workspaces.name", contains("My Workspace 2", "My Workspace"));
                //.body("workspaces.name", containsInAnyOrder("My Workspace 2", "My Workspace"));
                //.body("workspaces.name", is(not(empty())))
                .body("workspaces", hasSize(2))
                .body("workspaces[1]", hasKey("id"))
                .body("workspaces[1]", hasValue("My Workspace 2"))
                .body("workspaces[1]", hasEntry("name", "My Workspace 2"));

    }
}
