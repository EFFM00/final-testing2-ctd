package com.elenaffm.finaltesting.Backend;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class BackTest {


    String username = "AnGomez43522";
    String password = "passTest12350";

    @Test
    public void Test01() {

        String URL = "https://parabank.parasoft.com/parabank/register.htm";

        Response response = get(URL);

        Assertions.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void Test02() {

        Integer customerId = 12878;
        Integer newAccountType = 1;
        Integer fromAccountId = 13899;


        given().
            queryParam("customerId", customerId).
            queryParam("newAccountType", newAccountType).
            queryParam("fromAccountId", fromAccountId).
            auth().basic(username, password).
        when().
            post("https://parabank.parasoft.com/parabank/createAccount").
        then().
            statusCode(200).and().log().all();
    }


    @Test
    public void Test03() {

        String URL = "https://parabank.parasoft.com/parabank/overview.htm";

        given().
            auth().basic(username, password).
        when().
            get(URL).
        then().
            statusCode(200).and().log().all();

    }


}
