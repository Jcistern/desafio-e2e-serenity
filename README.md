# Desafío E2E - Banca Ecuador

Automatización de pruebas E2E usando Serenity BDD + Cucumber + Java 17.

## ¿Qué hace este proyecto?

Automatiza el flujo completo de compra en [SauceDemo](https://www.saucedemo.com):

1. Login con credenciales válidas
2. Ordenar productos por precio de menor a mayor
3. Agregar el primer producto al carrito
4. Completar el checkout con datos personales
5. Verificar el mensaje de confirmación de compra

## Requisitos

- Java 17
- Maven 3.9+
- Google Chrome instalado

## Cómo ejecutar

```bash
mvn clean verify
```

## Reporte

El reporte se genera automáticamente al finalizar la ejecución en:

```
target/site/serenity/index.html
```

## Estructura del proyecto

```
desafio-e2e/
├── pom.xml
├── README.md
└── src/
    └── test/
        ├── java/com/bancaecuador/
        │   ├── actions/
        │   │   └── CompraActions.java
        │   ├── data/
        │   │   └── TestData.java
        │   ├── runners/
        │   │   └── TestRunner.java
        │   └── steps/
        │       └── CompraSteps.java
        └── resources/
            ├── features/
            │   └── e2e.feature
            ├── datos.json
            └── serenity.conf
```

## Datos de prueba

Los datos están parametrizados en `src/test/resources/datos.json`:
