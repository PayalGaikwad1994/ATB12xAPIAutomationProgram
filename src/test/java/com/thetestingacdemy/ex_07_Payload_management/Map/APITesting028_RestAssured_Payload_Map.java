package com.thetestingacdemy.ex_07_Payload_management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting028_RestAssured_Payload_Map {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {

//        String payload_POST = "{\n" +
//                "    \"firstname\" : \"Pramod\",\n" +
//                "    \"lastname\" : \"Dutta\",\n" +
//                "    \"totalprice\" : 123,\n" +
//                "    \"depositpaid\" : false,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Lunch\"\n" +
//                "}";

        // Hashmap -> key and value pair
        // Parent Hashmap ->  key and value , Child Hashmap

        Map<String,Object> jsonBodyUsingMap=new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Pramod");
        jsonBodyUsingMap.put("lastname","Dutta");
        jsonBodyUsingMap.put("totalprice","123");
        jsonBodyUsingMap.put("depositpaid",false);

        Map<String,Object> bookingDates=new LinkedHashMap<>();
        bookingDates.put("checkin","2024-01-01");
        bookingDates.put("checkout","2024-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDates);
        jsonBodyUsingMap.put("additionalneeds","Lunch");

        System.out.println(jsonBodyUsingMap);

        // Hashmap -> JSON? or ClaSS TO json
        // 1. Gson
        // 2. Jackson API
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Dutta"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));
        validatableResponse.body("bookingid", Matchers.notNullValue());
    }
}
