package com.ntuc.income.up;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        //retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        //coverageReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        //includeCoverageTags = {"@Login" },
        outputFolder = "target/")

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.ntuc.income.up.steps","com.ntuc.income.up.setup"},
        plugin = {"pretty","html:target/cucumber","json:target/cucumber.json","usage:target/cucumber-usage.json","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-ExtendedReports/report.html"},
        //tags = {"@Login"},
        monochrome = true
)


public class RunCukesTest {
}
