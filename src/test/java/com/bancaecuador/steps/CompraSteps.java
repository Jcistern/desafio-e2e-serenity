package com.bancaecuador.steps;

import com.bancaecuador.actions.CompraActions;
import com.bancaecuador.data.TestData;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.actors.*;
import net.serenitybdd.screenplay.Actor;
import com.bancaecuador.tasks.Login;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CompraSteps {
    @Steps
    CompraActions acciones;

    TestData datos = TestData.cargar();

    @Managed
    WebDriver driver;

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Juan").can(BrowseTheWeb.with(driver));
    }

    @Given("el usuario inicia sesión en SauceDemo")
    public void el_usuario_inicia_sesion_en_SauceDemo() {
        Actor juan = OnStage.theActorCalled("Juan");
        juan.attemptsTo(Login.con(datos.getUrl(), datos.getUsuario(),datos.getContrasena()));
    }

    @When("ordena los productos por precio de menor a mayor")
    public void ordena_los_productos_por_precio_de_menor_a_mayor() {
        acciones.ordenarPrecioAscendente();
    }

    @And("agrega el primer producto al carrito")
    public void agrega_el_primer_producto_al_carrito() {
        acciones.agregarPrimerProducto();
    }

    @And("procede al carrito y confirma el producto")
    public void procede_al_carrito_y_confirma_el_producto() {
        acciones.irAlCarrito();
        acciones.confirmarProducto();
    }

    @And("completa el checkout con los datos del archivo")
    public void completa_el_checkout_con_los_datos_del_archivo() {
        acciones.completarCheckout(datos.getNombre(), datos.getApellido(), datos.getCodigoPostal());
    }

    @Then("debería ver el mensaje {string}")
    public void verifica_mensaje(String mensaje) {
        acciones.verificarMensaje(mensaje);
    }
}
