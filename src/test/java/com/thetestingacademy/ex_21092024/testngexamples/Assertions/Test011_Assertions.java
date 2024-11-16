package com.thetestingacademy.ex_21092024.testngexamples.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Test011_Assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;


    @Test
    public void test_post(){
        String payload_POST= "{\n" +
                "    \"firstname\" : \"Shubham\",\n" +
                "    \"lastname\" : \"Khera\",\n" +
                "    \"totalprice\" : 777,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured Default - Hamcrest
        validatableResponse.body("booking.firstname", Matchers.equalTo("Shubham"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Khera"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));

        //TestNG Assertion
            // SoftAssert vs HardAssert
            // HardAsssert - This means that if any assertion fails, the remaining statement

        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
//        Assert.assertNotNull(bookingId);
//        Assert.assertEquals(firstname, "Shubham");

        //AssertJ Assertion
        assertThat(bookingId).isNotNull().isNotNegative().isPositive();
        assertThat(firstname).isEqualTo("Shubham").isNotEmpty().isNotBlank();





//        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);

    }
}
