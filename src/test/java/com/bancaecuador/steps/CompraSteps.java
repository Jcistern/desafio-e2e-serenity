package com.bancaecuador.steps;

import com.bancaecuador.actions.CompraActions;
import com.bancaecuador.data.TestData;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class CompraSteps {
    @Steps
    CompraActions acciones;

    TestData datos = TestData.cargar();

    @Given("el usuario está en la página de login")
    public void el_usuario_está_en_la_página_de_login() {
        acciones.abrirPaginaLogin();
    }

    @When("ingresa las credenciales desde el archivo de datos")
    public void ingresa_las_credenciales_desde_el_archivo_de_datos() {
        acciones.ingresarCredenciales(datos.getUsuario(), datos.getContrasena());
    }

    @And("ordena los productos por precio de menor a mayor")
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
