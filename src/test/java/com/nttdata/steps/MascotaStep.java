package com.nttdata.steps;


import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class MascotaStep {

    private String URL_BASE= "https://petstore.swagger.io/v2/";


    public void consultar(int idMascota) {
        System.out.println("Consultando Mascota");

        SerenityRest.given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                .get("pet/"+String.valueOf(idMascota))
//                .get("pet/"+idMascota2)
                .then()
                .log().all()
                ;
    }


    public void validarStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().getStatusCode());
    }

    public void validarMensajeSea(String petNotFound) {
        String lastResponse = SerenityRest.lastResponse().getBody().path("message");
        System.out.println("Las response: "+lastResponse);
    }
}
