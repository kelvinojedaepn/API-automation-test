package com.nttdata.glue;

import com.nttdata.steps.MascotaStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MascotaStepDef {
    @Steps
    MascotaStep mascota;

    @When("consulto la tienda de mascota con  IDMASCOTA {int}")
    public void consultoLaTiendaDeMascotaConIDMASCOTA(int idMascota) {
        mascota.consultar(idMascota);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCode) {
        mascota.validarStatusCode(statusCode);
    }

    @And("valido mensaje sea {string}")
    public void validoMensajeSea(String petNotFound) {
        mascota.validarMensajeSea(petNotFound);
    }
}
