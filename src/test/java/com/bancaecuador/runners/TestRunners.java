package com.bancaecuador.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.bancaecuador.steps",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json"
        }
)

public class TestRunners {

}
