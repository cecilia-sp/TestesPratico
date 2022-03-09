package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        tags = "@ValidarPaginaCheckout",
        glue = {""},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"json:target/cucumber.json", "rerun:target/rerun.txt"})

public class Runner {

}
