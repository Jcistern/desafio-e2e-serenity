package com.bancaecuador.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class TestData {

    private String url;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String codigoPostal;

    public static TestData cargar() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream input = TestData.class
                    .getClassLoader()
                    .getResourceAsStream("datos.json");
            return mapper.readValue(input, TestData.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer datos.json", e);
        }
    }

    public String getUrl() {return url; }
    public String getUsuario() { return usuario; }
    public String getContrasena() { return contrasena; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCodigoPostal() { return codigoPostal; }
}