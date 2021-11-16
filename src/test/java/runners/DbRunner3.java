package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import testBase.TestBaseApi1;
import testBase.TestBaseApi3;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\cucumber-raporlar2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml"},

        features="src/test/resources/features",
        glue="dbStepdefinitions",

        tags="@rapor",

        dryRun=true


)




public class DbRunner3 extends TestBaseApi3 {
    @Test
    public void test3(){

        spec03.pathParams("parameter1","booking","parameter2",5);

        Response response=given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parameter1}/{parameter2}");

        response.prettyPrint();

        response.then().assertThat().statusCode(404).contentType(ContentType.JSON);

        System.out.println(response.getStatusCode());






    }



}