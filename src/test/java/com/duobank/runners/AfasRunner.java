package com.duobank.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        //tags ="@smoke" ,
        features ="src/test/resources",
        glue = "com/duobank/stepDefintions",
        stepNotifications = true,
        plugin = {
                "pretty",
                "html:target/built-in-report/cucmber-html-report.html"

        }

       // ,dryRun = true
)


public class AfasRunner {
}
