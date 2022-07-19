package com.duobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

 @RunWith(Cucumber.class)
 @CucumberOptions(


        features = "src/test/resources", // copy the path from the content root ,path to the folder where features files are located
         glue = "com/duobank/stepDefintions",//copy the path from the source root
         stepNotifications = true,
         plugin = {
                "pretty",
                 "html:target/built-in-report/cucmber-html-report.html"

         }

           // ,dryRun = true
     )
    public class HalilRunner {
  }
