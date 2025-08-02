package com.thetestingacdemy.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NONBDD_STYLE {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    String pincode;

    @Test
    public void test_GET_NON_BDD_STYLE(){
        pincode = "560048";

        // Divide them into 3 parts - R
        // given() - Part
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //when() - part2
        response=r.when().log().all().get();
        System.out.println(response.asString());

        //then() - Part3
        vr= response.then().log().all();
        vr.statusCode(200);

    }

    @Test
    public void test_GET_NON_BDD_STYLE_NEGATIVE_TC(){
        pincode = "@";

        // Divide them into 3 parts - R
        // given() - Part
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //when() - part2
        response=r.when().log().all().get();
        System.out.println(response.asString());

        //then() - Part3
        vr= response.then().log().all();
        vr.statusCode(404);

    }
}
