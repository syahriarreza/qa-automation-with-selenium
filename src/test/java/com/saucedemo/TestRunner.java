package com.saucedemo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", // Path to the feature folder
		glue = { "com.saucedemo.stepdefinitions", "com.saucedemo.hook" }, // Package containing step definitions
		monochrome = true, // Display output in a readable format
		plugin = { "pretty", // Pretty console output
				"html:target/cucumber-report.html", // HTML report
				"json:target/cucumber-report.json", // JSON report
				"junit:target/cucumber-report.xml" // JUnit XML report
		})

public class TestRunner extends AbstractTestNGCucumberTests {
}