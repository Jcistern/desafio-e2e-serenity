package com.bancaecuador.ui;
import net.serenitybdd.screenplay.targets.Target;

public class SauceDemoUI {

    public static final Target CAMPO_USUARIO = Target.the("campo usuario").locatedBy("[data-test='username']");
    public static final Target CAMPO_CONTRASENA = Target.the("campo contraseña").locatedBy("[data-test='password']");
    public static final Target BOTON_LOGIN = Target.the("botón login").locatedBy("[data-test='login-button']");


}
