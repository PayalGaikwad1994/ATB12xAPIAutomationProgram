package com.thetestingacdemy.ex_01_RA_Concepts;

import io.restassured.RestAssured;

public class Practice_RA_Concepts {
    public static void main(String[] args) {
        RestAssured.given()
                .baseUri("https://api.postalpincode.in/pincode/411062")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);


    }
}
