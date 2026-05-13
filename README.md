# 🎯 Desafío E2E - SauceDemo Automation

Automatización de flujo completo de compra en [SauceDemo](https://www.saucedemo.com) usando **Serenity BDD** con patrón **Screenplay Pattern** + Cucumber + Selenium WebDriver.

## ✨ ¿Qué hace este proyecto?

Automatiza el flujo completo de compra con:

✅ **Scenario Simple**: Login → Ordenar → Agregar 2 productos → Checkout → Confirmación  
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

### Opción 1: Comando Maven directo (RECOMENDADO)

```bash
mvn clean verify
```

**Esto automáticamente:**
- ✅ Ejecuta todos los tests
- ✅ Genera reportes Serenity
- ✅ Guarda logs organizados por fecha
- ✅ Copia reportes a `test-results/reports/`


### Opción 2: Ejecutar scenarios específicos

**Solo Scenario Simple (1 producto):**
```bash
mvn verify -Dcucumber.filter.tags="@compra-saucedemo-simple"
```

**Solo Scenario Outline (2 productos, 3 usuarios):**
```bash
mvn verify -Dcucumber.filter.tags="@compra-saucedemo-outline"
```

## 📊 Resultados Esperados

```
Tests run: 4
Tests passed: 4 ✓
Failures: 0
Errors: 0
Time elapsed: ~50 segundos
Status: BUILD SUCCESS
```

## 📁 Estructura de Carpetas Generadas

Después de ejecutar `mvn clean verify`, se genera automáticamente:

```
test-results/
├── reports/                    Reportes Serenity HTML
│   ├── index.html             Dashboard principal (ABRE ESTO)
│   ├── screenshots/           Capturas de cada step
│   ├── css/                   Estilos
│   └── js/                    Scripts interactivos
└── ejecucion.log              Log principal
```

## 📊 Cómo ver los reportes

### Opción 1: Desde Windows CMD/PowerShell

```cmd
start test-results\reports\index.html
```

### Opción 2: Manual

1. Abre el Explorador de archivos
2. Ve a `test-results/reports/`
3. Doble clic en `index.html`
4. Se abre en tu navegador

### Opción 3: Copiar ruta completa

La ruta aparece en la consola al final:
```
Full Report: file:///C:/Users/tu_usuario/ruta/test-results/reports/index.html
```

## 📈 Qué ves en los reportes

- ✓ **Dashboard:** Resumen de ejecución (4/4 tests pasados)
- ✓ **Desglose por scenario:** Estado, duración, steps
- ✓ **Screenshots:** Captura de pantalla de cada acción
- ✓ **Timeline:** Secuencia y duración de eventos
- ✓ **Validaciones:** Detalles de cada step

## 📁 Estructura del Proyecto

```
desafio-e2e-serenity/
├── pom.xml                           Configuración Maven
├── README.md                         Este archivo
├── conclusiones.md                   Análisis de resultados
├── execute-tests.bat                 Script Windows
├── execute-tests.ps1                 Script PowerShell
├── src/test/
│   ├── java/com/bancaecuador/
│   │   ├── actions/
│   │   │   └── CompraActions.java    Acciones con UI
│   │   ├── data/
│   │   │   └── TestData.java         Datos de prueba
│   │   ├── runners/
│   │   │   └── TestRunners.java      Runner de Cucumber
│   │   ├── steps/
│   │   │   └── CompraSteps.java      Steps del feature
│   │   ├── tasks/
│   │   │   └── Login.java            Task: Autenticación
│   │   └── ui/
│   │       └── SauceDemoUI.java      Selectores UI
│   └── resources/
│       ├── features/
│       │   └── e2e.feature           Scenarios en Gherkin
│       ├── datos.json                Datos JSON
│       └── serenity.conf             Configuración Serenity
├── test-results/                     GENERADO AUTOMÁTICAMENTE
│   ├── reports/
│   │   ├── index.html
│   │   ├── screenshots/
│   │   ├── css/
│   │   └── js/
│   └── ejecucion.log
└── target/
    └── site/serenity/                Original (Maven)
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

## 📚 Documentación Adicional

- **conclusiones.md**: Análisis consolidado de hallazgos, métricas y mejoras implementadas
- **test-results/reports/index.html**: Reporte visual completo con screenshots


## 🚀 Próximos Pasos

Para expandir este proyecto:

1. **Casos Negativos:** Login inválido, producto agotado
2. **Performance Testing:** Medir tiempos de carga
3. **CI/CD Integration:** Jenkins, GitHub Actions
4. **Más scenarios:** Cambiar cantidad, eliminar productos
5. **Generación PDF:** Exportar reportes automáticamente

---

**Autor:** Juan Cisterna | **Versión:** 1.0 | **Status:** ✅ COMPLETADO | **Última actualización:** 2026-05-13
