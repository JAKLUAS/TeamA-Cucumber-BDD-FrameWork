package com.duobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "@target/failedScenarios.txt",
        glue = "com/duotify/stepDefintions",

        plugin = {
                "pretty",
                "html:target/built-in-report/cucumber-html-report.html",
                "json:target/cucumber.json",

        }
    )
   public class FailedScenariosRunner {
 }
