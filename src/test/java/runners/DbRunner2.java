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
import testBase.TestBaseApi2;

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




public class DbRunner2 extends TestBaseApi2 {
    @Test
    public void test2(){

        spec02.pathParams("parameter1","booking","parameter2",5);

        Response response=given().
                accept("application/json").
                spec(spec02).
                when().
                get("/{parameter1}/{parameter2}");

        response.prettyPrint();




        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);


        JsonPath json=response.jsonPath();



        Assert.assertEquals(2,json.getInt("id"));
        Assert.assertEquals("janet.weaver@reqres.in",json.getString("email"));
        Assert.assertEquals("Janet",json.getString("firstname"));
        Assert.assertEquals("Weaver",json.getString("lastname"));
        Assert.assertEquals("https://reqres.in/img/faces/2-image.jpg",json.getString("avatar"));







    }



}