package com.bancaecuador.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class CompraActions extends UIInteractionSteps {

    private static final String BASE_URL = "https://www.saucedemo.com";

    @Step("Abrir página de login")
    public void abrirPaginaLogin() {
        getDriver().manage().window().maximize();
        openAt(BASE_URL);
    }

    public void ingresarCredenciales(String usuario, String contrasena) {
        find(By.id("user-name")).sendKeys(usuario);
        find(By.id("password")).sendKeys(contrasena);
        find(By.id("login-button")).click();
    }

    public void ordenarPrecioAscendente() {
        find(By.cssSelector(".select_container")).click();
        find(By.cssSelector("option[value='lohi']")).click();
    }

    public void agregarPrimerProducto() {
        find(By.cssSelector(".inventory_list .inventory_item:first-child button")).click();
    }

    public void irAlCarrito() {
        find(By.cssSelector("[data-test='shopping-cart-link']")).click();
        waitFor(ExpectedConditions.urlContains("cart"));
    }

    public void confirmarProducto() {
        String titulo = find(By.className("title")).getText();
        assertThat(titulo).isEqualTo("Your Cart");
        find(By.id("checkout")).click();
    }

    public void completarCheckout(String nombre, String apellido, String postal) {
        find(By.id("first-name")).sendKeys(nombre);
        find(By.id("last-name")).sendKeys(apellido);
        find(By.id("postal-code")).sendKeys(postal);
        find(By.id("continue")).click();
        find(By.id("finish")).click();
    }

    public void verificarMensaje(String mensajeEsperado) {
        String mensaje = find(By.className("complete-header")).getText();
        assertThat(mensaje).isEqualTo(mensajeEsperado);
    }
}
