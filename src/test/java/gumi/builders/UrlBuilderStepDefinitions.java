package gumi.builders;

import cucumber.api.java.en.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

public class UrlBuilderStepDefinitions {

    private UrlBuilder builder;

    @Given("^I create an empty builder$")
    public void i_create_an_empty_builder() {
        builder = UrlBuilder.empty();
    }

    @Given("^I create a builder from the string (.*)$")
    public void i_create_a_builder_from_the_string_x(final String urlString) {
        builder = UrlBuilder.fromString(urlString);
    }

    @Given("^I create a builder from the URL (.*)$")
    public void i_create_a_builder_from_the_url_x(final String urlString) throws MalformedURLException {
        builder = UrlBuilder.fromUrl(new URL(urlString));
    }

    @Given("^I create a builder from the (.*) encoded string (.*)$")
    public void i_create_a_builder_from_the_x_encoded_string_y(final String encoding, final String urlString) {
        builder = UrlBuilder.fromString(urlString, encoding);
    }

    @When("^I set the schema to (.*)$")
    public void i_set_the_schema_to_x(final String value) {
        builder = builder.withScheme(value);
    }

    @When("^I set the host to (.*)$")
    public void i_set_the_host_to_x(final String value) {
        builder = builder.withHost(value);
    }

    @When("^I set the path to (.*)$")
    public void i_set_the_path_to_x(final String value) {
        builder = builder.withPath(value);
    }

    @Then("^as a string it should be (.*)$")
    public void as_a_string_it_should_be_x(final String result) {
        assertEquals(result, builder.toString());
    }

    @Then("^as a (.*) encoded string it should be (.*)$")
    public void as_a_y_encoded_string_it_should_be_x(final String encoding, final String result) {
        assertEquals(result, builder.encodeAs(encoding).toString());
    }

    @Then("^the path should be (.*)$")
    public void the_path_should_be_f(final String p) {
        assertEquals(p, builder.path);
    }

    @Then("^the parameter (.*) should be (.*)$")
    public void the_parameter_key_should_be_value(final String key, final String value) {
        assertEquals(value, builder.queryParameters.get(key).get(0));
    }

    @Then("^it should be an empty string$")
    public void it_should_be_an_empty_string() {
        assertEquals("", builder.toString());
    }

}
