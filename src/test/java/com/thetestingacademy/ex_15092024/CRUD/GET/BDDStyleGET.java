package com.thetestingacademy.ex_15092024.CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {
        // GET Request - https://api.zippopotam.us/IN/560037
        // URL
        // HEADER ?
        // GET Method
        // base url = https://api.zippopotam.us
        // base path = /IN/560037
        // PayLoad - ? NO
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 = No

        // Verification
        // Status Code
        // Response Body
        // Time, Headers, Cookies

        // Gherkin -> Given, When, Then -> Style ->

        // BDD - Framework different - Gherkins Syntax - (given, when, then)
        // Non BDD and still Gherkin syntax (using Classes)


        // given ->
        // URL
        // HEADER ?, Cookies
        // base url = https://api.zippopotam.us
        // base path = /IN/560037
        // PayLoad - ? NO
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 = No

        // When ->
        // PayLoad - ? NO/YES - JSON.XML -> String, Hashmap, Object class
        // GET Method

        // Then()
        // Response Validation
        // Status Code
        // Response Body
        // Time, Headers, Cookies

        test1();
        test2();
    }

    private static void test1() {
        RestAssured
                .given().relaxedHTTPSValidation()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560037")
                .when()
                .log().all().get()
                .then().log().all().statusCode(200);
    }

    private static void test2() {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/-1")
                .when()
                .log().all().get()
                .then().log().all().statusCode(404);
    }
}
