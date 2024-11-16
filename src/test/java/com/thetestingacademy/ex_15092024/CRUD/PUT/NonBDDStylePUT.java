package com.thetestingacademy.ex_15092024.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStylePUT {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    // 6118
    // Token - Token?
    // Payload:
    //    {
    //        "firstname" : "Shubham",
    //        "lastname" : "Khera",
    //        "totalprice" : 777,
    //        "depositpaid" : true,
    //        "bookingdates" : {
    //            "checkin" : "2018-01-01",
    //            "checkout" : "2019-01-01"
    //        },
    //        "additionalneeds" : "Breakfast"
    //    }

    // POST - Auth - Token
    // POST - Booking ID
    // PUT - Token and BookingID

    @Test
    public void test_put_positive_tc() {
        // POST - Auth - token

        String token = "0d5c10c0a1064ce";
        String bookingid = "4196";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-05\",\n" +
                "        \"checkout\" : \"2024-01-06\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token=", token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}
