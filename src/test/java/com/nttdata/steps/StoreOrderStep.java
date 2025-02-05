package com.nttdata.steps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class StoreOrderStep {
    private static String baseUrl;
    private String jsonBody;

    public void setBaseUrl(String url) {
        baseUrl = url;
    }

    public void setOrderData(DataTable dataTable) {
        String petId = dataTable.cell(1, 0);
        String quantity = dataTable.cell(1, 1);
        String shipDate = dataTable.cell(1, 2);
        String status = dataTable.cell(1, 3);
        String complete = dataTable.cell(1, 4);

        jsonBody = "{\n" +
                "  \"petId\": " + petId + ",\n" +
                "  \"quantity\": " + quantity + ",\n" +
                "  \"shipDate\": \"" + shipDate + "\",\n" +
                "  \"status\": \"" + status + "\",\n" +
                "  \"complete\": " + complete + "\n" +
                "}";
    }

    public void createOrder(String path) {
        SerenityRest.given()
                .baseUri(baseUrl)
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post(path)
                .then()
                .log().all();
    }

    public void validateStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().getStatusCode());
    }

    public void validatePetId(int petId) {
        Assert.assertEquals(petId, SerenityRest.lastResponse().jsonPath().getInt("petId"));
    }

    public void validateQuantity(int quantity) {
        Assert.assertEquals(quantity, SerenityRest.lastResponse().jsonPath().getInt("quantity"));
    }

    public void getOrder(String path) {
        SerenityRest.given()
                .baseUri(baseUrl)
                .relaxedHTTPSValidation()
                .when()
                .get(path)
                .then()
                .log().all();
    }

}