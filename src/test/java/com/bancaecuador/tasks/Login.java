package com.bancaecuador.tasks;

import com.bancaecuador.ui.SauceDemoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Login implements Task {

    private final String url;
    private final String usuario;
    private final String contrasena;

    public Login(String url, String usuario, String contrasena) {
        this.url = url;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Step("{0} inicia sesión")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().get(url);
        actor.attemptsTo(
                Enter.theValue(usuario).into(SauceDemoUI.CAMPO_USUARIO),
                Enter.theValue(contrasena).into(SauceDemoUI.CAMPO_CONTRASENA),
                Click.on(SauceDemoUI.BOTON_LOGIN)
        );
    }

    public static Login con(String url, String usuario, String contrasena) {
        return new Login(url, usuario, contrasena);
    }
}
