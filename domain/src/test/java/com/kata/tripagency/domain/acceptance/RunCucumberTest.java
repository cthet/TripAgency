package com.kata.tripagency.domain.acceptance;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("travelFees/calculate_travel_fees.feature")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, "+
        "html:target/cucumber-report.html, " +
        "json:target/cucumber-report.json, " +
        "junit:target/cucumber-reports.xml, " +
        "timeline:target/cucumber-reports, " +
        "usage:target/usage.json, " +
        "rerun:target/rerun.txt"
)
@ConfigurationParameter(key = "cucumber.publish.enabled", value = "true")
public class RunCucumberTest {
}
