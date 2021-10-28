package com.test.glue;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
				glue={"stepDefinition"},
				features = "/project/sitetracker/src/test/resource/features/login.feature",
				tags = "@selenium",
				plugin = {"pretty", "html:target/cucumber-reports.htm"},
				monochrome=true
				)
public class TestRunner {
	


}
