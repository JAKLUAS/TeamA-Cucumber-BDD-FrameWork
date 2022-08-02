package com.duobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

 @RunWith(Cucumber.class)
 @CucumberOptions(


    



         tags ="@dt" ,

        features = "src/test/resources", // copy the path from the content root ,path to the folder where features files are located

         glue = "com/duobank/stepDefintions",//copy the path from the source root


//         stepNotifications = true,

         plugin = {
                "pretty",
                 "html:target/built-in-report/cucmber-html-report.html",
                 "json:target/cucumber.json",
                 "rerun:target/failedScenarios.txt"

         }





     //     ,dryRun = true


     )
    public class CucumberRunner {

  }
