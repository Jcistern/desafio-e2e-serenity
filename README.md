# 🎯 Desafío E2E - SauceDemo Automation

Automatización de flujo completo de compra en [SauceDemo](https://www.saucedemo.com) usando **Serenity BDD** con patrón **Screenplay Pattern** + Cucumber + Selenium WebDriver.

## ✨ ¿Qué hace este proyecto?

Automatiza el flujo completo de compra con:

✅ **Scenario Simple**: Login → Ordenar → Agregar 1 producto → Checkout → Confirmación  
✅ **Scenario Outline**: Login → Ordenar → Agregar 2 productos → Checkout (3 usuarios: Juan, María, Carlos)  
✅ **Background**: Reutiliza login y ordenamiento en ambos scenarios  
✅ **Data-Driven**: 4 tests totales (1 simple + 3 outline parametrizados)  

## 🛠️ Stack Tecnológico

| Componente | Versión |
|-----------|--------|
| Java | 17 |
| Serenity BDD | 4.1.20 |
| Cucumber | (integrado en Serenity) |
| Selenium WebDriver | 4.21.0 |
| Maven | 3.9+ |
| JUnit | 5 |
| Navegador | Chrome |

## 📋 Requisitos

- **Java 17** instalado
- **Maven 3.9+** instalado
- **Chrome** instalado
- Git configurado

## 🚀 Cómo ejecutar

### Ejecutar todos los tests
```bash
mvn clean verify
```

### Ejecutar solo Scenario Simple (1 producto)
```bash
mvn verify -Dcucumber.filter.tags="@compra-saucedemo-simple"
```

### Ejecutar solo Scenario Outline (2 productos, 3 usuarios)
```bash
mvn verify -Dcucumber.filter.tags="@compra-saucedemo-outline"
```

### Ejecutar y guardar log
```bash
mvn clean verify | tee ejecucion.log
```

### Generar reporte Serenity
```bash
mvn serenity:aggregate
```

## 📊 Resultados Esperados

```
Tests run: 4
Tests passed: 4 ✓
Failures: 0
Errors: 0
Time elapsed: ~55 segundos
Status: BUILD SUCCESS
```

## 📁 Reportes Generados

- **HTML Report**: `target/site/serenity/index.html`
- **Log de ejecución**: `ejecucion.log`
- **Conclusiones**: `conclusiones.md`

## 🏗️ Estructura del Proyecto

```
desafio-e2e-serenity/
├── pom.xml
├── README.md
├── conclusiones.md          ← Análisis consolidado
├── ejecucion.log           ← Log completo de ejecución
├── src/test/
│   ├── java/com/bancaecuador/
│   │   ├── actions/
│   │   │   └── CompraActions.java      (Interacción con UI)
│   │   ├── data/
│   │   │   └── TestData.java           (Datos de prueba)
│   │   ├── runners/
│   │   │   └── TestRunners.java        (Runner de Cucumber)
│   │   ├── steps/
│   │   │   └── CompraSteps.java        (Steps del feature)
│   │   ├── tasks/
│   │   │   └── Login.java              (Task: Autenticación)
│   │   └── ui/
│   │       └── SauceDemoUI.java        (Selectores UI)
│   └── resources/
│       ├── features/
│       │   └── e2e.feature             (Scenarios en Gherkin)
│       ├── datos.json                  (Datos JSON)
│       └── serenity.conf               (Configuración)
└── target/
    └── site/serenity/                  (Reportes HTML)
```

## 🏛️ Patrón Screenplay

El proyecto implementa el **Screenplay Pattern** para máxima reutilización:

```
Tasks (Login.java)
  └── Acciones de alto nivel del usuario

Actions (CompraActions.java)
  └── Interacciones directas con elementos UI

Steps (CompraSteps.java)
  └── Mapeo de Gherkin a Java
```

## 🔧 Configuración Serenity

Archivo: `serenity.conf`

```properties
serenity.browser.maximise.window=true
serenity.webdriver.timeout=10000
serenity.take.screenshots=FOR_EACH_ACTION
```

## 📖 Documentación Adicional

- **conclusiones.md**: Análisis consolidado de hallazgos y métricas
- **ejecucion.log**: Log completo de la ejecución
- **target/site/serenity/index.html**: Reporte visual con screenshots

## 🚀 Próximos Pasos

Para expandir este proyecto:

1. **Casos Negativos**: Login inválido, producto agotado
2. **Performance Testing**: Medir tiempos de carga
3. **CI/CD**: Integrar con Jenkins/GitHub Actions
4. **Más scenarios**: Cambiar cantidad, eliminar productos

**Autor**: Juan Cisterna | **Versión**: 1.0-SNAPSHOT | **Status**: ✅ COMPLETADO
