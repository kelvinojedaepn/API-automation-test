package com.nttdata.glue;

import com.nttdata.steps.StoreOrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StoreOrderStepDef {
    @Steps
    StoreOrderStep storeOrder;

    @Given("la URL base es {string}")
    public void laURLBaseEs(String baseUrl) {
        storeOrder.setBaseUrl(baseUrl);
    }

    @And("los datos del pedido son:")
    public void losDatosDelPedidoSon(io.cucumber.datatable.DataTable dataTable) {
        storeOrder.setOrderData(dataTable);
    }

    @When("hago una solicitud POST a {string} con los datos del pedido")
    public void hagoUnaSolicitudPOSTAConLosDatosDelPedido(String path) {
        storeOrder.createOrder(path);
    }

    @Then("el código de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        storeOrder.validateStatusCode(statusCode);
    }

    @And("el body del response contiene el petId {int}")
    public void elBodyDelResponseContieneElPetId(int petId) {
        storeOrder.validatePetId(petId);
    }

    @And("el body del response contiene la cantidad {int}")
    public void elBodyDelResponseContieneLaCantidad(int quantity) {
        storeOrder.validateQuantity(quantity);
    }

    @When("hago una solicitud GET a {string}")
    public void hagoUnaSolicitudGETA(String path) {
        storeOrder.getOrder(path);
    }
}